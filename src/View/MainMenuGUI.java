package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Satinder
public class MainMenuGUI {
    private JFrame myMainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public MainMenuGUI(){
        prepareGUI();
    }
    private void prepareGUI(){
        myMainFrame = new JFrame("Trivia Maze");
        myMainFrame.setSize(600,700);
        myMainFrame.setLayout(new GridLayout(5, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        myMainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5,1));

        myMainFrame.add(headerLabel);
        myMainFrame.add(controlPanel);
        myMainFrame.add(statusLabel);
        myMainFrame.setVisible(true);
    }
    public void showActionListenerDemo(){
        headerLabel.setText("Listener in action: ActionListener");

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        JButton mainMenuButton = new JButton("Play Game");
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.getHSBColor(240,100,70));
        JButton loadButton = new JButton("Load Game");
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.getHSBColor(240,100,72));
        JButton instructButton = new JButton("Instructions");
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.getHSBColor(240,100,74));
        JButton helpButton = new JButton("Help");
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.getHSBColor(240,100,76));
        JButton aboutButton = new JButton("About");


        mainMenuButton.addActionListener(new CustomActionListener());
        panel1.add(mainMenuButton);
        panel2.add(loadButton);
        panel3.add(instructButton);
        panel4.add(helpButton);
        panel5.add(aboutButton);

        controlPanel.add(panel1);
        controlPanel.add(panel2);
        controlPanel.add(panel3);
        controlPanel.add(panel4);
        controlPanel.add(panel5);
        myMainFrame.setVisible(true);
    }
    class CustomActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Now Entering Game...");
        }
    }
}