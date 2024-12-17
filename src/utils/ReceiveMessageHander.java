package utils;

import manager.ChatMessageManager;
import panels.MainWindowPanel;
import user.User;
//单例模式
//在接受到消息后的处理操作
public class ReceiveMessageHander {
    private static ReceiveMessageHander receiveMessageHander=new ReceiveMessageHander();
    private ReceiveMessageHander()
    {

    }
    public static ReceiveMessageHander getInstance()
    {

        return  receiveMessageHander;

    }
    //发挥作用的处理函数
    public void hander(int id,String content)
    {

        //将收到的信息添加到
        ChatMessageManager.getInstance().addMessageById(id,content);

        //如果接受的是上线的消息,并且是朋友的消息
        if(content.equals("live")&&User.getInstance().isMyFriend(id))
        {
            //将该朋友设置为上线
            User.getInstance().setFriendLive(id);
            //其他操作
        }else {
            //将相应的消息加入到具有该id的朋友的信息列表中
            ChatMessageManager.getInstance().addMessageById(id,content);
            //其他操作

        }



    }
}
