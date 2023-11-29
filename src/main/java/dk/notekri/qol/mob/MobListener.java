package dk.notekri.qol.mob;

import com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent;
import dk.notekri.qol.core.Handler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.WorldType;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.joml.Random;

import java.util.Arrays;
import java.util.UUID;

public class MobListener implements Listener {
    private Handler handler;
    public MobListener(Handler handler){
        this.handler = handler;
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        if (!(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.COMMAND) || event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL))) {
            return;
        }

        if (!event.getEntityType().equals(EntityType.ENDERMAN)) return;
        Enderman enderman = (Enderman) event.getEntity();
        Biome biome = enderman.getLocation().getBlock().getBiome();
        if (!(biome.equals(Biome.END_BARRENS)
                || biome.equals(Biome.END_HIGHLANDS)
                || biome.equals(Biome.END_MIDLANDS))) {
            return;
        }

        Random random = new Random();
        int x = random.nextInt(250);
        if (x != 0) {
            return;
        }
        BlockData data = Bukkit.createBlockData(Material.AMETHYST_CLUSTER);
        enderman.setCarriedBlock(data);
        enderman.setMaxHealth(80d);
        enderman.setHealth(80d);
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000, 3));
        enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 2));

        //  Brug equipment slots til loot
        //enderman.getEquipment().setHelmet(new ItemStack(Material.AMETHYST_BLOCK, 1));
        //enderman.getEquipment().setHelmetDropChance(100f);


        enderman.setGlowing(true);
        enderman.getWorld().playSound(enderman, Sound.ENTITY_WITHER_SHOOT, 2, 2);
        enderman.setRemoveWhenFarAway(true);

    }

}
