import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int startScore = 0;
    private int totalBricks = 21;


    // how fast the ball will move...
    private Timer timer;
    // the speed we will pass to timer later
    private int timerDelay = 8;

    //slider's starting position measured in pixels
    private int sliderPos = 310;

    //ball's starting position pixels.
    private int ballPosX = 120;
    private int ballPosY= 350;

    //direction of the ball
    private int ballDirX = -1;
    private int ballDirY = -2;


    public Game(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer (timerDelay, this);
        timer.start();

    }

    public void paint (Graphics graphics){
        //background
            graphics.setColor(Color.black);
            //x & y refer to the starting position of the background, height and width are the actual size of the rectangle
            graphics.fillRect(1,1,692,592);

            //borders
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0,0,3,592);
        graphics.fillRect(0,0,692, 3);

        //the 684 number was eyeballed, the guy on the video uses 691 but it did not worked here, dunno why.
        graphics.fillRect(684, 0 , 3, 592); //no bottom border because the ball needs to be able to touch the end of the box

        //the thingy to stop the ball
        graphics.setColor(Color.magenta);
        graphics.fillRect(sliderPos,550, 100, 8);

        // the ball
        graphics.setColor(Color.green);
        graphics.fillOval(ballPosX, ballPosY, 20, 20);



    }






    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        if (sliderPos >= 560){
            sliderPos = 560;
        }
        play = true;
        sliderPos += 20;
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        if (sliderPos <= 23){
            sliderPos = 23;
        }
        play = true;
        sliderPos -= 20;
    }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
