package cn.damao.catpixel.pixelafklimbo.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class VanishUtils {
    public static void setPlayerVanish(Player player) {
        Bukkit.getOnlinePlayers().forEach(arg_0 -> arg_0.hidePlayer(player));
    }
}

