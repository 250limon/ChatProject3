package database;

import manager.ResourceManager;
import user.User;
import utils.RandomGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//专门用于用户相关的数据库操作
public class UserDAO {
    private final String mysqlPassword="limeng123A";
    private static UserDAO userDAO=new UserDAO();
    private Connection connection=null;
    private List<String>imagePath=new ArrayList<>();
    private UserDAO()
    {
        imagePath.add("resource/user_image/yaoyao.jpg");
        imagePath.add("resource/user_image/yoimiya1.jpg");
        imagePath.add("resource/user_image/yoimiya2.jpg");
        imagePath.add("resource/user_image/yoimiya3.jpg");
        imagePath.add("resource/user_image/yoimiya4.jpg");
        imagePath.add("resource/user_image/yoimiya5.jpg");
        imagePath.add("resource/user_image/yoimiya6.jpg");
        imagePath.add("resource/user_image/yoimiya7.jpg");
        imagePath.add("resource/user_image/yoimiya8.jpg");
    }
    public static UserDAO getInstance()
    {

        return userDAO;

    }
    //验证登录可不可以通过,前提为账号已经存在
    public boolean logIn(String id,String password)  {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app_db?useSSL=false&&allowPublicKeyRetrieval=true", "root", mysqlPassword);


        }catch (Exception e)
        {
            e.printStackTrace();

        }
        try {

            PreparedStatement ps = connection.prepareStatement("select * from users where user_id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("user_password");
                if (dbPassword.equals(password)) {
                    return true;
                }
                else {
                    return false;
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
    //验证账号是否存在
    public boolean isIdExist(String id) {
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
            PreparedStatement ps = connection.prepareStatement("select * from users where user_id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
    //用户进行注册,
    /*
    插入用户信息
    注册成功后返回用户id
     */
    public int register(String name,String password)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app_db?useSSL=false","root",mysqlPassword);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        String image=imagePath.get(RandomGenerator.random(0,imagePath.size()));

        try{
            PreparedStatement ps = connection.prepareStatement("insert into users(user_name,user_password,user_image)values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,image);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                return rs.getInt(1);
            }
            connection.close();
        }catch (Exception e)
        {

            e.printStackTrace();

        }
            return 0;
    }
    //根据id来查找用户信息，在用户登入成功后调用，用于设置全局为一的用户对象
    public void setUser(int id) {

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
            PreparedStatement ps = connection.prepareStatement("select * from users where user_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                User.getInstance().setId(rs.getInt("user_id"));
                User.getInstance().setName(rs.getString("user_name"));
                User.getInstance().setPassword(rs.getString("user_password"));
                User.getInstance().setUser_image(ResourceManager.getInstance().getUserImage(rs.getString("user_image")));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    //创建该用户的好友数据表，在注册时调用
    public void createFriendsTable(int id) {
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
            String sql = "create table if not exists friends_" + id + "(friend_id int ,friend_importance int)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }




}
