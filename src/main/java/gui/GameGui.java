package gui;

import utils.ImageLoader;

import javax.swing.*;

public class GameGui extends JFrame {

    private ImageLoader imageLoader = new ImageLoader();

    public GameGui() {
        // Set the title of the frame
        setTitle("Memory gui.Game - Flipping Tiles");

        String[] images = imageLoader.getImagesFromResourceFolder("images");



        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800); // Set the frame size to 600x600
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(GameGui::new);
    }
}
