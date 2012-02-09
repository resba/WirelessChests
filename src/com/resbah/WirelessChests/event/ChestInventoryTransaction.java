package com.resbah.WirelessChests.event;

import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;

public class ChestInventoryTransaction extends Event implements Cancellable {

	/**
	 * Called when an inventory transaction occurs in a chest.
	 * If a Chest Inventory Transaction event is canceled, the transaction will not break.
	 */
	private static final long serialVersionUID = -1307408375583161287L;
	private Chest chest;
	private Inventory inventory;
	private boolean cancelled;
	private Player player;

	protected ChestInventoryTransaction(Player player, Chest chest, Inventory inventory) {
		super(Type.ENTITY_INTERACT);
		this.chest = chest;
		this.inventory = inventory;
		this.cancelled = false;
		this.player = player;
	}
	
    /**
     * Gets the Player that is initiating or finishing the transaction.
     *
     * @return The Player involved in the event.
     */

	public Player getPlayer(){
		return player;
	}
	
    /**
     * Gets the Chest involved in the Inventory Transaction.
     *
     * @return The Chest involved in the event.
     */
	
	public Chest getChest(){
		return chest;
	}
	
    /**
     * Gets the <b>Chest</b> Inventory involved in the Inventory Transaction.
     *
     * @return The <b>Chest</b> Inventory involved in the event.
     */
	
	public Inventory getInventory() {
		return inventory;
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
