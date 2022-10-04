import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
public class FirstSwingApp
{
    public static void createAndShowGUI()
    {
        JFrame mainFrame = new JFrame("Swing Example");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(2, 1));

        JLabel topLabel = new JLabel("",JLabel.CENTER );
        topLabel.setText("Hello Swing World!");
        mainFrame.add(topLabel);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                topLabel.setText("Ok Button clicked.");
            }
        });
        mainFrame.add(okButton);
        mainFrame.setVisible(true);
    }
    public static void main(String[] args)
    {
        createAndShowGUI();
    }}
