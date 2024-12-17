package user;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User extends People {
    private static User user=new User();
    private int id;
    private String name;
    private String password;
    private Image user_image;
    private List<Friend>friends=new ArrayList<>();
    private User()
    {

    }
    public static User getInstance()
    {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
    public void addFriend(Friend friend)
    {
        friends.add(friend);
    }

    public List<Friend> getFriends() {
        return friends;
    }
    public void setFriendLive(int id)
    {
        for(Friend friend:friends)
        {
            if(friend.getId()==id)
            {
                friend.setLive(true);
            }
        }



    }



    public void setUser_image(Image user_image) {
        this.user_image = user_image;
    }

    public int getId() {
        return id;
    }

    public boolean isMyFriend(int id)
    {
        for(Friend friend:friends)
        {
            if(friend.getId()==id)
            {
                return  true;
            }
        }
        return false;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Image getUser_image() {
        return user_image;
    }
}
