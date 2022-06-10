import java.awt.event.*;

class Mouse implements MouseListener, MouseMotionListener {


    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();                  System.out.println(Main.reverseConvert(x) + ", " + Main.f(Main.reverseConvert(x)));
        
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}