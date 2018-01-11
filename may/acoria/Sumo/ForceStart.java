package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ForceStart implements CommandExecutor {

    SumoManager sm = new SumoManager();

    Join join = new Join();

    SumoOneonOne som = new SumoOneonOne();

    public int votes;

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        Player p = (Player) sender;

        if (join.players.contains(p.getUniqueId())) {

            if (votes == 6) {

                som.start1v1(join.players);

                for (UUID uuidgrid : join.players) {

                    Player ps = Bukkit.getServer().getPlayer(uuidgrid);

                    ps.sendMessage(Sumo.c("&4SUMO: &aForce-start has been voted!"));

                }


            }else {

                votes = votes + 1;

                sender.sendMessage(Sumo.c("&aYour vote has been added!"));

            }

        }else {

            sender.sendMessage(Sumo.c("&cYou are not in a sumo tournament!"));

        }

        return true;
    }

}
