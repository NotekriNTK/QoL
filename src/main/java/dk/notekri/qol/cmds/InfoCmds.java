package dk.notekri.qol.cmds;

import dk.notekri.qol.QoL;
import dk.notekri.qol.core.Handler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCmds implements CommandExecutor {

    private QoL main;
    private Handler handler;

    public InfoCmds(Handler handler){
        this.handler = handler;
        this.main = handler.getMain();
        this.setup();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Must be a player to execute this command!");
        }
        Player player = (Player)sender;

        if (label.equalsIgnoreCase("rules") || label.equalsIgnoreCase("regler")){
            player.sendMessage("§aBare ikke grief tak :)");
        }

        if (label.equalsIgnoreCase("slimechunk")){
            String msg="§cDet er ikke en slimechunk";if (player.getLocation().getChunk().isSlimeChunk()){msg="§aDet er en slimechunk";}
            player.sendMessage(msg);
        }

        return true;
    }


    private void setup(){
        main.getServer().getPluginCommand("rules").setExecutor(this);
        main.getServer().getPluginCommand("slimechunk").setExecutor(this);
    }
}
