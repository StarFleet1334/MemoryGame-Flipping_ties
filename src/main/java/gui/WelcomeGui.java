package gui;

import utils.HoverButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class WelcomeGui extends JFrame {

    public WelcomeGui() {
        // Set the title of the frame
        setTitle("Memory Game - Flipping Tiles");

        // Create a welcome header label
        JLabel welcomeLabel = new JLabel("Welcome to Memory Game!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setBounds(50, 50, 350, 50); // Set bounds for the label

        // Create a button to start the game
        HoverButton startButton = createStyledButton("Start", 150, 150);

        // Create a button to visit options of the game
        HoverButton optionButton = createStyledButton("Options", 150, 200);

        // Create a button to exit the game
        HoverButton exitButton = createStyledButton("Exit", 150, 250);

        // Create a panel with null layout to position components explicitly
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(230, 230, 250)); // Set background color

        // Add a border to the panel
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Add components to the panel
        panel.add(welcomeLabel);
        panel.add(startButton);
        panel.add(optionButton);
        panel.add(exitButton);


        // Add the panel to the frame
        add(panel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private HoverButton createStyledButton(String text, int x, int y) {
        HoverButton button = new HoverButton(text);
        button.setBounds(x, y, 100, 30); // Set bounds for the button
        button.setFocusPainted(false); // Remove focus border

        switch (text) {
            case "Start": {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Add code here to handle button click
                        GameGui game = new GameGui();
                    }
                });
                break;
            }
            case "Options": {
                break;
            }
            case "Exit": {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dispose(); // Close the frame
                        }
                    }
                });
                break;
            }
        }
        return button;
    }



    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(WelcomeGui::new);
    }
}
