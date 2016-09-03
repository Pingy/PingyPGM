package io.pingy.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import io.pingy.map.MapInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by thlappy on 7/22/2016.
 */
public class Map {
    @Command(aliases = {"map"}, desc = "A simple test command")
    public static void test(final CommandContext args, CommandSender sender) throws CommandException {
        //sender.sendMessage("At least this command works :)");

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("C:\\Users\\thlappy\\Desktop\\Server Files\\maps\\bananaCTF\\map.xml");

        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List xml = rootNode.getChildren("map");

            MapInfo mapInfo = new MapInfo();

            mapInfo.setMapName(rootNode.getChildText("name"));
            String mapName = mapInfo.getMapName();

            mapInfo.setVersion(rootNode.getChildText("version"));
            String mapVersion = mapInfo.getVersion();

            sender.sendMessage("" + ChatColor.RED + ChatColor.STRIKETHROUGH + "-----------------  " + ChatColor.RESET + ChatColor.DARK_AQUA + mapName + " " + ChatColor.GRAY + mapVersion + ChatColor.RED + ChatColor.STRIKETHROUGH +  " -----------------");

            mapInfo.setObjective(rootNode.getChildText("objective"));
            String mapObjective = mapInfo.getObjective();
            sender.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Objective: " + ChatColor.RESET + ChatColor.GOLD + mapObjective);


            List<Element> authors = rootNode.getChildren("author");

            String authorContribution = rootNode.getChild("authors").getChild("author").getAttributeValue("contribution");
            String author = rootNode.getChild("authors").getChild("author").getAttributeValue("uuid");
            mapInfo.setAuthor(ChatColor.AQUA + author + " " + ChatColor.DARK_GRAY + ChatColor.ITALIC + authorContribution);
            sender.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Authors: " +  mapInfo.getAuthor());

            String contributor = rootNode.getChild("contributors").getChild("contributor").getAttributeValue("uuid");
            String cContribution = rootNode.getChild("contributors").getChild("contributor").getAttributeValue("contribution");
            sender.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Contributors: " + ChatColor.AQUA  + contributor + " " + ChatColor.DARK_GRAY + ChatColor.ITALIC + cContribution);


        }  catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }
}


