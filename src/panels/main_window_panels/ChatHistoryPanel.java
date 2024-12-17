package panels.main_window_panels;

import panels.MainWindowPanel;
import panels.main_content_panel.ChatFriendPanel;
import user.Friend;
import user.User;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChatHistoryPanel extends JPanel {
    private static ChatHistoryPanel chatHistoryPanel=null;
    private JPanel chatMessageArea; // 聊天记录文本区域
    private List<JPanel>chatMessagePanels = new ArrayList<>(); // 聊天记录面板列表
    private ChatHistoryPanel() {
        setLayout(new BorderLayout()); // 使用边界布局

        setBackground(Color.pink);


        chatMessageArea = new JPanel();
        chatMessageArea.setLayout(null);
        chatMessageArea.setPreferredSize(new Dimension(300, 700));


        JScrollPane scrollPane = new JScrollPane(chatMessageArea); // 创建滑动面板
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // 设置垂直滚动条始终显示
        add(scrollPane, BorderLayout.CENTER); // 将滑动面板添加到面板的中心
    }

    public void init() {
        List<Friend>friends= User.getInstance().getFriends();
        for(int i=0;i<friends.size();i++)
        {
            chatMessagePanels.add(new ChatHistoryMessagePanel(friends.get(i)));
        }
        for(int i=0;i<chatMessagePanels.size();i++)
        {
            chatMessageArea.add(chatMessagePanels.get(i));
            chatMessagePanels.get(i).setBounds(0,70*i,300,70);

        }
        if(chatMessagePanels.size()>7)
        {
            chatMessageArea.setPreferredSize(new Dimension(300, 70*chatMessagePanels.size()));
        }
        //初始化为第一个朋友
        if(!User.getInstance().getFriends().isEmpty())
        {
            ChatFriendPanel.getInstance().init(User.getInstance().getFriends().get(0));
            ChatFriendTitle.getInstance().init(User.getInstance().getFriends().get(0));
        }






    }

    public static ChatHistoryPanel getInstance() {
        if(chatHistoryPanel==null)
        {
            chatHistoryPanel=new ChatHistoryPanel();
        }
        return chatHistoryPanel;
    }

    // 添加聊天记录的方法
    public void addChatMessage(JPanel messagePanel) {
        chatMessagePanels.add(messagePanel);
        chatMessageArea.add(messagePanel);
        if(chatMessagePanels.size()>7)
        {
            chatMessageArea.setPreferredSize(new Dimension(300, 70*chatMessagePanels.size()));
        }
        chatMessageArea.revalidate();
        chatMessageArea.repaint();
    }
    public void ChatMessagePanelRepaint()
    {
        for(JPanel jPanel:chatMessagePanels)
        {
            jPanel.repaint();
        }
    }
}

