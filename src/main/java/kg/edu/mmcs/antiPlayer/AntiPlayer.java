package kg.edu.mmcs.antiplayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.logging.Level;

public final class AntiPlayer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        getLogger().setLevel(Level.OFF);

        if (isFolia()) {
            Bukkit.getGlobalRegionScheduler().runAtFixedRate(this, task -> {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick @e[type=minecraft:player]");
            }, 1L, 1L);
        } else {
            new BukkitRunnable() {
                @Override
                public void run() {
                    try {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick @e[type=minecraft:player]");
                    } catch (Exception ignored) {}
                }
            }.runTaskTimer(this, 1L, 1L);
        }
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.WHITE + "《red》yes the smart server operator installed antiplayer!");
    }//奇怪为什么不显示颜色啊

    private boolean isFolia() {
        try {
            Class.forName("io.papermc.paper.threadedregions.scheduler.GlobalRegionScheduler");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
//啊啊啊啊啊啊啊啊啊
//来测试喷气背包的性能。啊这就是喷气背包的力量吗！我感受到一股强大的力量在我身体里涌动着！啊！啊啊啊啊啊啊喷气背包出故障了！（米米死亡音效）唉？我没事！幸好。幸好。我之前买了一个星星礼盒！e呵呵呵呵