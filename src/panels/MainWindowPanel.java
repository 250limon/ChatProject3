package panels;

import buttons.ChatHistoryShowButton;
import buttons.FriendButton;
import buttons.SettingButton;
import buttons.SharedButton;
import manager.CenterPanelManager;
import panels.main_window_panels.*;

import javax.swing.*;
import java.awt.*;

public class MainWindowPanel extends JPanel {
   private static MainWindowPanel mainWindowPanel=new MainWindowPanel();
   private final int titleWidth=375;
    private final int titleHeight=50;
    private final int titleY=100;

    private MainWindowPanel()
    {
        setLayout(null);
        setBackground(Color.CYAN);
        addPanel();
        addButton();
    }
    public static MainWindowPanel getInstance()
    {
        return mainWindowPanel;
    }


    public void addPanel()
    {
        add(UserDetailedInfo.getInstance());
        UserDetailedInfo.getInstance().setBounds(0,0,300,500);
        UserEasyInfo userEasyInfo=new UserEasyInfo(100,100,100,100);
        add(userEasyInfo);
        userEasyInfo.setBounds(100,0,300,60);

        ToolsPanel toolsPanel=ToolsPanel.getInstance();
        add(toolsPanel);
        toolsPanel.setBounds(0,160,50,640);


        ChatHistoryPanel chatHistoryPanel=ChatHistoryPanel.getInstance();

        add(chatHistoryPanel);
        chatHistoryPanel.setBounds(-300,100,300,700);


        add(CenterPanelManager.getInstance().getCurrentCenterJPanel());
        CenterPanelManager.getInstance().getCurrentCenterJPanel().setBounds(60,150,1140,650);


        add(ChatFriendTitle.getInstance());
        ChatFriendTitle.getInstance().setBounds(60,titleY,titleWidth,titleHeight);

    }
    public void addButton()
    {
        SettingButton settingButton=new SettingButton();
        add(settingButton);
        settingButton.setBounds(1100,0,50,50);

        ChatHistoryShowButton chatHistoryShowButton=new ChatHistoryShowButton();
        add(chatHistoryShowButton);
        chatHistoryShowButton.setBounds(0,100,50,50);

        SharedButton sharedButton=SharedButton.getInstance();
        add(sharedButton);
        sharedButton.setBounds(ChatFriendTitle.getInstance().getX()+titleWidth,titleY,titleWidth,titleHeight);


        FriendButton friendButton=FriendButton.getInstance();
        add(friendButton);
        friendButton.setBounds(sharedButton.getX()+titleWidth,titleY,titleWidth,titleHeight);

    }
    public void init()
    {
        ChatHistoryPanel.getInstance().init();
    }
}
