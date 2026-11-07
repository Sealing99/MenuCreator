package net.sealing99.menuCreator.menu;

import net.sealing99.menuCreator.menu.action.MenuAction;
import org.bukkit.inventory.ItemStack;

public class MenuItem {
    private final ItemStack item;
    private final int slot;
    private final MenuAction action;

    public MenuItem(ItemStack item, int slot, MenuAction action) {
        this.item = item;
        this.slot = slot;
        this.action = action;
    }

    public MenuItem(ItemStack item, int slot) {
        this.item = item;
        this.slot = slot;
        this.action = MenuAction.EMPTY;
    }

    private MenuItem() {
        this.item = null;
        this.slot = -1;
        this.action = null;
    }

    public ItemStack item() {
        return item;
    }

    public int slot() {
        return slot;
    }

    public MenuAction action() {
        return action;
    }

    public static final MenuItem EMPTY = new MenuItem();

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
