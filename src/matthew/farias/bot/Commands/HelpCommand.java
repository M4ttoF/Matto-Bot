package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static matthew.farias.bot.Commands.SongCommand.player;

/**
 * Created by Matto on 2016-11-17.
 */
public class HelpCommand implements Command{
    public final String HELP ="Command list\n" +
            "~!join <voice channel>\n" +
            "~!leave\n" +
            "~!move <@user> <voice channel>\n" +
            "~!pause\n" +
            "~!ping\n" +
            "~!play\n" +
            "~!playlist <song> <song>...\n" +
            "~!restart\n" +
            "~!song <song>\n" +
            "~!stop\n" +
            "~!volume <0-100>";
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try {
            event.getTextChannel().sendMessage(HELP);
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
