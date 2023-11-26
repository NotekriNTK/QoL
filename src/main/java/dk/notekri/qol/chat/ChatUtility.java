package dk.notekri.qol.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class ChatUtility {

    public static ChatColor getPlayerNameColour(Player player, ChatColor defaultColor){
        //  Get team colour if it exists, otherwise make the name colour gray.
        Team team = player.getScoreboard().getPlayerTeam(player);
        ChatColor nameColor = defaultColor;
        if (team!=null && team.hasColor()){nameColor = team.getColor();}
        return nameColor;

    }

}
