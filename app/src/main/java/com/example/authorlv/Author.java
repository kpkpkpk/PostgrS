package com.example.authorlv;

public class Author {
    private String name;
    private int id;
    public Author(int id,String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
