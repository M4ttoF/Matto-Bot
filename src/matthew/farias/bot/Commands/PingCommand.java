package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by Matto on 2016-11-15.
 */
public class PingCommand implements Command{
    private final String HELP="USAGE: ~!ping";
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("PONG");
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
}
