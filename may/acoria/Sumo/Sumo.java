package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Sumo extends JavaPlugin {

    public static String noperm;

    public static String c(String c) {

        return ChatColor.translateAlternateColorCodes('&', c);
    }

    static {

        Sumo.noperm = c("&4No permission");

    }

    @Override
    public void onEnable() {

        cmds();

        listen();

    }

    public void cmds() {

        this.getCommand("join").setExecutor(new Join());
        this.getCommand("sumo").setExecutor(new SetSpawned());
        this.getCommand("event").setExecutor(new SumoHost());
        this.getCommand("adminforcestart").setExecutor(new AdminForceStart());
        this.getCommand("forcestart").setExecutor(new ForceStart());



    }

    public void listen() {

        Bukkit.getServer().getPluginManager().registerEvents(new Death(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SumoStart(), this);



    }

}
