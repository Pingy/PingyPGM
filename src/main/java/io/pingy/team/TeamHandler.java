package io.pingy.team;

import org.bukkit.ChatColor;

import java.util.ArrayList;

/**
 * Created by thlappy on 9/2/2016.
 */
public class TeamHandler {
    private ArrayList<String> members;
    private String name;
    private int size;
    private ChatColor color;
    private String id;
    public TeamHandler(String name, int size, String id, ChatColor color) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.id = id;
        this.members = new ArrayList<String>(members);
    }
    public TeamHandler(){
    }
    public void addPlayer(String name){
        this.members.add(name);
    }
    public void removePlayer(String name){
        members.remove(name);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setColor(ChatColor color){
        this.color = color;
    }
    public void setSize(int size){
        this.size = size;
    }
    public void setId(String id){
        this.id = id;
    }
    public ChatColor getColor(){
        return color;
    }
    public String getId(){
        return id;
    }
    public int getSize(){
        return size;
    }
    public String getName(){
        return name;
    }


}