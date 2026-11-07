package net.sealing99.menuCreator;

import net.sealing99.menuCreator.menu.ClickType;
import net.sealing99.menuCreator.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class InventoryListener implements Listener {
    private final MenuCreator plugin;

    public InventoryListener(MenuCreator plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }

        if (!(event.getView().getTopInventory().getHolder() instanceof Menu)) {
            return;
        }

        event.setCancelled(true);

        List<Menu> menus = plugin.getActiveMenus();

        int slot = event.getRawSlot();
        Inventory inv = event.getClickedInventory();

        for (Menu menu : menus) {

            if (menu.getInventory().equals(inv)) {
                menu.clicked(slot, ClickType.LEFT_BUTTON, player);
                return;
            }
        }
    }
}
