package dk.notekri.qol.chat;

import dk.notekri.qol.core.Handler;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import java.util.HashMap;
import java.util.Map;

public class ChatListener implements Listener {

    private Handler handler;
    private static HashMap<String,String> replacementMap = new HashMap<String,String>(){{
        put("&","§");
        put(":shrug:","¯\\_(ツ)_/¯");
        put("o/","(ﾟ◡ﾟ)/");
        put(":pi:","π");
        put("<3","❤");
    }};
    public ChatListener(Handler handler){
        this.handler = handler;
    }

    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent event){
        String name = event.getPlayer().getName();
        event.setJoinMessage("§8[§2+§8] §a"+name);
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent event){
        String name = event.getPlayer().getName();
        event.setQuitMessage("§8[§4+§8] §c"+name);
    }

    @EventHandler
    public void onChatEvent(PlayerChatEvent event){
        String message = event.getMessage();
        for (Map.Entry<String,String> pair : replacementMap.entrySet()){message = message.replace(pair.getKey(), pair.getValue());}
        event.setMessage(message);
        event.setFormat("§7%1$s §8>> §7%2$s");
    }

}
