package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static matthew.farias.bot.Commands.SongCommand.player;

/**
 * Created by Matto on 2016-11-17.
 */
public class VolumeCommand implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        try {
            player.setVolume(Float.parseFloat(args[0])/100);
        }
        catch (Exception e){}

    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
