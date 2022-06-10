import java.awt.*;

class draw {
    static int width = Main.width;
    static int height = Main.height;
    static double maxX = Main.maxX;
    static double maxY = Main.maxY;
    
    //Converts coordinate plane x values to JFrame values
    static int convertorX(double x) {
        double thingy = (double) x/maxX;
        double thingy2 = thingy * (width/2) + width/2 ;
        return (int) Math.round(thingy2);
    }

    //Converts coordinate plane y values to JFrame values
    static int convertorY(double y) {
        double thingy = (double) -y/maxY;
        double thingy2 = thingy * (height/2) + height/2 ;
        return (int) Math.round(thingy2);
    }


    //Draws the coordnate plane with lines and numbers
    static void Plane(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < width; i += width/8) {
            g.drawLine(i, 0, i, height);
        }
        for (int i = 0; i < height; i += height/8) {
            g.drawLine(0, i, width, i);
        }
        g.fillRect(width/2 - 1, 0, 4, height);
        g.fillRect(0, height/2 + 1, width, 2);

        g.drawString(" " + (double) maxY/2, width/2, height/4);
        g.drawString(" " + (double) -maxY/2, width/2, 3 * height/4);
        g.drawString(" " + (double) -maxX/2, width/4, height/2);
        g.drawString(" " + (double) maxX/2, 3 * width/4, height/2);

    }

    //Essentially just plugging x into the function and making a line from each result. num is the distance between x used to make the line
    static void Func(Graphics g) {
        g.setColor(Color.red);
        double num = .1;
        for (double x = -maxX + num; x < maxX; x += num) {
            double y = Main.f(x);
            double prevX = Main.f(x-num);
            g.drawLine(convertorX(x-num), convertorY(prevX), convertorX(x), convertorY(y));
        }

    }

    //Draws the derivitive of the function by finding the slope of every point and graphing it
    static void Deriv(Graphics g) {
        g.setColor(Color.cyan);
        double num = .1;
        for (double x = -maxX + num; x < maxX; x += num) {
            double y = Main.f(x);
            double nextY = Main.f(x + num);
            double prevY = Main.f(x-num);
            double slope = (nextY-prevY)/.2;

            double nextY2 = Main.f(x);
            double prevY2 = Main.f(x - 2 * num);
            double slope2 = (nextY2-prevY2)/.2;
            g.drawLine(convertorX(x-num), convertorY(slope2), convertorX(x), convertorY(slope));
        }        
    }

    //Draws and prints an integral based on the range
    static void Int(double lower, double upper, Graphics g) {
        g.setColor(new Color(255, 0, 0, 50));
        double area = 0;
        double num = .00001;
        for (double x = lower; x < upper; x += num) {
            double y = Main.f(x);
            double prevY = Main.f(x-num);
            
            int[] xValues = {convertorX(x - num), convertorX(x - num), convertorX(x), convertorX(x)};
            int[] yValues = {convertorY(0), convertorY(prevY), convertorY(y), convertorY(0)};

            area += num * .5 * (y + prevY);
            g.fillPolygon(xValues, yValues, 4);
        }
        g.setColor(Color.red);
        g.drawLine(convertorX(upper), convertorY(0), convertorX(upper), convertorY(Main.f(upper)));
        System.out.println(area);
    }

}