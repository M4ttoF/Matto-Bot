package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static matthew.farias.bot.Commands.SongCommand.player;
import static matthew.farias.bot.Main.jda;

/**
 * Created by Matto on 2016-11-16.
 */
public class ServersCommand implements Command{
    private String serverList="";
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        try{
            event.getTextChannel().sendMessage("I'm in these severs right now ^.^");
            for(int i=0;i<jda.getGuilds().size();i++){
                serverList+="\n"+jda.getGuilds().get(i).getName();
            }
            event.getTextChannel().sendMessage(serverList);

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
