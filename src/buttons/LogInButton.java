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

public class LogInButton extends Button {
    public LogInButton(String title)
    {
        super(title);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                boolean b = UserDAO.getInstance().logIn(LogInPanel.getInstance().getUserName(), LogInPanel.getInstance().getUserPassword());
                if(b)//如果登录成功
                {
                    UserDAO.getInstance().setUser(Integer.parseInt(LogInPanel.getInstance().getUserName()));//设置全局的用户对象
                    FriendDAO.getInstance().setFriends();//设置用户的好友列表
                    LogInJFrame.getInstance().setVisible(false);//登陆界面隐藏
                    MainWindow.getInstance().setVisible(true);//主界面显现
                    MainWindowPanel.getInstance().init();
                    PhoneTools.getInstance().receiveMessage();//接收信息

                }
                else {//如果登陆失败

                }

            }
        });
    }
}
