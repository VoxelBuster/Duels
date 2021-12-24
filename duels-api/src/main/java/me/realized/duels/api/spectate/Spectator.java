package me.realized.duels.api.spectate;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import me.realized.duels.api.arena.Arena;

/**
 * Represents a Spectator spectating a match.
 *
 * @since 3.4.1
 */
public interface Spectator {

    /**
     * The {@link UUID} of this spectator.
     *
     * @return {@link UUID} of this spectator.
     */
    @NotNull
    UUID getUuid();

    /**
     * The {@link Arena} this spectator is spectating.
     *
     * @return {@link Arena} this spectator is spectating.
     */
    @NotNull
    Arena getArena();
}
