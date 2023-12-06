package gui;

import utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private static final long serialVersionUID = -1102632585936750607L;
    private static ImageLoader imageLoader = new ImageLoader();
    public static final int COL_COUNT = imageLoader.getImagesFromResourceFolder("images").length / 2;
    public static final int ROW_COUNT = imageLoader.getImagesFromResourceFolder("images").length / 2;
    public static final int TILE_SIZE = 150;

    private TileType[] tiles;

    public GamePanel() {
        this.tiles = new TileType[ROW_COUNT * COL_COUNT];
        setPreferredSize(new Dimension(COL_COUNT * TILE_SIZE, ROW_COUNT * TILE_SIZE));
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
        tiles[y * COL_COUNT + x] = type;
    }

    public TileType getTile(int x, int y) {
        return tiles[y * COL_COUNT + x];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < COL_COUNT; x++) {
            for (int y = 0; y < ROW_COUNT; y++) {
                TileType type = getTile(x, y);
                if (type != null) {
                    drawTile(x * TILE_SIZE, y * TILE_SIZE, type, g);
                }
            }
        }

        // Draw grid lines
        g.setColor(Color.DARK_GRAY);
        for (int x = 0; x <= COL_COUNT; x++) {
            g.drawLine(x * TILE_SIZE, 0, x * TILE_SIZE, getHeight());
        }
        for (int y = 0; y <= ROW_COUNT; y++) {
            g.drawLine(0, y * TILE_SIZE, getWidth(), y * TILE_SIZE);
        }

        // Draw border
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    private void drawTile(int x, int y, TileType type, Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
    }
}
