package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static matthew.farias.bot.Commands.SongCommand.player;
import static matthew.farias.bot.Main.volume;

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
            float num = Float.parseFloat(args[0])/100;
            if(num>1){
                num=1;
            }
            if (num>100){
                num=100;
            }
            volume=num;
            player.setVolume(volume);
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
