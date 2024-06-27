package cn.damao.catpixel.pixelafklimbo.command;

import cn.damao.catpixel.pixelafklimbo.PixelAFK_Limbo;
import cn.damao.catpixel.pixelafklimbo.plugin.AFKSettings;
import cn.damao.catpixel.pixelafklimbo.spawn.map;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    private final PixelAFK_Limbo plugin;

    public MainCommand(PixelAFK_Limbo pixelAFK_Limbo) {
        this.plugin = pixelAFK_Limbo;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] stringArray) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player)commandSender;
        if (stringArray.length == 0) {
            player.sendMessage("  §f[§6§lPixelAFK§f] §8- §bLimbo");
            player.sendMessage("    §f插件制作： §bDaMao_OVO (大猫)");
            player.sendMessage("    §f插件版本： §b" + this.plugin.getDescription().getVersion());
            player.sendMessage("    §f指令帮助： §b/PixelAFK help");
            player.sendMessage("    §f社区官方交流QQ群： §b966424719");
            player.sendMessage("");
            player.sendMessage(" §b本插件受到 像素社区 (猫像素工作室旗下产品) 著作权保护，切勿进行§c反编译和破解！");
            player.sendMessage("");
            return true;
        }
        if (stringArray[0].equalsIgnoreCase("help")) {
            if (commandSender.hasPermission("PixelAFK.command.help")) {
                commandSender.sendMessage("  §f[§6§lPixelAFK§f] §8- §bLimbo");
                commandSender.sendMessage("   §a§l插件指令帮助:");
                commandSender.sendMessage("    §f/PixelAFK help §7(查看帮助)");
                commandSender.sendMessage("    §f/PixelAFK reload §7(重载配置文件)");
                commandSender.sendMessage("    §f/PixelAFK setspawn §7(设置大厅出生点)");
                commandSender.sendMessage("");
                return false;
            }
            commandSender.sendMessage("§c你没有足够的权限可以这样做！ (help)");
            return true;
        }
        if (stringArray[0].equalsIgnoreCase("reload")) {
            if (commandSender.hasPermission("PixelAFK.command.reload")) {
                PixelAFK_Limbo.instance.reloadConfig();
                AFKSettings.reloadConfig();
                commandSender.sendMessage("§f[§6§lPixelAFK§f] §f§l>> §e插件需要重启后才能对新配置文件生效！");
                return false;
            }
            commandSender.sendMessage("§c你没有足够的权限可以这样做！ (reload)");
            return true;
        }
        if (!stringArray[0].equalsIgnoreCase("setSpawn")) return false;
        if (commandSender.hasPermission("pixelafk.command.setspawn")) {
            map.setSpawn(player);
            return false;
        }
        commandSender.sendMessage("§c你没有足够的权限可以这样做！ (setspawn)");
        return true;
    }
}

