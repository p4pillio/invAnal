package pkg.tap.invanal.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import pkg.tap.invanal.InvAnal;

import java.util.List;
import java.util.Stack;

public class PlayerListener implements Listener {

    //boring init stuff
    private static InvAnal plugin;
    public PlayerListener (InvAnal plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    List<ItemStack> keep = new Stack<ItemStack>();
    String[] utils = {"DIAMOND_SWORD", "STONE_SWORD", "GOLDEN_SWORD", "NETHERITE_SWORD", "IRON_SWORD", "WOODEN_SWORD",
            "DIAMOND_PICKAXE", "GOLDEN_PICKAXE", "IRON_PICKAXE", "NETHERITE_PICKAXE", "WOODEN_PICKAXE",
            "STONE_PICKAXE", "STONE_HOE", "WOODEN_HOE", "GOLDEN_HOE", "DIAMOND_HOE", "NETHERITE_HOE", "IRON_HOE",
            "DIAMOND_AXE", "GOLDEN_AXE", "NETHERITE_AXE", "WOODEN_AXE", "STONE_AXE", "IRON_AXE", "STONE_SHOVEL",
            "DIAMOND_SHOVEL", "IRON_SHOVEL", "GOLDEN_SHOVEL", "NETHERITE_SHOVEL", "WOODEN_SHOVEL", "CHAINMAIL_HELMET",
            "DIAMOND_HELMET", "GOLDEN_HELMET", "LEATHER_HELMET", "NETHERITE_HELMET", "IRON_HELMET", "TURTLE_HELMET",
            "CHAINMAIL_CHESTPLATE", "DIAMOND_CHESTPLATE", "GOLDEN_CHESTPLATE", "LEATHER_CHESTPLATE", "NETHERITE_CHESTPLATE",
            "IRON_CHESTPLATE", "LEATHER_LEGGINGS", "CHAINMAIL_LEGGINGS", "DIAMOND_LEGGINGS", "GOLDEN_LEGGINGS", "IRON_LEGGINGS",
            "NETHERITE_LEGGINGS", "CHAINMAIL_BOOTS", "DIAMOND_BOOTS", "LEATHER_BOOTS", "GOLDEN_BOOTS", "IRON_BOOTS", "NETHERITE_BOOTS",
            "TRIDENT", "ELYTRA", "SHEARS", "BOW", "CROSSBOW", "FISHING_ROD", "WARPED_FUNGUS_ON_A_STICK", "CARROT_ON_A_STICK", "SHIELD",
            "FLINT_AND_STEEL"};
    //thank you Tim_M on the bukkit forums 4 this list, wouldve killed myself if it wasnt there

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        keep = new Stack<>();

        for(int i = 0; i < e.getDrops().size(); i++){// looks through every dropped item
            ItemStack drop = e.getDrops().get(i);

            for(int j = 0; j < utils.length; j++){//nested for loops :weary:
                if(drop.getType().toString().equals(utils[j])){//if the item is found in the above array
                    keep.add(drop);//remember to keep it
                }
            }
        }
        p.setGameMode(GameMode.SPECTATOR);//sets player 2 spectator mode
        return;
    }

    @EventHandler
    public void OnPlayerRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        for(int i = 0; i < keep.size(); i++){//looks through every kept item
            p.getInventory().addItem(keep.get(i));//gives them to the player
        }
        return;
    }
}
