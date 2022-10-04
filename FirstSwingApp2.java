import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
public class FirstSwingApp2
{
    public static void createAndShowGUI()
    {
        JFrame mainFrame = new JFrame("Swing Example");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(2, 2));

        JLabel topLabel = new JLabel("",JLabel.CENTER );
        topLabel.setText("Hello Swing World!");
        mainFrame.add(topLabel);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                topLabel.setText("Ok Button clicked.");
            }
        });

        JButton doorBell = new JButton("Door Bell");
        doorBell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                topLabel.setText("Ding Dong");
            }
        });

        mainFrame.add(doorBell);
        mainFrame.add(okButton);
        mainFrame.setVisible(true);
    }
    public static void main(String[] args)
    {
        createAndShowGUI();
    }
}
