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
	@SuppressWarnings("unused")
	private Chest chest;
	@SuppressWarnings("unused")
	private Inventory inventory;
	@SuppressWarnings("unused")
	private ItemStack[] itmstk;
	private boolean cancelled;

	protected ChestInventoryTransaction(Chest chest, Inventory inventory, ItemStack[] itmstk) {
		super(Type.INVENTORY_TRANSACTION);
		this.chest = chest;
		this.inventory = inventory;
		this.itmstk = itmstk;
		this.cancelled = false;
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
