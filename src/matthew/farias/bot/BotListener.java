package matthew.farias.bot;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.InviteReceivedEvent;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.ReconnectedEvent;
import net.dv8tion.jda.events.guild.GuildJoinEvent;
import net.dv8tion.jda.events.guild.member.GuildMemberBanEvent;
import net.dv8tion.jda.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.events.message.priv.PrivateMessageUpdateEvent;
import net.dv8tion.jda.events.user.UserAvatarUpdateEvent;
import net.dv8tion.jda.events.voice.VoiceJoinEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import static matthew.farias.bot.Main.jda;

/**
 * Created by Matto on 2016-11-15.
 */
public class BotListener extends ListenerAdapter{
    public static boolean joined=false;

    private final ArrayList<String> greetings=new ArrayList<String>(Arrays.asList("hello","hi","yo","wassup","greetings","sup"));

    private ArrayList<User>talked=new ArrayList<User>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith("~!") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId()) Main.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(), event));
    }

    @Override
    public void onReady(ReadyEvent event) {
        //Main.log("status", "Logged in as: "+event.getJDA().getSelfInfo().getUsername());

    }
    @Override
    public void onGuildJoin(GuildJoinEvent event){
        event.getGuild().getPublicChannel().sendMessage("The name's Matto Bot whats good\n~!help for Command list");
    }
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        event.getGuild().getPublicChannel().sendMessage("Yo whaddup "+event.getUser().getUsername()+"\nType in ~!help for my commands");
    }

    @Override
    public void onReconnect(ReconnectedEvent event) {
        for(int i=0;i<event.getJDA().getGuilds().size();i++){
            event.getJDA().getGuilds().get(i).getPublicChannel().sendMessage("I'm online now!");
        }
    }


    /*@Override
    public void onVoiceJoin(VoiceJoinEvent event) {
        if (joined==false){
            event.getGuild().getPublicChannel().sendMessage("Ayy it's ya boi, heard u want some tracks");
            joined=true;
        }
    }
    */


    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        try{
            if(greetings.contains(event.getMessage().getRawContent()) && !talked.contains(event.getAuthor())){
                event.getChannel().sendMessage("Hello my good sir, how do you do on this fine day");
                talked.add(event.getAuthor());
            }
            else if(!talked.contains(event.getAuthor())){
                event.getChannel().sendMessage("I deserve to be greeted with more respect");
            }
            else {
                event.getChannel().sendMessage("I have nothing more to say");
            }
        }
        catch (Exception e){}

    }

    @Override
    public void onPrivateMessageUpdate(PrivateMessageUpdateEvent event) {
        event.getChannel().sendMessage("You ain't slick boi");
    }

    @Override
    public void onUserAvatarUpdate(UserAvatarUpdateEvent event) {
        event.getUser().getPrivateChannel().sendMessage("You looked pretty good in this\n"+event.getPreviousAvatarUrl()+"\nI'm loving your new look though <3");

    }

    @Override
    public void onGuildMemberBan(GuildMemberBanEvent event) {
        event.getGuild().getPublicChannel().sendMessage("The Ban-Hammer has spoken "+event.getUser().getUsername()+"!");
    }




}
