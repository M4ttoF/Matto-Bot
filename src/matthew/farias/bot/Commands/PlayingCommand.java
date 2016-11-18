package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static matthew.farias.bot.Commands.SongCommand.player;

/**
 * Created by Matto on 2016-11-17.
 */
public class PlayingCommand implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try {
            if(player.isPlaying()){
                event.getTextChannel().sendMessage("True");
            }
            else {
                event.getTextChannel().sendMessage("False");
            }

        }
        catch (Exception e){

        }

    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
