package net.sealing99.menuCreator.menu.action;

import net.sealing99.menuCreator.menu.ClickType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public interface MenuAction {
    void execute(ClickType clickType, Player player);

    EmptyAction EMPTY = new EmptyAction();
}
