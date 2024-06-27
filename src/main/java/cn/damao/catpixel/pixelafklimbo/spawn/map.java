package cn.damao.catpixel.pixelafklimbo.spawn;

import cn.damao.catpixel.pixelafklimbo.PixelAFK_Limbo;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class map {
    public static void teleportSpawn(Player player) {
        if (PixelAFK_Limbo.getInstance().getConfig().get("spawn") == null) {
            player.sendMessage("");
            player.sendMessage(" §c发生了一个错误，请将此截图发送给管理员！");
            player.sendMessage("  §c错误类型： 没有设置出生点！");
            player.sendMessage("  §c解决方案： §b使用/PixelAFK指令查看帮助");
            player.sendMessage("");
        } else {
            Location location = (Location)PixelAFK_Limbo.getInstance().getConfig().get("spawn");
            player.teleport(location);
        }
    }

    public static void setSpawn(Player player) {
        Location location = player.getLocation().add(0.0, 2.0, 0.0).clone();
        PixelAFK_Limbo.getInstance().getConfig().set("spawn", location);
        PixelAFK_Limbo.getInstance().saveConfig();
        player.sendMessage("§f[§6§lPixelAFK§f] §f>> §a出生点位置已成功设置！");
    }

}

