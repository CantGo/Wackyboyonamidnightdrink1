package may.acoria.Sumo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SumoStart implements Listener {

    SumoManager sm = new SumoManager();

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Host An Event")) {

            e.setCancelled(true);

            if (e.getRawSlot() == 4) {


                Inventory confirm = Bukkit.createInventory(null, 9, ChatColor.RED + "Are you sure?");

                ItemStack conf = new ItemStack(Material.GREEN_RECORD);
                ItemMeta confmeta = conf.getItemMeta();
                confmeta.setDisplayName(Sumo.c("&aConfirm (start sumo tournament)"));
                conf.setItemMeta(confmeta);

                ItemStack decline = new ItemStack(Material.REDSTONE_BLOCK);
                ItemMeta declinemet = decline.getItemMeta();
                declinemet.setDisplayName(Sumo.c("&4Decline (cancel sumo tournament)"));
                decline.setItemMeta(declinemet);

                confirm.setItem(0, conf);

                confirm.setItem(8, decline);

                p.closeInventory();

                p.openInventory(confirm);




            }

        }

    }

    @EventHandler
    public void onCliick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.RED + "Are you sure?")) {

            if (e.getRawSlot() == 8) {

                p.closeInventory();

                p.sendMessage(Sumo.c("&cCancelled sumo tournament"));

            }else {

                if (e.getRawSlot() == 0) {

                    Inventory ffa = Bukkit.createInventory(null, 9, ChatColor.GREEN + "FFA or 1v1 Sumo");

                    ItemStack sumo = new ItemStack(Material.BLAZE_POWDER);
                    ItemMeta sumom = sumo.getItemMeta();
                    sumom.setDisplayName(Sumo.c("&aSumo (tournament 1v1)"));
                    sumo.setItemMeta(sumom);

                    ItemStack sumoffa = new ItemStack(Material.BLAZE_ROD);
                    ItemMeta sumomm = sumoffa.getItemMeta();
                    sumomm.setDisplayName(Sumo.c("&aSumo ffa (everyone teleported in at once)"));
                    sumoffa.setItemMeta(sumomm);

                    ffa.setItem(0, sumo);

                    ffa.setItem(8, sumoffa);

                    p.closeInventory();
                    p.openInventory(ffa);

                }

            }

        }

    }

    @EventHandler
    public void onCliiick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        e.setCancelled(true);

        if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.GREEN + "FFA or 1v1 Sumo")) {

            if (e.getRawSlot() == 0) {

                sm.startSumo(p);

                p.closeInventory();

            }

        }

    }

}
