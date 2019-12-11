
/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Team 
{
    private ArrayList<Player> roster;
    private String teamName;
    private int teamOverall;
    
    public Team(String teamName, ArrayList<Player> roster)
    {
        this.teamName = teamName;
        this.roster = roster;
        
        int overallTotal = 0;
        for(int i = 0; i < roster.size(); i++)
        {
            overallTotal += roster.get(i).getOverall();
        }
         
    }
    
    public int calcTeamOverall()
    {
        int overallTotal = 0;
        for(int i = 0; i < roster.size(); i++)
        {
            overallTotal += roster.get(i).getOverall();
        }

        
        return teamOverall;
    }
    
    public String getTeamName()
    {
        return teamName;
    }
    
    public int getTeamOverall()
    {
        return calcTeamOverall();
    }
    
    public void printTeamInfo()
    {
        System.out.println(getTeamName());
        System.out.println("Overall: " + getTeamOverall());
        for(int i = 0; i < roster.size(); i++)
        {
            roster.get(i).printPlayerInfo();
        }
        System.out.println("");
    }
    
    public void yearlyTeamUpdate()
    {
        for(int i = 0; i < roster.size(); i++)
        {
            roster.get(i).yearlyPlayerUpdate();
        }
        int overallTotal = 0;
        for(int i = 0; i < roster.size(); i++)
        {
            overallTotal += roster.get(i).getOverall();
        }
        teamOverall = (int)(overallTotal/roster.size());;
    }
    
    public void addPlayer(Player player)
    {
        roster.add(player);
    }
    
}

