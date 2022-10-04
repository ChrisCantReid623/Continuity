import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class ShapeTest
{
    static List<Shape> shapes = new ArrayList<>();

    public static void createAndShowGUI()
    {
        JFrame mainFrame = new JFrame("Shapes!");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600,400);

        JPanel mainPanel = new JPanel(null);
        JPanel widgetsPanel  = new JPanel();
        widgetsPanel.setLocation(400, 0);
        widgetsPanel.setSize(200,400);

        JTextField textField = new JTextField("Circles");
        textField.setColumns(10);
        widgetsPanel.add(textField);

        mainPanel.add(widgetsPanel);

        JPanel graphicsPanel  = new GPanel();
        graphicsPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + "  " + e.getY());
                if (textField.getText().equals("Circles"))
                {
                    Circle c = new Circle(e.getX(), e.getY(), 20.0, Color.red);
                    shapes.add(c);
                }
                else if (textField.getText().equals("Rectangles"))
                {
                    Rectangle r = new Rectangle( e.getX(), e.getY(), 20, 20, Color.green );
                    shapes.add(r);
                }

                graphicsPanel.repaint();
            }
        });

        graphicsPanel.setLocation(0, 0);
        graphicsPanel.setSize(400,400);
        graphicsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.add(graphicsPanel);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        createAndShowGUI();
    }

    private static class GPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            int width = getSize().width;
            int height = getSize().height;
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);
            for (Shape s: shapes)
                if (s instanceof Circle)   // not the best way
                {
                    Circle c = (Circle)s;
                    g.setColor(c.getColor());
                    g.fillOval(c.getX(), c.getY(), (int)c.getRadius(), (int)c.getRadius());
                }
                else if (s instanceof Rectangle)
                {
                    Rectangle r = (Rectangle)s;
                    g.setColor(r.getColor());
                    g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
                }
        }
    }
}

abstract class Shape
{
    protected int x, y;
    protected Color color;

    public Shape()
    {
        x = y = 0;
    }

    public Shape(int x, int y, Color c)
    {
        this.x = x;
        this.y = y;
        color = c;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return color; }
    abstract double getArea();
}

class Circle extends Shape
{
    private double radius;
    private static int numberOfCircles = 0;

    public Circle()
    {
        super();
        radius = 1;
        numberOfCircles++;
    }

    public Circle(int x, int y, double newRadius, Color c)
    {
        super(x, y, c);
        radius = newRadius;
        numberOfCircles++;
    }

    public void setRadius(double newRadius) { radius = newRadius; }
    public double getRadius() { return radius; }
    public double getArea() { return radius * radius * Math.PI; }
    public static int getNumberOfCircles() { return numberOfCircles; }
}


class Rectangle extends Shape
{
    private int width;
    private int height;
    private static int numberOfRectangles = 0;

    public Rectangle()
    {
        super();
        width = height = 1;
        numberOfRectangles++;
    }

    public Rectangle( int x, int y,  int w, int h, Color c )
    {
        super(x, y, c);
        width = w;
        height = h;
        numberOfRectangles++;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public double getArea() { return width * height; }
    public static int getNumberOfRectangles() { return numberOfRectangles; }
}
