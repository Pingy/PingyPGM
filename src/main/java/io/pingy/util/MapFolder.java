package io.pingy.util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import java.io.File;

/**
 * Created by thlappy on 10/15/2016.
 */
public class MapFolder implements Listener {
    @EventHandler
    public void onEnable(PluginEnableEvent event) {
        File mapFolder = new File("maps");
        if (mapFolder.exists()) {
            System.out.println("The map folder exists, I will not create a new folder.");
        }
        if (!mapFolder.exists()) {
            System.out.println("Maps folder not found, creating one.");
            mapFolder.mkdir();
        }
    }
}
