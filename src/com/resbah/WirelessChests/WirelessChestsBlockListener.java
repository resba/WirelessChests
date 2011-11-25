package com.resbah.WirelessChests;
 
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
 
public class WirelessChestsBlockListener extends BlockListener{
 
        public static WirelessChests plugin;
       
        public WirelessChestsBlockListener(WirelessChests instance) {
                plugin = instance;
        }
 
        public void onBlockPlace(BlockPlaceEvent event){
               
                Player player = event.getPlayer();
                Block block = event.getBlock();
                Material mat = block.getType();
 
                player.sendMessage("You placed a block with ID : " + mat);
                player.sendMessage("You have the item with the following ID in your hand : " + player.getItemInHand());
 
        }
        
        public void onBlockBreak(BlockBreakEvent event){
        	
        		Player player = event.getPlayer();
        		Block block = event.getBlock();
        		Material mat = block.getType();
        		
        		player.sendMessage("You have broken a block with ID : " + mat);
        }
        public void onBlockDamage(BlockDamageEvent event){
        	
    		Player player = event.getPlayer();
    		Block block = event.getBlock();
    		Material mat = block.getType();
    		
    		if(mat == Material.SAND){
    		player.sendMessage("WHY WOULD YOU HURT SAND D:");
    		}else{
    		player.sendMessage("You have damaged a block with ID : " + mat);
    }
        }
        }
        
