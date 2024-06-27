package cn.damao.catpixel.pixelafklimbo;

import cn.damao.catpixel.pixelafklimbo.plugin.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PixelAFK_Limbo extends JavaPlugin {
    public static PixelAFK_Limbo instance;

    @Override
    public void onEnable() {
        instance = this;
        Listener.regPlugin();
    }

    @Override
    public void onDisable() {
    }

    public static PixelAFK_Limbo getInstance() {
        return instance;
    }
}

