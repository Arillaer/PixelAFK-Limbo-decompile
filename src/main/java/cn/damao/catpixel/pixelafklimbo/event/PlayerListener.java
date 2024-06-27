package cn.damao.catpixel.pixelafklimbo.event;

import cn.damao.catpixel.pixelafklimbo.plugin.Server;
import cn.damao.catpixel.pixelafklimbo.spawn.map;
import cn.damao.catpixel.pixelafklimbo.utils.VanishUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onBreakBlock(BlockBreakEvent blockBreakEvent) {
        blockBreakEvent.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent playerDropItemEvent) {
        playerDropItemEvent.setCancelled(true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        playerJoinEvent.setJoinMessage(null);
        VanishUtils.setPlayerVanish(player);
        map.teleportSpawn(player);
        Server.SendAFKTitle(player);
        Server.SendMessage(player);
        player.setGameMode(GameMode.ADVENTURE);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(null);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent entityDamageEvent) {
        entityDamageEvent.setCancelled(true);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent playerMoveEvent) {
        Player player = playerMoveEvent.getPlayer();
        if (player.getLocation().getY() <= -20.0) {
            map.teleportSpawn(player);
        }
        for (Player players : Bukkit.getOnlinePlayers()) {
            player.hidePlayer(players);
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent blockPlaceEvent) {
        blockPlaceEvent.setCancelled(true);
    }

    @EventHandler
    public void onCloseChat(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        asyncPlayerChatEvent.setCancelled(true);
    }
}

