package kg.edu.mmcs.antiplayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import java.util.logging.Level;

public final class AntiPlayer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().setLevel(Level.OFF);
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.RED + "Leave a star at https://github.com/ManuXia/AntiPlayer!");
    }

    private boolean isFolia() {
        try {
            Class.forName("io.papermc.paper.threadedregions.scheduler.GlobalRegionScheduler");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
