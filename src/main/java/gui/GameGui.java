package gui;

import utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class GameGui extends JFrame {

    private ImageLoader imageLoader = new ImageLoader();

    private SidePanel sidePanel = new SidePanel();

    private GamePanel gamePanel = new GamePanel();

    public GameGui() {
        // Set the title of the frame
        setLayout(new BorderLayout());
        setTitle("Memory gui.Game - Flipping Tiles");

        String[] images = imageLoader.getImagesFromResourceFolder("images");

        add(gamePanel,BorderLayout.CENTER);
        add(sidePanel,BorderLayout.EAST);
        sidePanel.repaint();
        gamePanel.repaint();

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800); // Set the frame size to 600x600
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(GameGui::new);
    }
}
