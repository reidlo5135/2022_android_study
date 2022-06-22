package com.daelim.chat;

public class ChatVO {

    private int type;
    private String id;
    private String content;

    public ChatVO(){}

    public ChatVO(int type, String id) {
        this.type = type;
        this.id = id;
    }

    public ChatVO(int type, String id, String content) {
        this.type = type;
        this.id = id;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
