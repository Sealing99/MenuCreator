package net.sealing99.menuCreator;

import net.kyori.adventure.text.Component;
import net.sealing99.menuCreator.menu.Menu;
import net.sealing99.menuCreator.menu.MenuItem;
import net.sealing99.menuCreator.menu.action.CommandAction;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class MenuCreator extends JavaPlugin {
    private static MenuCreator instance;
    private final List<Menu> activeMenus = new ArrayList<>();
    public Menu myMenu;
    public MenuCommandSender commandSender = new MenuCommandSender();

    @Override
    public void onEnable() {
        instance = this;

        myMenu = new Menu(Component.text("Eggs"), 54)
                .addItem(new MenuItem(new ItemStack(Material.EGG), 4, new CommandAction("say HALLO")));

        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    public static MenuCreator getInstance() {
        return instance;
    }

    public void addMenu(Menu menu) {
        activeMenus.add(menu);
    }

    public void deactivateMenu(Menu menu) {
        activeMenus.remove(menu);
    }

    public List<Menu> getActiveMenus() {
        return activeMenus;
    }
}
