package com.exampletest.demo.backend_controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineStorageWebsiteController {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Online Storage Website Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(6, 2));

        // On/Off toggle buttons for the options
        JButton toggleOnOff = createToggleButton("On/Off");
        JButton toggleAcceptingInput = createToggleButton("Accepting Input");
        JButton toggleConnectSQL = createToggleButton("Connect to SQL");
        JButton toggleConnectReacts = createToggleButton("Connect to Reacts");

        // Restart button
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actions.restart();
            }
        });

        // Placeholder for Traffic Data image
        JLabel trafficDataLabel = new JLabel("Traffic Data Placeholder", SwingConstants.CENTER);
        trafficDataLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Placeholder for Users image
        JLabel usersLabel = new JLabel("Users Placeholder", SwingConstants.CENTER);
        usersLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add components to the control panel
        controlPanel.add(toggleOnOff);
        controlPanel.add(toggleAcceptingInput);
        controlPanel.add(toggleConnectSQL);
        controlPanel.add(toggleConnectReacts);
        controlPanel.add(restartButton);

        // Create a panel for images
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 2));
        imagePanel.add(trafficDataLabel);
        imagePanel.add(usersLabel);

        // Add panels to the frame
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(imagePanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static JButton createToggleButton(String text) {
        JButton button = new JButton(text + ": OFF");
        button.setBackground(Color.RED);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getText().endsWith("OFF")) {
                    button.setText(text + ": ON");
                    button.setBackground(Color.GREEN);
                    Actions.turnOn(text); // Call specific method for turning on
                } else {
                    button.setText(text + ": OFF");
                    button.setBackground(Color.RED);
                    Actions.turnOff(text); // Call specific method for turning off
                }
            }
        });
        return button;
    }

    // Actions class to handle backend interactions
    static class Actions {

        // Method to handle the restart action
        public static void restart() {
            System.out.println("Restart triggered.");
            // Additional backend logic can be added here
        }

        // Method to turn on specific features
        public static void turnOn(String option) {
            System.out.println(option + " turned ON");
            switch (option) {
                case "On/Off":
                    turnOnOff();
                    break;
                case "Accepting Input":
                    setAcceptingInput(true);
                    break;
                case "Connect to SQL":
                    connectToSQL();
                    break;
                case "Connect to Reacts":
                    connectToReacts();
                    break;
                default:
                    System.out.println("Unknown option for ON.");
            }
        }

        // Method to turn off specific features
        public static void turnOff(String option) {
            System.out.println(option + " turned OFF");
            switch (option) {
                case "On/Off":
                    turnOff(option);
                    break;
                case "Accepting Input":
                    setAcceptingInput(false);
                    break;
                case "Connect to SQL":
                    disconnectFromSQL();
                    break;
                case "Connect to Reacts":
                    disconnectFromReacts();
                    break;
                default:
                    System.out.println("Unknown option for OFF.");
            }
        }

        // Method to turn On/Off
        public static void turnOnOff() {
            System.out.println("Turning system On/Off...");
            // Backend logic for turning the system on/off
        }

        // Method to set Accepting Input
        public static void setAcceptingInput(boolean accepting) {
            if (accepting) {
                System.out.println("System is now accepting input.");
            } else {
                System.out.println("System is no longer accepting input.");
            }
            // Backend logic for accepting input
        }

        // Method to connect to SQL
        public static void connectToSQL() {
            System.out.println("Connecting to SQL...");
            // Backend logic to connect to SQL
        }

        // Method to disconnect from SQL
        public static void disconnectFromSQL() {
            System.out.println("Disconnecting from SQL...");
            // Backend logic to disconnect from SQL
        }

        // Method to connect to Reacts
        public static void connectToReacts() {
            System.out.println("Connecting to Reacts...");
            // Backend logic to connect to Reacts
        }

        // Method to disconnect from Reacts
        public static void disconnectFromReacts() {
            System.out.println("Disconnecting from Reacts...");
            // Backend logic to disconnect from Reacts
        }
    }
}

