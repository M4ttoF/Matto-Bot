package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static matthew.farias.bot.Commands.SongCommand.player;
import static matthew.farias.bot.Main.manager;

/**
 * Created by Matto on 2016-11-16.
 */
public class LeaveCommand implements Command{
    private final String HELP="USAGE: ~!leave";
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(!manager.isConnected()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        manager.closeAudioConnection();
        try{
            if(player.isPlaying()) {
                player.stop();
            }
        } catch (Exception e){}
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
