package dk.notekri.qol.chat;

import dk.notekri.qol.core.Handler;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.HashMap;
import java.util.Map;

public class ChatListener implements Listener {

    private Handler handler;
    private static HashMap<String,String> replacementMap = new HashMap<String,String>(){{
        put("&","§");
        put(":shrug:","¯\\_(ツ)_/¯");
        put("o/","(ﾟ◡ﾟ)/");
        put(":pi:","π");
    }};
    //d
    public ChatListener(Handler handler){
        this.handler = handler;
    }

    @EventHandler
    public void onChatEvent(PlayerChatEvent event){
        String message = event.getMessage();
        for (String key : replacementMap.keySet()){

        }
        event.setMessage(message);
        event.setFormat("§7%1$s §8>> §7%2$s");
        String format = event.getFormat();
        System.out.println("Format: " + format);
        System.out.println("Message: "+ message);


    }

}
