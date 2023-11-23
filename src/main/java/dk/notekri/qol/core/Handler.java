package dk.notekri.qol.core;

import dk.notekri.qol.QoL;
import dk.notekri.qol.chat.ChatListener;
import dk.notekri.qol.cmds.InfoCmds;

public class Handler {

    private QoL main;
    private ChatListener chatListener;
    private InfoCmds infoCmds;

    public Handler(QoL main){
        this.main = main;
        this.setup();
    }


    private void setup(){
        this.chatListener = new ChatListener(this);
        main.getServer().getPluginManager().registerEvents(chatListener, main);
        this.infoCmds = new InfoCmds(this);
    }


    //      GETTERS AND SETTERS

    public QoL getMain(){return this.main;}
    public ChatListener getChatListener(){return this.chatListener;}


}
