package panels.main_window_panels;

import user.Friend;

import javax.swing.*;
import java.awt.*;

public class ChatFriendTitle extends JPanel {
    private static ChatFriendTitle chatFriendTitle=new ChatFriendTitle();
    private Friend friend;
    private ChatFriendTitle()
    {

    }

    public  static ChatFriendTitle getInstance()
    {
        return  chatFriendTitle;
    }
    public void init(Friend friend)
    {
        this.friend=friend;
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        if(friend!=null)
        g.drawImage(friend.getImage(), getWidth()/2-100,0,50,50,this);
        g.setFont(new Font(Font.SERIF,Font.BOLD,23));
        g.setColor(Color.BLACK);
        if(friend!=null)
        g.drawString(friend.getName(),getWidth()/2-30,25);



    }
}
