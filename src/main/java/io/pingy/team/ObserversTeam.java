package io.pingy.team;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;


import java.util.ArrayList;

/**
 * Created by thlappy on 9/4/2016.
 */
public class ObserversTeam implements Listener {
        private ArrayList<String> members = new ArrayList<String>();
        @EventHandler
        public void onLogin(PlayerLoginEvent event) {

            String playerName = event.getPlayer().getName();
            members.add(playerName);
        }
        @EventHandler
        public void onChat(AsyncPlayerChatEvent event){
            String playerName = event.getPlayer().getName();
            if (members.contains(playerName)){
                event.setFormat(ChatColor.AQUA + "[Observers] " + playerName + ": " + event.getMessage());
            }
        }
}