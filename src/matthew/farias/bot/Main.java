package matthew.farias.bot;

import matthew.farias.bot.Commands.*;
import matthew.farias.bot.util.CommandParser;
import matthew.farias.bot.util.MattoBot;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.managers.AudioManager;

import java.util.HashMap;


/**
 * Created by Matto on 2016-11-15.
 */
public class Main {
    public static JDA jda;

    public static final CommandParser parser = new CommandParser();

    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static AudioManager manager;

    public static void main(String[]args){
        try{
            jda = new JDABuilder().addListener(new BotListener()).setBotToken(MattoBot.DISCORD_TOKEN).buildBlocking();
            jda.setAutoReconnect(true);
        } catch(Exception e){
            e.printStackTrace();
        }
        commands.put("ping", new PingCommand());
        commands.put("move", new MoveCommand());
        commands.put("join", new JoinCommand());
        commands.put("leave", new LeaveCommand());
        commands.put("song", new SongCommand());
        commands.put("play", new PlayCommand());
        commands.put("pause", new PauseCommand());
        commands.put("stop", new StopCommand());
        commands.put("restart", new RestartCommand());
        commands.put("playlist", new PlaylistCommand());
        commands.put("playing", new PlayingCommand());
        commands.put("volume", new VolumeCommand());


    }
    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if(commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
            if(safe) {
                commands.get(cmd.invoke).action(cmd.args,cmd.event);
            } else{
                commands.get(cmd.invoke).action(cmd.args,cmd.event);
            }
        }
    }
}

