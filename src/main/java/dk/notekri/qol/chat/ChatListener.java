package dk.notekri.qol.chat;

import dk.notekri.qol.core.Handler;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;

public class ChatListener implements Listener {

    private Handler handler;
    private static final HashMap<String,String> replacementMap = new HashMap<String,String>(){{
        put("&","§");
        put(":shrug:","¯\\_(ツ)_/¯");
        put("o/","(ﾟ◡ﾟ)/");
        put(":pi:","π");
        put("<3","❤");
        put(":skull:","☠");
    }};
    public ChatListener(Handler handler){
        this.handler = handler;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent event){
        String name = event.getPlayer().getName();
        event.setJoinMessage("§8[§2+§8] §a"+name);
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent event){
        String name = event.getPlayer().getName();
        event.setQuitMessage("§8[§4-§8] §c"+name);
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onChatEvent(PlayerChatEvent event){

        String message = event.getMessage();

        //  Change the message by replacing emojis and symbols.
        for (Map.Entry<String,String> pair : replacementMap.entrySet()){message = message.replace(pair.getKey(), pair.getValue());}

        Player player = event.getPlayer();
        ChatColor nameColor = ChatUtility.getPlayerNameColour(player, ChatColor.GRAY);

        //  Change message and formatting
        event.setMessage(message);
        event.setFormat(nameColor+"%1$s §8>> §7%2$s");
    }

}
