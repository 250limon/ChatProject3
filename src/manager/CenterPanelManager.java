package manager;

import panels.MainWindowPanel;
import panels.main_content_panel.ChatFriendPanel;
import panels.main_content_panel.MyFriendPanel;
import panels.main_content_panel.SharedRoomPanel;
import panels.main_window_panels.ChatFriendTitle;
import panels.main_window_panels.ChatHistoryPanel;
import user.Friend;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
//用于对主界面中心的展示区域进行管理，主要用于进行界面跳转
public class CenterPanelManager {
    private static CenterPanelManager centerPanelManager=new CenterPanelManager();
    private Map<String, JPanel>centerPanelMap=new HashMap<>();
    private JPanel currentCenterJPanel;
    private CenterPanelManager()
    {
        centerPanelMap.put("chat_panel", ChatFriendPanel.getInstance());
        centerPanelMap.put("shared_room_panel", SharedRoomPanel.getInstance());
        centerPanelMap.put("my_friend_panel", MyFriendPanel.getInstance());
        currentCenterJPanel=centerPanelMap.get("chat_panel");

    }

    public static CenterPanelManager getInstance()
    {
        return centerPanelManager;
    }
    public void addCenterPanel(String name,JPanel jPanel)
    {
        centerPanelMap.put(name,jPanel);
    }
    public JPanel getCurrentCenterJPanel()
    {
        return currentCenterJPanel;
    }

    //点击按钮进行跳转
    public void  transToPanel(String name)
    {
           int x=currentCenterJPanel.getX();
           int y=currentCenterJPanel.getY();
           int width=currentCenterJPanel.getWidth();
           int height=currentCenterJPanel.getHeight();
        //删除原来的jpanel
        MainWindowPanel.getInstance().remove(currentCenterJPanel);
        currentCenterJPanel=centerPanelMap.get(name);
        MainWindowPanel.getInstance().add(currentCenterJPanel);
        currentCenterJPanel.setBounds(x,y,width,height);
        MainWindowPanel.getInstance().revalidate();
        MainWindowPanel.getInstance().repaint();

    }
    //点击消息列表进行跳转
    public void transToFriendPanel(Friend friend)
    {
        int x=currentCenterJPanel.getX();
        int y=currentCenterJPanel.getY();
        int width=currentCenterJPanel.getWidth();
        int height=currentCenterJPanel.getHeight();
        //删除原来的jpanel
        MainWindowPanel.getInstance().remove(currentCenterJPanel);
        currentCenterJPanel=centerPanelMap.get("chat_panel");
        ChatFriendPanel chatFriendPanel=(ChatFriendPanel)currentCenterJPanel;
        chatFriendPanel.init(friend);
        ChatFriendTitle.getInstance().init(friend);


        MainWindowPanel.getInstance().add(currentCenterJPanel);
        currentCenterJPanel.setBounds(x,y,width,height);
        MainWindowPanel.getInstance().revalidate();
        MainWindowPanel.getInstance().repaint();
    }


}
