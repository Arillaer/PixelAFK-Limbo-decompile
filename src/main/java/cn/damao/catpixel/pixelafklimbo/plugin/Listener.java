package cn.damao.catpixel.pixelafklimbo.plugin;

import cn.damao.catpixel.pixelafklimbo.PixelAFK_Limbo;
import cn.damao.catpixel.pixelafklimbo.command.MainCommand;
import cn.damao.catpixel.pixelafklimbo.event.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class Listener {
    static PixelAFK_Limbo plugin = PixelAFK_Limbo.getPlugin(PixelAFK_Limbo.class);

    public static void regPlugin() {
        Bukkit.getConsoleSender().sendMessage("§6=============================================");
        Bukkit.getConsoleSender().sendMessage("§f[§6§lPixelAFK §8- §b§lLimbo§f] §f插件制作： §6像素社区 (猫像素工作室旗下产品)");
        Bukkit.getConsoleSender().sendMessage("§f[§6§lPixelAFK §8- §b§lLimbo§f] §a插件已成功启动！");
        Bukkit.getConsoleSender().sendMessage("§6=============================================");
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), plugin);
        plugin.getCommand("PixelAFK").setExecutor(new MainCommand(plugin));
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        new BukkitRunnable(){
            public void run() {
                for (World world : Bukkit.getServer().getWorlds()) {
                    world.setTime(13000L);
                    world.setStorm(false);
                    world.setThundering(false);
                    world.setPVP(false);
                }
            }
        }.runTaskTimer(PixelAFK_Limbo.instance, 0L, 20L);
    }

}

