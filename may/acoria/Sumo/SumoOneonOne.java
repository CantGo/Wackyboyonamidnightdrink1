package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SumoOneonOne {

    public Player p1;

    public Player p2;

    SumoManager sm = new SumoManager();

    public void start1v1(List<UUID> players) {

            int size = players.size();
            int random = new Random().nextInt(size);

            UUID picked = players.get(random);

            Player p1 = Bukkit.getServer().getPlayer(picked);

            int size1 = players.size();
            int random1 = new Random().nextInt(size1);

            UUID picked1 = players.get(random1);

            Player p2 = Bukkit.getServer().getPlayer(picked1);

            p1.sendMessage(Sumo.c("&cYou are versing " + p2.getName()));
            p2.sendMessage(Sumo.c("&cYou are versing " + p1.getName()));

            p1.teleport(sm.getP1Spawn());

            p2.teleport(sm.getP2Spawn());

            this.p1 = p1;
            this.p2 = p2;


    }

}
