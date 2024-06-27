package cn.damao.catpixel.pixelafklimbo.plugin;

import cn.damao.catpixel.pixelafklimbo.PixelAFK_Limbo;
import cn.damao.catpixel.pixelafklimbo.utils.TitleUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Server {

    public static void SendMessage(Player player) {
        for (int i = 0; i < 20; ++i) {
            player.sendMessage(" ");
        }
        player.sendMessage(PixelAFK_Limbo.getInstance().getConfig().getString("Language.Message-1"));
        player.sendMessage(PixelAFK_Limbo.getInstance().getConfig().getString("Language.Message-2"));
    }

    public static void SendAFKTitle(Player player) {
        Bukkit.getScheduler().runTaskTimer(PixelAFK_Limbo.getInstance(), () -> TitleUtils.sendFullTitle(player, 0, 50, 0, PixelAFK_Limbo.getInstance().getConfig().getString("Language.Title"), PixelAFK_Limbo.getInstance().getConfig().getString("Language.Subtitle")), 0L, 20L);
    }
}

