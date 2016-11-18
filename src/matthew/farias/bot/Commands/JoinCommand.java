package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.entities.VoiceChannel;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.managers.AudioManager;

import static matthew.farias.bot.Main.manager;

/**
 * Created by Matto on 2016-11-15.
 */
public class JoinCommand implements Command{
    private final String HELP="USAGE: ~!join <channel>";
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        boolean chanExists=false;
        for(VoiceChannel chan : event.getGuild().getVoiceChannels()) {
            if(chan.getName().equalsIgnoreCase(args[0])) {
                chanExists = true;
                break;
            }

        }
        return chanExists;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        VoiceChannel vc = null;

        for(VoiceChannel chan : event.getGuild().getVoiceChannels()) {
            if(chan.getName().equalsIgnoreCase((args[0]))) {
                vc = chan;
                break;
            }
        }
        manager = vc.getGuild().getAudioManager();
        if(manager.isConnected() && manager.getConnectedChannel()!=vc){
            manager.moveAudioConnection(vc);
        }
        else if(manager.isConnected()){
            event.getTextChannel().sendMessage("Already in that channel!");
        }else{
            manager.openAudioConnection(vc);
        }

    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
