package pkg.tap.invanal;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pkg.tap.invanal.listeners.PlayerListener;

public class InvAnal extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("hewwo wowwd");

        new PlayerListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(":3");
    }

}
