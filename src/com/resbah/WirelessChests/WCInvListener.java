package com.resbah.WirelessChests;

import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.resbah.WirelessChests.event.ChestInventoryTransaction;

public class WCInvListener extends CustomEventListener{
    public static WirelessChests plugin;
    
    public WCInvListener(WirelessChests instance) {
            plugin = instance;
    }
    
    public void onChestInventoryTransaction(ChestInventoryTransaction event){
    	Chest chest = event.getChest();
    	Inventory inv = event.getInventory();
    	ItemStack[] itmstk = inv.getContents();
    	Player player = event.getPlayer();
    	
    	player.sendMessage("The chest now has the inventory as string as follows:");
    	player.sendMessage(inv.toString());
    	player.sendMessage("The chest now has the inventory itemstacks as string as follows:");
    	player.sendMessage(itmstk.toString());
    	player.sendMessage("The chest as string as follows:");
    	player.sendMessage(chest.toString());
    	player.sendMessage("Since your recieving the message you are the player involved! Woo!");
    	player.sendMessage(player.getDisplayName());
    	
    }

}
