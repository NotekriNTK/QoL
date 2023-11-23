package dk.notekri.qol.cmds;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;

public class CmdsUtility {

    public static String getSlimeMap(Location location, int size){
        //  Value to return
        StringBuilder map = new StringBuilder();

        //  Setting up important variables
        int half = size/2;

        Chunk centerChunk = location.getChunk();
        World world = location.getWorld();

        int zCenter = centerChunk.getZ();
        int xCenter = centerChunk.getX();

        //  Setting up dynamic variables
        Chunk checkChunk;
        String colour;
        String symbol;

        for (int z = -half; z < size-half; z++){
            for (int x =-half; x < size-half; x++){

                checkChunk = world.getChunkAt(xCenter+x,zCenter+z,false);

                colour = "§7";
                if (checkChunk.isSlimeChunk()){colour = "§a";}

                symbol = "#";
                if (z == 0 && x == 0){symbol = "0";}

                map.append(colour).append(symbol);
            }
            map.append("\n");
        }
        return map.toString();
    }

}
