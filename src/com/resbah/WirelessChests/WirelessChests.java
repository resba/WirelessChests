package com.resbah.WirelessChests;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class WirelessChests extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		log.info("WirelessChests has been Enabled");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);
		this.getConfig().options().copyDefaults(true);
	}
	 
	public void onDisable(){ 
		log.info("WirelessChests has been Disabled");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
	 
		if (cmd.getName().equalsIgnoreCase("wc")){
			if (player == null) {
				sender.sendMessage("this command can only be run by a player");
			} else {
	    		Location loc = player.getLocation();
	    		World w = loc.getWorld();
	    		loc.setY(loc.getY() + 5);
	    		Block b = w.getBlockAt(loc);
	    		b.setTypeId(1);
				player.sendMessage("Look up!");
			}
			return true;
		}

		if(cmd.getName().equalsIgnoreCase("namechest")){
			if(player == null) {
				sender.sendMessage("This command can only be run by a player.");
				return false;
			}else{
			if(args.length == 1){
			String chestname = args[0];
			Location loc = player.getLocation();
			World w = loc.getWorld();
			loc.setY(loc.getY() - 1);
			Block b = w.getBlockAt(loc);
			b.setType(Material.CHEST);
			int bn = w.getBlockTypeIdAt(loc);
			player.sendMessage("Below you is a Chest with the following parameters:");
			player.sendMessage("Location : " + loc);
			player.sendMessage("Block : " + b);
			player.sendMessage("New Type : " + bn);
			player.sendMessage("Chest Name : " + chestname);
			this.getConfig().set("chest." + chestname, loc);
			this.saveConfig();
			this.reloadConfig();
			}else{
				player.sendMessage("Sorry! Your formatting is invalid. Please try again.");
				return false;
			}
		}
			return true;
		}
		return false;
	}
	private final WirelessChestsPlayerListener playerListener = new WirelessChestsPlayerListener(this);
	private final WirelessChestsBlockListener blockListener = new WirelessChestsBlockListener(this);

}