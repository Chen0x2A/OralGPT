package com.example.OralGPT.model;

import java.sql.Timestamp;

public class Chat {
    private int id;
    private String user_id;
    private String user_input;


    private String gpt_response;
    private Timestamp timestamp;

    public Chat(int id, String user_id, String user_input, String gpt_response, Timestamp timestamp) {
        this.id = id;
        this.user_id=user_id;
        this.user_input = user_input;
        this.gpt_response = gpt_response;
        this.timestamp = timestamp;
    }
    public Chat(String userid, String userInput, String gpt_response){
        this.user_id = userid;
        this.user_input = userInput;
        this.gpt_response = gpt_response;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", user_id='" + user_id +'\''+
                ", user_input='" + user_input + '\'' +
                ", gpt_response='" + gpt_response + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getUser_input() {
        return user_input;
    }

    public void setUser_input(String user_input) {
        this.user_input = user_input;
    }

    public String getGpt_response() {
        return gpt_response;
    }

    public void setGpt_response(String gpt_response) {
        this.gpt_response = gpt_response;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }



}

