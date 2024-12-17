package utils;

public class Message {
    private String content;//消息的内容
    private int id;//消息的主人
    public Message(int id,String content)
    {

        this.id=id;
        this.content=content;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
