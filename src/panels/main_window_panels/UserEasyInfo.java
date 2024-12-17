package panels.main_window_panels;

import user.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.File;

public class UserEasyInfo extends JPanel {

    private Image user_image;
    private int width;
    private int height;
    private int x;
    private int y;
    public UserEasyInfo(int x,int y,int width,int height)
    {

        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;



        setBackground(Color.RED);
        setVisible(true);
        addMouseListener(new MouseEvent());

       try {
            user_image= ImageIO.read(new File("resource/icons/yoimiya7.jpg"));
       }catch (Exception e)
       {
           e.printStackTrace();
       }

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(User.getInstance().getUser_image(), 0, 0, 60, 60, this);
        Graphics2D graphics2D=(Graphics2D) g;
        graphics2D.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        graphics2D.drawString(User.getInstance().getName(), 70,30);


    }
    class MouseEvent extends MouseAdapter {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            UserDetailedInfo userDetailedInfo=UserDetailedInfo.getInstance();
            if(userDetailedInfo.isShow())
            {
                userDetailedInfo.setVisible(false);
                userDetailedInfo.setShow(false);


            }
            else {
                userDetailedInfo.setVisible(true);
                userDetailedInfo.setShow(true);
                userDetailedInfo.setLocation(x,y-30);
            }


        }
    }




}
