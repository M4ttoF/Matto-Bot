package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.audio.player.FilePlayer;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.io.File;
import java.util.ArrayList;

import static matthew.farias.bot.Commands.SongCommand.player;
import static matthew.farias.bot.Main.jda;
import static matthew.farias.bot.Main.manager;
import static matthew.farias.bot.Main.volume;

/**
 * Created by Matto on 2016-11-17.
 */
public class PlaylistCommand implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        ArrayList<File>playList=new ArrayList<File>();
        for(int i=0;i<args.length;i++){
            playList.add(new File("C:\\Users\\Matto\\IdeaProjects\\Discord Bot\\src\\matthew\\farias\\bot\\Commands\\songs\\"+args[i]+".wav"));
        }
        try {
            player=new FilePlayer(playList.get(0));
            manager.setSendingHandler(player);
            player.play();
            player.setVolume(volume);
            playList.remove(0);
            while(!playList.isEmpty()){
                if(!player.isPlaying()){
                    player=new FilePlayer(playList.get(0));;
                    manager.setSendingHandler(player);
                    player.play();
                    player.setVolume(volume);
                    playList.remove(0);
                }
                Thread.sleep(10000);
            }
        }
        catch (Exception e){
            event.getTextChannel().sendMessage("Error");

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
