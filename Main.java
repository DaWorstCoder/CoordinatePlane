import javax.swing.*;
import java.awt.*;

class Main extends JPanel{
    static String str = "";

    static final int width = 400;
    static final int height = 400;
    static double maxX = 10; // <-- Change this to change the max X on the graph
    static double maxY = 10; // <-- Change this to change the max Y on the graph
    

    public static void main(String[] args) {
        JFrame frame = new JFrame("Desmos Lite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height + 23);

        Main panel = new Main();
        Mouse mouse = new Mouse();

        panel.addMouseListener(mouse);
        frame.add(panel);
        frame.setVisible(true);
        
    }

    static double f(double x) {
        return pow(x, cos(x));    // <-- Write your function here
    }    
    

    public void paintComponent(Graphics g) {
        g.setColor(new Color(44, 58, 82));
        g.fillRect(0, 0, width, height);
        
        draw.Plane(g);
        
        draw.Func(g);
        
        //draw.Deriv(g);    // <-- Shows the derivative graph

        //draw.Int(0, .5, g); // <-- Shows the integral from an upper and lower limit
        
    }

    static double reverseConvert(int x) {
        double thingy = (x-width/2);
        return Math.round(thingy/(width/2) * maxX);
    }    


//To make life easier
    static double sqrt(double x) {
        return Math.sqrt(x);
    }

    static double sin(double x) {
        return Math.sin(x);
    }

    static double cos(double x) {
        return Math.cos(x);
    }   

    static double tan(double x) {
        return Math.tan(x);
    }    

    static double abs(double x) {
        return Math.sqrt(x);
    }

    static double e = Math.E;

    static double pi = Math.PI;

    static double pow(double x, double e) {
        return Math.pow(x, e);
    }


}