package com.resbah.WirelessChests;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;


public class WirelessChestsPlayerListener extends PlayerListener {

	public static WirelessChests plugin;
    
    public WirelessChestsPlayerListener(WirelessChests instance) {
            plugin = instance;
    }

    public void onPlayerMove(PlayerMoveEvent event){
           
            Player player = event.getPlayer();
            Location playerLoc = player.getLocation();
           
            player.sendMessage("Your X Coordinates : " + playerLoc.getX());
            player.sendMessage("Your Y Coordinates : " + playerLoc.getY());
            player.sendMessage("Your Z Coordinates : " + playerLoc.getZ());
    }
}
