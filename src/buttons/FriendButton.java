package buttons;

import manager.CenterPanelManager;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//好友搜索按钮
public class FriendButton extends Button {
    private static FriendButton friendButton=new FriendButton();
    private FriendButton()
    {
        super("我的好友");
        setBackground(Color.GREEN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CenterPanelManager.getInstance().transToPanel("my_friend_panel");
            }
        });
    }
    public static FriendButton getInstance()
    {
        return friendButton;
    }

}
