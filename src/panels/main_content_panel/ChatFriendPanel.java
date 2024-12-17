package panels.main_content_panel;

import manager.ChatMessageManager;
import user.Friend;
import utils.Message;

import javax.swing.*;
import java.awt.*;
import java.util.List;
//与好友聊天的界面
public class ChatFriendPanel extends JPanel {
    private Friend friend;//当前正在聊天的好友
    private List<Message>messages;//与该好友的聊天记录


    private static ChatFriendPanel chatFriendPanel=new ChatFriendPanel();
    private ChatFriendPanel()
    {
       setBackground(Color.GRAY);
       setLayout(null);

    }
    public static ChatFriendPanel getInstance()
    {

        return chatFriendPanel;

    }
    //初始化界面
    public void init(Friend friend)
    {
        this.friend=friend;
        messages= ChatMessageManager.getInstance().getMessages(friend);
    }
    //接受消息后，如何处理
    public void receiveMessage()
    {

    }
    //发送消息后，如何处理
    public void sendMessage()
    {

    }
}
