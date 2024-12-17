package utils;

import manager.ChatMessageManager;
import panels.MainWindowPanel;
import user.User;
//����ģʽ
//�ڽ��ܵ���Ϣ��Ĵ������
public class ReceiveMessageHander {
    private static ReceiveMessageHander receiveMessageHander=new ReceiveMessageHander();
    private ReceiveMessageHander()
    {

    }
    public static ReceiveMessageHander getInstance()
    {

        return  receiveMessageHander;

    }
    //�������õĴ�����
    public void hander(int id,String content)
    {

        //���յ�����Ϣ��ӵ�
        ChatMessageManager.getInstance().addMessageById(id,content);

        //������ܵ������ߵ���Ϣ,���������ѵ���Ϣ
        if(content.equals("live")&&User.getInstance().isMyFriend(id))
        {
            //������������Ϊ����
            User.getInstance().setFriendLive(id);
            //��������
        }else {
            //����Ӧ����Ϣ���뵽���и�id�����ѵ���Ϣ�б���
            ChatMessageManager.getInstance().addMessageById(id,content);
            //��������

        }



    }
}
