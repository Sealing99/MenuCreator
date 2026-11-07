package net.sealing99.menuCreator.menu;

import java.util.ArrayList;

public class ItemList extends ArrayList<MenuItem> {
    public MenuItem getBySlot(int slot) {
        for (MenuItem item : this) {
            if (item.slot() == slot) {
                return item;
            }
        }

        return MenuItem.EMPTY;
    }
}
