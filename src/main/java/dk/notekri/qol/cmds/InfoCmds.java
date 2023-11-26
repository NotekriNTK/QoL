package dk.notekri.qol.cmds;

import dk.notekri.qol.QoL;
import dk.notekri.qol.chat.ChatUtility;
import dk.notekri.qol.core.Handler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class InfoCmds implements CommandExecutor {

    private QoL main;
    private Handler handler;

    //  Key: Player that is responding, Value: Player that last messaged the responder.
    private HashMap<UUID,UUID> lastMessageMap = new HashMap<>();

    public InfoCmds(Handler handler){
        this.handler = handler;
        this.main = handler.getMain();
        this.setup();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) sender.sendMessage("Must be a player to execute this command!");
        assert sender instanceof Player;
        Player player = (Player)sender;

        if (label.equalsIgnoreCase("rules") || label.equalsIgnoreCase("regler")){
            player.sendMessage("§aBare ikke grief tak :)");
        }

        if (label.equalsIgnoreCase("slimechunk")){
            String msg="§cNot a slimechunk";if (player.getLocation().getChunk().isSlimeChunk()){msg="§aIt is a slimechunk";}
            player.sendMessage(msg);
        }
        if (label.equalsIgnoreCase("slimemap")){
            //  Check that it contains the correct amount of args.
            if (args.length != 0){
                player.sendMessage("§cWrong usage, try - /slimemap");
                return true;
            }

            player.sendMessage("§7Slime Chunks around you:");

            player.sendMessage(CmdsUtility.getSlimeMap(player.getLocation(), 7));
        }
        /*
        if (label.equalsIgnoreCase("w")||label.equalsIgnoreCase("whisper")||label.equalsIgnoreCase("msg")||label.equalsIgnoreCase("message")){
            if (args.length != 2){
                player.sendMessage("§cWrong usage, try - /msg <playername>");
                return true;
            }
            Player recipient = Bukkit.getPlayer(args[0]);
            String recipientName = recipient.getName();
            String message = args[1];
            if (recipient == null){
                player.sendMessage("§cThe player is not online.");
                return true;
            }
            ChatColor recipientColor = ChatUtility.getPlayerNameColour(recipient, ChatColor.GRAY);
            ChatColor playerColor    = ChatUtility.getPlayerNameColour(player, ChatColor.GRAY);
            player.sendMessage(playerColor+"You §7-> "+recipientColor+recipientName+" §7 >> "+message);
            recipient.sendMessage(playerColor+player.getName()+" §7-> "+recipientColor+"You §7 >> "+message);
        }
        if (label.equalsIgnoreCase("r")||label.equalsIgnoreCase("respond")){

        }*/

        return true;
    }


    private void setup(){
        main.getServer().getPluginCommand("rules").setExecutor(this);
        main.getServer().getPluginCommand("slimechunk").setExecutor(this);
        main.getServer().getPluginCommand("slimemap").setExecutor(this);
        //main.getServer().getPluginCommand("msg").setExecutor(this);
        //main.getServer().getPluginCommand("respond").setExecutor(this);
    }
}
