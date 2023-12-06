package gui;

import utils.ImageLoader;

import javax.swing.*;
import java.awt.*;


public class SidePanel extends JPanel {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -40557434900946408L;

    /**
     * The large font to draw with.
     */
    private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 20);

    /**
     * The medium font to draw with.
     */
    private static final Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);

    /**
     * The small font to draw with.
     */
    private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 12);

    private ImageLoader imageLoader = new ImageLoader();


    public SidePanel() {
        setPreferredSize(new Dimension(200, 4 * 4));
        setBackground(Color.BLACK);
    }

    private static final int STATISTICS_OFFSET = 150;

    private static final int CONTROLS_OFFSET = 320;

    private static final int MESSAGE_STRIDE = 30;

    private static final int SMALL_OFFSET = 30;

    private static final int LARGE_OFFSET = 50;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*
        * Set the color to draw the font in to white.
        */
            g.setColor(Color.WHITE);

        /*
         * Draw the game name onto the window.
         */
        g.setFont(LARGE_FONT);
        g.drawString("Memory Game", getWidth() / 2 - g.getFontMetrics().stringWidth("Memory Game") / 2, 50);

        /*
         * Draw the categories onto the window.
         */
        g.setFont(MEDIUM_FONT);
        g.drawString("Statistics", SMALL_OFFSET, STATISTICS_OFFSET);
        g.drawString("Controls", SMALL_OFFSET, CONTROLS_OFFSET);

        /*
         * Draw the category content onto the window.
         */
        g.setFont(SMALL_FONT);

        //Draw the content for the statistics category.
        int drawY = STATISTICS_OFFSET;
        g.drawString("Unique Items: " + imageLoader.getImagesFromResourceFolder("images").length, LARGE_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("Unique Items found:  " + 0, LARGE_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("Time Left: " + 60 + " s", LARGE_OFFSET, drawY += MESSAGE_STRIDE);

        drawY = CONTROLS_OFFSET;
        g.drawString("Pause the game: P", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("Restart the game: R", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
        g.drawString("End the game: X", LARGE_OFFSET, drawY += MESSAGE_STRIDE);

        }
}


