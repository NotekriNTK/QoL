package dk.notekri.qol.core;

import dk.notekri.qol.QoL;
import dk.notekri.qol.chat.ChatListener;
import dk.notekri.qol.cmds.InfoCmds;
import dk.notekri.qol.mob.MobListener;

public class Handler {

    private QoL main;
    private ChatListener chatListener;
    private MobListener mobListener;
    private InfoCmds infoCmds;

    public Handler(QoL main){
        this.main = main;
        this.setup();
    }


    private void setup(){
        this.chatListener = new ChatListener(this);
        main.getServer().getPluginManager().registerEvents(chatListener, main);
        this.mobListener = new MobListener(this);
        main.getServer().getPluginManager().registerEvents(mobListener, main);
        this.infoCmds = new InfoCmds(this);
    }


    //      GETTERS AND SETTERS

    public QoL getMain(){return this.main;}
    public ChatListener getChatListener(){return this.chatListener;}


}
