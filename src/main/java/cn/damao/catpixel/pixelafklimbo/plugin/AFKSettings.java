package cn.damao.catpixel.pixelafklimbo.plugin;

import cn.damao.catpixel.pixelafklimbo.PixelAFK_Limbo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AFKSettings {
    public static void reloadConfig() {
        new BukkitRunnable(){
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage("§f[§6§lPixelAFK§f] §b§l>> §c现因插件配置更新，此房间将于10秒后重启！");
                }
            }
        }.runTaskTimer((Plugin)PixelAFK_Limbo.instance, 10L, 20L);
        new BukkitRunnable(){
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage("§f[§6§lPixelAFK§f] §b§l>> §a房间正在重启中...");
                }
                Bukkit.shutdown();
            }
        }.runTaskLater(PixelAFK_Limbo.instance, 200L);
    }
}

