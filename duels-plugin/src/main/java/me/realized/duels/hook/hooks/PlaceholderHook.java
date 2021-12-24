package me.realized.duels.hook.hooks;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.realized.duels.DuelsPlugin;
import me.realized.duels.data.UserData;
import me.realized.duels.data.UserManagerImpl;
import me.realized.duels.util.hook.PluginHook;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceholderHook extends PluginHook<DuelsPlugin> {

    public static final String NAME = "PlaceholderAPI";

    private final UserManagerImpl userDataManager;

    public PlaceholderHook(final DuelsPlugin plugin) {
        super(plugin, NAME);
        this.userDataManager = plugin.getUserManager();
        new Placeholders().register();
    }

    public class Placeholders extends PlaceholderExpansion {

        @Override
        public @NotNull String getIdentifier() {
            return "duels";
        }

        @SuppressWarnings("UnstableApiUsage")
        @Override
        public String getPlugin() {
            return plugin.getName();
        }

        @Override
        public @NotNull String getAuthor() {
            return "Realized";
        }

        @Override
        public @NotNull String getVersion() {
            return "1.0";
        }

        @Override
        public String onPlaceholderRequest(final Player player, final @NotNull String identifier) {
            if (player == null) {
                return "Player is required";
            }

            final UserData user = userDataManager.get(player);

            if (user == null) {
                return null;
            }

            return switch (identifier) {
                case "wins" -> String.valueOf(user.getWins());
                case "losses" -> String.valueOf(user.getLosses());
                case "can_request" -> String.valueOf(user.canRequest());
                default -> null;
            };

        }
    }
}
