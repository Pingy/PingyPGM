package io.pingy.team;

import org.bukkit.ChatColor;

/**
 * Created by thlappy on 9/5/2016.
 */
public class TestObserver {
    public static void builder(){
        TeamHandler obs = new TeamHandler();
        String name = "Observers";
        obs.setName(name);
        obs.setColor(ChatColor.AQUA);
        obs.setSize(1);
        obs.addTeam(name);

    }
}
