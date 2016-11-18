package matthew.farias.bot;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by Matto on 2016-11-15.
 */
public interface Command {

    public boolean called(String[] args, MessageReceivedEvent event);
    public void action(String[] args, MessageReceivedEvent event);
    public String help();
    public void executed(boolean success, MessageReceivedEvent event);

}
