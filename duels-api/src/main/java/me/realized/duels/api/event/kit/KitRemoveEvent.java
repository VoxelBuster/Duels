package me.realized.duels.api.event.kit;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import me.realized.duels.api.kit.Kit;
import me.realized.duels.api.kit.KitManager;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

/**
 * Called when a {@link Kit} is removed.
 *
 * @see KitManager#remove(CommandSender, String)
 * @see Kit#isRemoved()
 */
public class KitRemoveEvent extends KitEvent {

    private static final HandlerList handlers = new HandlerList();

    public KitRemoveEvent(@Nullable final CommandSender source, @NotNull final Kit kit) {
        super(source, kit);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
