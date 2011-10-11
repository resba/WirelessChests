package com.resbah.WirelessChests;

import java.util.logging.Logger;

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
				player.sendMessage("Hello~");
			}
			return true;
		}
		return false;
	}
	private final WirelessChestsPlayerListener playerListener = new WirelessChestsPlayerListener(this);
	private final WirelessChestsBlockListener blockListener = new WirelessChestsBlockListener(this);

}