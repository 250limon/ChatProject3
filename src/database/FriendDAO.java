package database;

import manager.ResourceManager;
import user.Friend;
import user.User;
import utils.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//用于和好友相关的增删改查操作
public class FriendDAO {
    private final String mysqlPassword="limeng123A";
    private static FriendDAO friendDAO=new FriendDAO();
   private Connection connection;
    private FriendDAO()
    {

    }
    public static FriendDAO getInstance()
    {
        return friendDAO;
    }
    //根据好友表查询到的好友列表，在用户登入成功后调用
    public void setFriends()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app_db?useSSL=false", "root", mysqlPassword);
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            PreparedStatement ps = connection.prepareStatement("select * from friends_"+User.getInstance().getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int friendId = rs.getInt("friend_id");
                Friend friend=findNewFriendById(friendId);

                int userImportance = rs.getInt("friend_importance");
                friend.setImportance(userImportance);
                User.getInstance().addFriend(friend);

            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }



    }
    //根据id来查找某一个具体的朋友
    public Friend findNewFriendById(int id)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app_db?useSSL=false", "root", mysqlPassword);
        } catch (Exception e) {
            e.printStackTrace();

        }
        Friend friend=new Friend();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where user_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                friend.setId(rs.getInt("user_id"));
                friend.setName(rs.getString("user_name"));
                friend.setImage(ResourceManager.getInstance().getUserImage(rs.getString("user_image")));

                return friend;
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
    //通过名字来查找好友
    public List<Friend> getNewFriendsByName(String name)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app_db?useSSL=false", "root", mysqlPassword);
        } catch (Exception e) {
            e.printStackTrace();

        }
        List<Friend>friends=new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where user_name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Friend friend=new Friend();
                friend.setId(rs.getInt("user_id"));
                friend.setName(rs.getString("user_name"));
                friend.setImage(ResourceManager.getInstance().getUserImage(rs.getString("user_image")));
                friends.add(friend);
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return friends;
    }
    //像数据表中添加好友
    public void addNewFriend(int id)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app_db?useSSL=false", "root", mysqlPassword);
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            Friend friend=findNewFriendById(id);
            friend.setImportance(1);
            PreparedStatement ps = connection.prepareStatement("insert into friends_"+User.getInstance().getId()+"(friend_id,friend_importance)VALUES (?,?)");
           ps.setInt(1,friend.getId());
           ps.setInt(2,friend.getImportance());

           ps.execute();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    //删除好友


    //修改好友的重要度


    //搜索已添加好友的信息






}
