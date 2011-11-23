package com.resbah.WirelessChests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class WirelessChests extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	private FileConfiguration chestConfig = null;
	private File chestConfigFile = new File("chestConfig.yml");
	 
	public FileConfiguration getChestConfig() {
	    if (chestConfig == null) {
	        reloadChestConfig();
	    }
	    return chestConfig;
	}
	 
	public void reloadChestConfig() {
	    chestConfig = YamlConfiguration.loadConfiguration(chestConfigFile);
	 
	    // Look for defaults in the jar
	    InputStream defConfigStream = getResource("chestConfig.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	 
	        chestConfig.setDefaults(defConfig);
	    }
	}
	 
	public void saveChestConfig() {
	    try {
	        chestConfig.save(chestConfigFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + chestConfigFile, ex);
	    }
	}
	public void onEnable(){
		log.info("WirelessChests has been Enabled");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Event.Priority.Normal, this);
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
			getChestConfig().set("chest." + chestname, loc);
			saveChestConfig();
			reloadChestConfig();
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