package manager;

import user.Friend;
import user.User;
import utils.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用于管理聊天信息的管理类,单例模式
//存储与好友的聊天记录
public class ChatMessageManager {
    private static ChatMessageManager chatMessageManager=new ChatMessageManager();
    private Map<Friend, List<Message>>messageMap=new HashMap<>();
    private ChatMessageManager()
    {

    }
    public static ChatMessageManager getInstance()
    {
        return chatMessageManager;
    }
    //添加消息
    public void addMessage(Friend friend,Message message)
    {
        messageMap.get(friend).add(message);
    }
    //获取与某个好友的聊天记录
    public List<Message> getMessages(Friend friend)
    {
        return messageMap.get(friend);
    }
    public void addMessageById(int id,String content)
    {
        List<Friend>friends= User.getInstance().getFriends();

        for(Friend friend:friends)
        {
            if(friend.getId()==id)
            {
                Message message=new Message(id,content);
                addMessage(friend,message);
                break;
            }
        }

    }

}
