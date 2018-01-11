package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Join implements CommandExecutor {

    public ArrayList<UUID> players = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        Player p = (Player) sender;


        for (UUID uuidgrid : players) {

            Player ps = Bukkit.getServer().getPlayer(uuidgrid);

            SumoManager sm = new SumoManager();

            ps.teleport(sm.getLobby());

            SumoOneonOne smo = new SumoOneonOne();

            smo.start1v1(players);

        }

        return true;

    }

}




