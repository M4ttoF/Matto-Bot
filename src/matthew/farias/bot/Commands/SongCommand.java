package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.audio.player.FilePlayer;
import net.dv8tion.jda.audio.player.Player;
import net.dv8tion.jda.audio.player.URLPlayer;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.managers.AudioManager;
import sun.audio.AudioPlayer;

import java.io.File;
import java.net.URL;

import static matthew.farias.bot.Main.jda;
import static matthew.farias.bot.Main.manager;
import static matthew.farias.bot.Main.volume;

/**
 * Created by Matto on 2016-11-16.
 */

public class SongCommand implements Command{
    private final String HELP="USAGE: ~!song <song>\n" +
            "Song List:\n" +
            "myB (Leffen diss track)\n" +
            "puffs (Uptown Puffs)\n" +
            "reposted (You reposted in the wrong neighborhood)\n" +
            "shrek (All Star)\n" +
            "wwide (Worldwide Choppers)";
    public static Player player;
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try{
            //File song=new File(args[0]);
            File test = new File("C:\\Users\\Matto\\IdeaProjects\\Discord Bot\\src\\matthew\\farias\\bot\\Commands\\songs\\"+args[0]+".wav");
            FilePlayer filePlayer = new FilePlayer(test);
            player=filePlayer;
            manager.setSendingHandler(player);
            player.play();
            player.setVolume(volume);



        }
        catch (Exception e){
            event.getTextChannel().sendMessage(help());
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
