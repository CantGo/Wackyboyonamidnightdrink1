package may.acoria.Sumo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawned implements CommandExecutor {

    SumoManager sm = new SumoManager();

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {

            sender.sendMessage(Sumo.c("&cUsage: /sumo setspawnp1 | /sumo setspawnp2 | /sumo setLobby"));

            return true;
        }

        if (args[0].equalsIgnoreCase("setspawnp1")) {

            sm.setp1ArenaSpawn(p.getLocation());

        }else if (args[0].equalsIgnoreCase("setspawnp2")) {

            sm.setp2ArenaSpawn(p.getLocation());

        }else if (args[0].equalsIgnoreCase("setLobby")) {
            sm.setSumoLobby(p.getLocation());


        }



        return true;
    }

}
