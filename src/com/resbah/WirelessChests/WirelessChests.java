package com.resbah.WirelessChests;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class WirelessChests extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		log.info("WirelessChests has been Enabled");
		PluginManager pm = this.getServer().getPluginManager();
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	    WirelessChestsCommandExecutor exec = new WirelessChestsCommandExecutor(this);
		getCommand("wcrem").setExecutor(exec);
		getCommand("wcremgroup").setExecutor(exec);
		getCommand("wcabout").setExecutor(exec);
		getCommand("wcsetmain").setExecutor(exec);
		getCommand("wcsync").setExecutor(exec);
		getCommand("wcaddchest").setExecutor(exec);
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.INVENTORY_TRANSACTION, (Listener) invListener, Event.Priority.Normal, this);
	}
	 
	public void onDisable(){ 
		this.saveConfig();
		log.info("WirelessChests has been Disabled");
	}
	

	private final WirelessChestsBlockListener blockListener = new WirelessChestsBlockListener(this);
	private final WCInvListener invListener = new WCInvListener(this);
}