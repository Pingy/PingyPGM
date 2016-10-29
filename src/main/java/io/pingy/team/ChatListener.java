package io.pingy.team;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by thlappy on 10/28/2016.
 */
public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        TeamHandler team = new TeamHandler();
        Player player = event.getPlayer();


    }
}
