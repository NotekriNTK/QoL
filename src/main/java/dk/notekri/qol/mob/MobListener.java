package dk.notekri.qol.mob;

import dk.notekri.qol.core.Handler;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.UUID;

public class MobListener implements Listener {
    boolean isSpawned = false;
    private Handler handler;



    public MobListener(Handler handler){
        this.handler = handler;
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event){
        if (!(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.COMMAND))){
            return;
        }
        if (!event.getEntityType().equals(EntityType.ZOMBIE))return;
        //if (isSpawned) return;

        AttributeModifier modifier = new AttributeModifier(
                UUID.randomUUID(),  // Give it a unique name
                "HoeDamage",
                2.0d,// Set the amount of damage here
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
                );

        Zombie zombie = (Zombie)event.getEntity();
        zombie.setMaxHealth(40d);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,1000,2) ,true);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000,1) ,true);
        zombie.getEquipment().setHelmet(new ItemStack(Material.ORANGE_GLAZED_TERRACOTTA,1));

        ItemStack hand = new ItemStack(Material.DIAMOND_HOE,1);
        ItemMeta meta = hand.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,modifier);
        String[] lore = {"§7 Ouch"};
        meta.setLore(Arrays.asList(lore));
        hand.setItemMeta(meta);

        zombie.getEquipment().setItemInMainHand(hand);
        zombie.getEquipment().setDropChance(EquipmentSlot.HEAD,100f);
        zombie.getEquipment().setDropChance(EquipmentSlot.HAND,50f);
        zombie.clearLootTable();

        zombie.setInvisible(true);
        isSpawned = true;
    }

}
