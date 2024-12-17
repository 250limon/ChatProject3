package panels.main_window_panels;

import manager.CenterPanelManager;
import user.Friend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatHistoryMessagePanel extends JPanel {
    private Friend friend;
    private Image friend_image;
    private String friend_name;
    public ChatHistoryMessagePanel(Friend friend)
    {
            this.friend=friend;
            friend_image= friend.getImage();
            friend_name= friend.getName();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    CenterPanelManager.getInstance().transToFriendPanel(friend);
                }
            });
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(friend_image,0,0,69,69,this);
        g.setFont(new Font(Font.SERIF,Font.BOLD,20));
        g.drawString(friend_name,80,20);
        g.setColor(Color.GRAY);
        g.fillRect(0,69,300,1);

    }
}
