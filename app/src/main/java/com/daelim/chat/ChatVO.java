package com.daelim.chat;

public class ChatVO {

    private int type;
    private String id;
    private String time;
    private String content;

    public ChatVO(){}

    public ChatVO(int type, String id, String time, String content) {
        this.type = type;
        this.id = id;
        this.time = time;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
