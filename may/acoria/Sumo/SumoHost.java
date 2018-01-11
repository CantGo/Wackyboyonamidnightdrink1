package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SumoHost implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("event.sumo")) {

            Inventory events = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Host An Event");

            ItemStack sumo = new ItemStack(Material.PACKED_ICE);
            ItemMeta sumometa = sumo.getItemMeta();
            sumometa.setDisplayName(Sumo.c("&cStart Sumo Tournament"));
            sumo.setItemMeta(sumometa);

            events.setItem(4, sumo);

            p.openInventory(events);

        }else {

            sender.sendMessage(Sumo.c("&4You must purchase a rank to be able to host an event"));
            sender.sendMessage(Sumo.c("&aPurchase a rank at http://acoria.buycraft.net/"));

        }

        return true;
    }

}
