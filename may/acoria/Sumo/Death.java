package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Death implements Listener {

    Join join = new Join();

    SumoManager sm = new SumoManager();

    SumoOneonOne smo = new SumoOneonOne();

    Location l = new Location(Bukkit.getServer().getWorld("world"),0, 0, 0);

    @EventHandler
    public void death(PlayerMoveEvent e) {

        Player p = e.getPlayer();

        Material water = e.getPlayer().getLocation().getBlock().getType();

        if (water.equals(Material.WATER)) {

            if (p == smo.p1) {

                join.players.remove(smo.p1.getUniqueId());

                smo.p2.teleport(sm.getLobby());

                smo.p1.teleport(l);

                smo.p1.sendMessage("&cYou have been eliminated from the tournament!");

                if (join.players.size() == 1) {

                    Player winner = Bukkit.getServer().getPlayer(join.players.get(0));

                    winner.sendMessage(Sumo.c("&aYou have won the sumo tournament!"));

                    for (Player ps : Bukkit.getServer().getOnlinePlayers()) {

                        ps.sendMessage(Sumo.c("&7--------------------------"));
                        ps.sendMessage(Sumo.c("&eSumo Winner: &a" + winner.getName()));
                        ps.sendMessage(Sumo.c("&7--------------------------"));

                    }

                    join.players.remove(winner.getUniqueId());

                    winner.teleport(l);

                }else {

                    smo.start1v1(join.players);

                }

            }else {

                if (p == smo.p2) {

                    join.players.remove(smo.p2.getUniqueId());

                    smo.p1.teleport(sm.getLobby());

                    smo.p1.teleport(l);

                    smo.start1v1(join.players);

                    smo.p2.sendMessage("&cYou have been eliminated from the tournament!");

                    if (join.players.size() == 1) {

                        Player winner = Bukkit.getServer().getPlayer(join.players.get(0));

                        winner.sendMessage(Sumo.c("&aYou have won the sumo tournament!"));

                        for (Player ps : Bukkit.getServer().getOnlinePlayers()) {

                            ps.sendMessage(Sumo.c("&7--------------------------"));
                            ps.sendMessage(Sumo.c("&eSumo Winner: &a" + winner.getName()));
                            ps.sendMessage(Sumo.c("&7--------------------------"));

                        }

                        join.players.remove(winner.getUniqueId());

                        winner.teleport(l);

                    }

                }
            }

        }


    }

}
