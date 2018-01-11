package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AdminForceStart implements CommandExecutor {

    Join join = new Join();

    SumoOneonOne sm = new SumoOneonOne();

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("acoria.admin")) {

            sm.start1v1(join.players);

            sender.sendMessage(Sumo.c("&aSumo force started!"));

            for (UUID uuidgrid : join.players) {

                Player ps = Bukkit.getServer().getPlayer(uuidgrid);

                ps.sendMessage(Sumo.c("&aSumo force started by &4" + p.getName()));

            }

        }

        return true;
    }

}
