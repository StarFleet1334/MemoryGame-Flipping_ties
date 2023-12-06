package gui;

import utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GamePanel extends JPanel {

    private static final long serialVersionUID = -1102632585936750607L;
    private static ImageLoader imageLoader = new ImageLoader();
    public static final int TILE_SIZE = 150;

    private TileType[] tiles;
    private int rowCount;
    private int colCount;

    private String[] shuffledImages;

    public GamePanel() {
        String[] images = imageLoader.getImagesFromResourceFolder("images");
        // Duplicate the array by concatenating it with itself
        // Duplicate the array by concatenating it with itself
        String[] duplicatedImages = new String[images.length * 2];
        System.arraycopy(images, 0, duplicatedImages, 0, images.length);
        System.arraycopy(images, 0, duplicatedImages, images.length, images.length);

// Convert the array to a list for shuffling
        List<String> shuffledList = new ArrayList<>(Arrays.asList(duplicatedImages));

// Shuffle the list
        Collections.shuffle(shuffledList);

// Convert the list back to an array
        shuffledImages = shuffledList.toArray(new String[0]);


        // Set the number of rows and columns based on the number of images
        setGridSize(images.length);

        this.tiles = new TileType[rowCount * colCount];

        // Set the size of the panel based on the number of rows and columns
        setPreferredSize(new Dimension(colCount * TILE_SIZE, rowCount * TILE_SIZE));
        setBackground(Color.BLACK);
    }

    public void clearBoard() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = null;
        }
    }

    public void setTile(Point point, TileType type) {
        setTile(point.x, point.y, type);
    }

    public void setTile(int x, int y, TileType type) {
        tiles[y * colCount + x] = type;
    }

    public TileType getTile(int x, int y) {
        return tiles[y * colCount + x];
    }

    public void setGridSize(int numberOfFiles) {
        // Calculate the number of rows and columns for the grid
        colCount = Math.max(1, (int) Math.ceil(Math.sqrt(numberOfFiles)));
        rowCount = Math.max(1, (int) Math.ceil((double) numberOfFiles / colCount));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        for (int x = 0; x < colCount; x++) {
            for (int y = 0; y < rowCount; y++) {
                TileType type = getTile(x, y);
                if (type != null) {
                    drawTile(x * TILE_SIZE, y * TILE_SIZE, type, g,shuffledImages[i]);
                    i++;
                }
            }
        }

        // Draw grid lines
        g.setColor(Color.DARK_GRAY);
        for (int x = 0; x <= colCount; x++) {
            g.drawLine(x * TILE_SIZE, 0, x * TILE_SIZE, getHeight());
        }
        for (int y = 0; y <= rowCount; y++) {
            g.drawLine(0, y * TILE_SIZE, getWidth(), y * TILE_SIZE);
        }

        // Draw border
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    private void drawTile(int x, int y, TileType type, Graphics g,String image) {
        // Load the image from the file
        Image img = Toolkit.getDefaultToolkit().getImage(image);

        // Wait for the image to be fully loaded before drawing
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(img, 0);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Draw the image
        g.drawImage(img, x, y, TILE_SIZE, TILE_SIZE, this);
    }
}
