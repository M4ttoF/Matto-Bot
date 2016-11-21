package matthew.farias.bot.Commands;

import matthew.farias.bot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import javax.swing.text.Document;
import javax.swing.text.Element;

import static matthew.farias.bot.Commands.SongCommand.player;

/**
 * Created by Matto on 2016-11-16.
 */
public class RankCommand implements Command{
    private org.jsoup.nodes.Document document;
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        try{
            String lp;
            String url="http://na.op.gg/summoner/userName=";
            String name=args[0];
            for(int i=1;i<args.length;i++){
                name+="+"+args[i];
            }
            url+=name;
            document= Jsoup.connect(url).get();
            Elements value = document.getElementsByClass("tierRank").not("TierRank");
            Elements lpVal = document.getElementsByClass("LeaguePoints");
            String rank="";
            rank=value.toString().split("\n")[1];
            rank=rank.substring(24);
            rank=rank.replaceFirst("</span>","");
            //event.getTextChannel().sendMessage(rank);
            //event.getTextChannel().sendMessage(lpVal.toString());
            if(rank.equalsIgnoreCase("Unranked ")){
                event.getTextChannel().sendMessage(rank);
            }
            else{
                lp=lpVal.toString().split("\n")[0].substring(27).replace("</span>","");
                event.getTextChannel().sendMessage(rank +" "+lp );
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
