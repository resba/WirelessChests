package com.resbah.WirelessChests.event;

import org.bukkit.block.Chest;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestInventoryTransaction extends Event implements Cancellable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1307408375583161287L;
	private Chest chest;
	private Inventory inventory;
	private ItemStack[] itmstk;
	private boolean cancelled;

	protected ChestInventoryTransaction(Chest chest, Inventory inventory, ItemStack[] itmstk) {
		super(Type.INVENTORY_TRANSACTION);
		this.chest = chest;
		this.inventory = inventory;
		this.itmstk = itmstk;
		this.cancelled = false;
	}

	public Chest getChest(){
		return chest;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public ItemStack[] getItemStack() {
		return itmstk;
	}
	
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
		
	}

}
