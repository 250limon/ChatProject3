package buttons;

import database.FriendDAO;
import database.UserDAO;
import frames.LogInJFrame;
import frames.MainWindow;
import panels.MainWindowPanel;
import panels.panel_login.LogInPanel;
import user.User;
import utils.PhoneTools;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterButton extends Button {
    public RegisterButton(String title)
    {
        super(title);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id = UserDAO.getInstance().register(LogInPanel.getInstance().getUserName(), LogInPanel.getInstance().getUserPassword());


                UserDAO.getInstance().createFriendsTable(id);
               //获取用户
                UserDAO.getInstance().setUser(id);
                FriendDAO.getInstance().setFriends();//设置好友的列表，此时为新注册的用户，好友列表应为空
                MainWindow.getInstance().setVisible(true);
                LogInJFrame.getInstance().setVisible(false);
                MainWindowPanel.getInstance().init();

                PhoneTools.getInstance().receiveMessage();//接收信息

            }
        });
    }
}
