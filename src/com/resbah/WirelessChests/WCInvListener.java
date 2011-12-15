package com.resbah.WirelessChests;

import com.resbah.WirelessChests.event.ChestInventoryTransaction;

public class WCInvListener {
    public static WirelessChests plugin;
    
    public WCInvListener(WirelessChests instance) {
            plugin = instance;
    }
    
    public void onChestInventoryTransaction(ChestInventoryTransaction event){
    	
    }

}
