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

            /*int size;//   Not using this anymore.
            //  Avoid exception when wrong input type is given.
            try{
                size = Integer.parseInt(args[0]);
            }catch(NumberFormatException exception){
                player.sendMessage("§cSize must be a number");
                return true;
            }*/

            player.sendMessage("§7Slime Chunks around you:");

            player.sendMessage(CmdsUtility.getSlimeMap(player.getLocation(), 7));
        }

        return true;
    }


    private void setup(){
        main.getServer().getPluginCommand("rules").setExecutor(this);
        main.getServer().getPluginCommand("slimechunk").setExecutor(this);
        main.getServer().getPluginCommand("slimemap").setExecutor(this);
    }
}
