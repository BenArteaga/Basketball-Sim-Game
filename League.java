
/**
 * Write a description of class League here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class League
{
    private ArrayList<Team> teams;
    private Team userTeam;
    private String leagueName;
    private int leagueYear;
    
    public League(ArrayList<Team> teams, Team userTeam, String leagueName,
    int leagueYear)
    {
        this.userTeam = userTeam;
        this.teams = teams;
        this.leagueName = leagueName;
        this.leagueYear = leagueYear;
    }
    
    public String getLeagueName()
    {
        return leagueName;
    }
    
    public int getLeagueYear()
    {
        return leagueYear;
    }
    
    public boolean simOneGame(Team cpu)
    {
        boolean win = true;
        int random = (int)(Math.random() * (5 + 1));
        if(userTeam.getTeamOverall() - cpu.getTeamOverall() == 0)
        {
            if(random < 0.5)
            {
                win = false;
            }
        }
        else if(userTeam.getTeamOverall() - cpu.getTeamOverall() < 3 && userTeam.getTeamOverall() - cpu.getTeamOverall() > 0)
        {
            if(random < 0.6)
            {
                win = false;
            }
        }
        else if(userTeam.getTeamOverall() - cpu.getTeamOverall() < 5 && userTeam.getTeamOverall() - cpu.getTeamOverall() > 2)
        {
            if(random < 0.7)
            {
                win = false;
            }
        }
        else if(userTeam.getTeamOverall() - cpu.getTeamOverall() < 8 && userTeam.getTeamOverall() - cpu.getTeamOverall() > 4)
        {
            if(random < 0.8)
            {
                win = false;
            }
        }
        else if(userTeam.getTeamOverall() - cpu.getTeamOverall() > 7)
        {
            if(random < 0.9)
            {
                win = false;
            }
        }
        else if(cpu.getTeamOverall() - userTeam.getTeamOverall() < 3 && cpu.getTeamOverall() - userTeam.getTeamOverall() > 0)
        { 
            if(random > 0.4)
            {
                win = false;
            }
        }
        else if(cpu.getTeamOverall() - userTeam.getTeamOverall() < 5 && cpu.getTeamOverall() - userTeam.getTeamOverall() > 2)
        {
            if(random > 0.3)
            {
              win = false;
            }
        }
        else if(cpu.getTeamOverall() - userTeam.getTeamOverall() < 7 && cpu.getTeamOverall() - userTeam.getTeamOverall() > 4)
        {
            if(random > 0.2)
            {
                win = false;
            }
        }
        else if(cpu.getTeamOverall() - userTeam.getTeamOverall() > 7)
        {
            if(random > 0.1)
            {
                win = false;
            }
        }        
        return win;
    }
    
    public int getTotalWins()
    {
        int totalWins = 0;
        for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        }
        for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        }
        for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        } 
                for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        } 
                for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        } 
                for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        } 
                for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        } 
                for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        } 
                for(int i = 0; i < teams.size(); i++)
        {
            if(simOneGame(teams.get(i)) == true)
            {
                totalWins++;
            }
        } 
        return totalWins;
    }
    
    public int getTotalLosses(int totalWins)
    {
        int totalLosses = 81 - totalWins;
        return totalLosses;
    }
    
    public void printLeagueInfo()
    {
        for(int i = 0; i < teams.size(); i++)
        {
            teams.get(i).printTeamInfo();
        }
    }
    
    public void leagueUpdate()
    {
        leagueYear++;
        for(int i = 0; i < teams.size(); i++)
        {
            teams.get(i).yearlyTeamUpdate();
        }
        userTeam.yearlyTeamUpdate();
    }
}
