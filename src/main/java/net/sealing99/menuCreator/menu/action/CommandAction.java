package net.sealing99.menuCreator.menu.action;

import net.sealing99.menuCreator.menu.ClickType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class CommandAction implements MenuAction {
    private final String command;

    public CommandAction(String command) {
        this.command = command;
    }

    public CommandAction(String base, Object... args) {
        this.command = base.replace("{}", "%s").formatted(args);
    }

    @Override
    public void execute(@Nullable ClickType clickType, @Nullable Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
