package me.io2.rareitemcollections;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class BreakListener implements Listener {
    private static final Random random = new Random();
    @EventHandler
    private void onBreakBlock(BlockBreakEvent event) {
        String type = event.getBlock().getBlockData().getAsString();

        Bukkit.broadcastMessage("Type: " + type);
        RareItemCollections.itemsList.forEach((a, b) -> {
            Bukkit.broadcastMessage("Processing " + a);

            boolean isContain = false;
            for (String material : b.materials) {
                if (material.split(":").length == 2) {
                    if (type.toLowerCase().startsWith(material.toLowerCase())) {
                        isContain = true;
                        break;
                    }
                } else {
                    if (type.split(":")[1].toLowerCase().startsWith(material.toLowerCase())) {
                        isContain = true;
                        break;
                    }
                }
            }

            if (isContain) {
                Bukkit.broadcastMessage("Contain");
                int i = random.nextInt(b.rate);
                Bukkit.broadcastMessage(String.valueOf(i));
                if (i < 1) {
                    Bukkit.broadcastMessage("§9Rare Drop! §c" + event.getPlayer().getName() + "§f has got §d" + a + "§r");
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    }

                    event.setDropItems(false);
                    Collection<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand());
                    if (!drops.isEmpty()) {
                        ArrayList<ItemStack> itemStacks = new ArrayList<>(drops);
                        for (ItemStack itemStack : itemStacks) {
                            ItemMeta itemMeta = itemStack.getItemMeta();
                            itemMeta.setDisplayName("§a§ka§r§d" + a + "§r§a§ka§r");
                            itemMeta.addEnchant(Enchantment.MENDING, 1, true);
                            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            itemStack.setItemMeta(itemMeta);
                            Item item = event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), itemStack);
                            item.setOwner(event.getPlayer().getUniqueId());
                            item.setPickupDelay(0);
                        }
                    }
                } else {
                    Bukkit.broadcastMessage("Miss! " + event.getBlock().getType().name());
                }
            }
        });
    }
}
