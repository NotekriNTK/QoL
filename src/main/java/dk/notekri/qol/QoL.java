package dk.notekri.qol;

import dk.notekri.qol.core.Handler;
import org.bukkit.plugin.java.JavaPlugin;

public final class QoL extends JavaPlugin {
    private Handler handler;
    @Override
    public void onEnable() {
        System.out.println("(!) Vores QoL starter!");
        handler = new Handler(this);
    }

    @Override
    public void onDisable() {

    }
}
