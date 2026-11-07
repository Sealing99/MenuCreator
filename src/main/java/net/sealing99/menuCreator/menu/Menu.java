package net.sealing99.menuCreator.menu;

import net.kyori.adventure.text.Component;
import net.sealing99.menuCreator.MenuCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Menu implements InventoryHolder, IMenu {
    private Inventory inventory;
    private final Component title;
    private final int slots;

    private final ItemList items = new ItemList();

    public Menu(Component title, int slots) {
        this.title = title;
        this.slots = slots;

        MenuCreator.getInstance().addMenu(this);
    }

    public Menu addItem(MenuItem item) {
        items.add(item);
        return this;
    }

    public Menu background(Material itemType) {

        return this;
    }

    private void updateInventory() {
        if (inventory == null) {
            inventory = Bukkit.createInventory(this, slots, title);
        } else {
            inventory.clear();
        }
        for (MenuItem item : items) {
            ItemStack itemStack = item.item();
            int slot = item.slot();
            inventory.setItem(slot, itemStack);
        }
    }

    public void clicked(int slot, ClickType click, Player player) {
         MenuItem clickedMenuItem = items.getBySlot(slot);
         if (clickedMenuItem.isEmpty()) return;

         clickedMenuItem.action().execute(click, player);
    }

    @Override
    public @NotNull Inventory getInventory() {
        updateInventory();
        return this.inventory;
    }

    public void open(Player player) {
        updateInventory();
        player.openInventory(inventory);
    }
}
