package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SumoManager {

    Location lobby;

    Location p1Spawn;

    Location p2Spawn;

    public void startSumo(Player hoster) {

        for (Player ps : Bukkit.getServer().getOnlinePlayers()) {

            ps.sendMessage(Sumo.c("&4SUMO &e" + "a sumo tournament (1v1) has been started by " + hoster.getName() + " &a do /join to compete!"));

        }

    }

    public void setSumoLobby(Location lobby) {

        this.lobby = lobby;

    }

    public Location getLobby() {

        return this.lobby;

    }

    public void setp1ArenaSpawn(Location p1) {

        this.p1Spawn = p1;

    }

    public void setp2ArenaSpawn(Location p2) {

        this.p2Spawn = p2;

    }

    public Location getP1Spawn() {

        return p1Spawn;

    }

    public Location getP2Spawn() {

        return p2Spawn;

    }
}
