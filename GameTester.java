
/**
 * Write a description of class GameTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class GameTester
{
    static private void gameIntro()
    {
        System.out.println(" Welcome to the new NBA! Commisioner Adam Silver has ");
        System.out.println(" decided to make some changes in hopes of dethroning the");
        System.out.println(" Golden State Warriors who, with their recent aquisition ");
        System.out.println(" of Demarcus Cousins, have turned the quest for an NBA title into ");
        System.out.println(" a one-horse race. The rest of the league has been reduced");
        System.out.println(" to ten teams in order to make the rest of the league's");
        System.out.println(" talent more concentrated. There will be a snake-style fantasy");
        System.out.println(" draft to reassign players to their new teams. Do you have what");
        System.out.println(" it takes to beat the Warriors?");        
    }
    
    /**
     * Gets the user's choice of team
     */
    static private Team userFranchise(ArrayList<Team> teams)
    {
        String userFranchise = "";
        System.out.println(" First you must choose a team to lead to the promise land");
        System.out.println(" Los Angelos Lakers [A] ");
        System.out.println(" Boston Celtics [B] ");
        System.out.println(" New York Knicks [C] ");
        System.out.println(" Detroit Pistons [D] ");
        System.out.println(" Philadelphia 76ers [E] ");
        System.out.println(" Houston Rockets [F] ");
        System.out.println(" San Antonio Spurs [G] ");
        System.out.println(" Miami Heat [H] ");
        System.out.println(" Chicago Bulls [I] ");
        System.out.println(" Utah Jazz [J] ");
        
        Scanner in = new Scanner(System.in);
        
        System.out.println(" Please select a team by entering one of the letters");
        String userAns = in.next();
        
        if(userAns.equalsIgnoreCase("a"))
        {
            userFranchise = "Los Angelos Lakers";
        }
        else if(userAns.equalsIgnoreCase("b"))
        {
            userFranchise = "Boston Celtics";
        }
        else if(userAns.equalsIgnoreCase("c"))
        {
            userFranchise = "New York Knicks";
        }
        else if(userAns.equalsIgnoreCase("d"))
        {
            userFranchise = "Detroit Pistons";
        }
        else if(userAns.equalsIgnoreCase("e"))
        {
            userFranchise = "Philadelphia 76ers";
        }
        else if(userAns.equalsIgnoreCase("f"))
        {
            userFranchise = "Houston Rockets";
        }
        else if(userAns.equalsIgnoreCase("g"))
        {
            userFranchise = "San Antonio Spurs";
        }
        else if(userAns.equalsIgnoreCase("h"))
        {
            userFranchise = "Miami Heat";
        }
        else if(userAns.equalsIgnoreCase("i"))
        {
            userFranchise = "Chicago Bulls";
        }
        else if(userAns.equalsIgnoreCase("j"))
        {
            userFranchise = "Utah Jazz";
        }
        
        int teamNum = 0;
        for(int i = 0; i < teams.size(); i++)
        {
            if(userFranchise.equals(teams.get(i).getTeamName()))
            {
                teamNum = i;
            }
        }
        return teams.get(teamNum);
   
    }
    
    static private void printPlayerList(ArrayList<Player> players)
    {
        insertSortOverall(players);
        for(int i = 0; i < players.size(); i++)
        {
            players.get(i).printPlayerInfo();
        }
    }
    
    static private void leagueUpdate(ArrayList<Player> players)
    {
        for(int i = 0; i < players.size(); i++)
        {
            players.get(i).yearlyPlayerUpdate();
        }
    }
    
    static private void playerSearch(ArrayList<Player> players)
    {
        System.out.println(" Enter a player: ");
        Scanner in = new Scanner(System.in);
        String userPlayer = in.nextLine();
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equals(userPlayer))
            {
                players.get(i).printPlayerInfo();
            }
        }
    }
    
    static private void insertSortOverall(ArrayList<Player> players)
    {
        for(int i = 1; i < players.size(); i++)
        {
            Player playerToSort = players.get(i);
            Integer j = i;
            while(j > 0 && players.get(j - 1).getOverall() < playerToSort.getOverall())
            {
                players.set(j, players.get(j - 1));
                j--;
            }
            players.set(j, playerToSort);
        }
        
    }
    
    static private int draftLottery()
    {
        double random = Math.random();
        int draftPosition = 1 + (int)(random * 10);
        return draftPosition;
    }
    
    static private void cpuSelection(ArrayList<Player> players, Team team)
    {
        double random = Math.random();
        if(players.size() >= 4)
        {
        if(random < 0.25)
        {
            Player selection = players.get(0);               
            players.remove(selection); 
            team.addPlayer(selection);
            System.out.println("The " + team.getTeamName() + " have selected " + players.get(0).getName());
        }
        else if(random < 0.5)
        {
            Player selection = players.get(1);               
            players.remove(selection); 
            team.addPlayer(selection);
            System.out.println("The " + team.getTeamName() + " have selected " + players.get(1).getName());
        }
        else if(random < 0.75)
        {
            Player selection = players.get(2);               
            players.remove(selection); 
            team.addPlayer(selection);
            System.out.println("The " + team.getTeamName() + " have selected " + players.get(2).getName());
        }
        else
        {
            Player selection = players.get(3);               
            players.remove(selection); 
            team.addPlayer(selection);
            System.out.println("The " + team.getTeamName() + " have selected " + players.get(3).getName());
        }
       }
       else 
       {
           Player selection = players.get(0);
           players.remove(selection);
           team.addPlayer(selection);
           System.out.println("The " + team.getTeamName() + " have selected " + players.get(0).getName());
       }
       
    }
    
    static private void draft(ArrayList<Player> players, Team userTeam, ArrayList<Team> teams)
    {
        int userPick = draftLottery(); 
        System.out.println(" Welcome to the new 2018 GSWBA (Golden State Warriors Basketball Association)" +
        " draft. you have been awarded the " + userPick + "th pick" +
        " in this snake-style draft. Good luck! ");
        
        //round1
        for(int i = 0; i < userPick -1; i++)
        {
            cpuSelection(players, teams.get(i));
        }
        
        System.out.println(" You are on the clock. Who would you like to select? ");
        printPlayerList(players);
        
        Scanner in = new Scanner(System.in);
        String userPlayer = in.nextLine();
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equals(userPlayer))
            {
                Player selection = players.get(i);               
                players.remove(selection); 
                userTeam.addPlayer(selection);
            }
        }
        
        for(int i = userPick; i < teams.size(); i++)
        {
            cpuSelection(players, teams.get(i));
        }
        
        //round 2
        for(int i = teams.size() -1; i > userPick -1; i--)
        {
            cpuSelection(players, teams.get(i));
        }
        
        System.out.println(" You are on the clock. Who would you like to select? ");
        printPlayerList(players);
        userTeam.printTeamInfo();
        
        String userPlayer2 = in.nextLine();
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equals(userPlayer2))
            {
                Player selection = players.get(i);               
                players.remove(selection); 
                userTeam.addPlayer(selection);
            }
        }
        
        for(int i = userPick -1; i >= 0; i--)
        {
            cpuSelection(players, teams.get(i));
        }
        
        //round 3
        for(int i = 0; i < userPick -1; i++)
        {
            cpuSelection(players, teams.get(i));
        }
        
        System.out.println(" You are on the clock. Who would you like to select? ");
        printPlayerList(players);
        userTeam.printTeamInfo();

        String userPlayer3 = in.nextLine();
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equals(userPlayer3))
            {
                Player selection = players.get(i);               
                players.remove(selection); 
                userTeam.addPlayer(selection);
            }
        }
        
        for(int i = userPick; i < teams.size(); i++)
        {
            cpuSelection(players, teams.get(i));
        }
        
        //round4
        for(int i = teams.size() -1; i > userPick -1; i--)
        {
            cpuSelection(players, teams.get(i));
        }
        
        System.out.println(" You are on the clock. Who would you like to select? ");
        printPlayerList(players);
        userTeam.printTeamInfo();
        
        String userPlayer4 = in.nextLine();
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equals(userPlayer4))
            {
                Player selection = players.get(i);               
                players.remove(selection); 
                userTeam.addPlayer(selection);
            }
        }
        
        for(int i = userPick -1; i >= 0; i--)
        {
            cpuSelection(players, teams.get(i));
        }
        
        //round5
        for(int i = 0; i < userPick -1; i++)
        {
            cpuSelection(players, teams.get(i));
        }
        
        System.out.println(" You are on the clock. Who would you like to select? ");
        printPlayerList(players);
        userTeam.printTeamInfo();

        String userPlayer5 = in.nextLine();
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equals(userPlayer5))
            {
                Player selection = players.get(i);               
                players.remove(selection); 
                userTeam.addPlayer(selection);
            }
        }
        
        for(int i = userPick; i < teams.size(); i++)
        {
            cpuSelection(players, teams.get(i));
        }
        
        System.out.println(" Congratulations! You have completed the draft. ");
        System.out.println(" This is your final roster: ");
        userTeam.printTeamInfo();
        
        
    }
    
    
       
    public static void main(String[] args)
    {
        Player king = new Player("Lebron James", "SF", 19, 34, 90, 99, 97, 92, 92, 95, 99, 99, 99);
        Player claw = new Player("Kawhi Leonard", "SF", 20, 27, 94, 94, 83, 99, 83, 90, 90, 95, 99);
        Player harden = new Player("James Harden", "SG", 20, 29, 96, 97, 94, 77, 87, 85, 86, 90, 93);
        Player westbrook = new Player("Russell Westbrook", "PG", 20, 30, 83, 97, 95, 90, 90, 88, 99, 84, 97);
        Player brow = new Player("Anthony Davis", "PF", 19, 25, 80, 96, 75, 97, 93, 96, 96, 90, 99);
        Player giannis = new Player("Giannis Antetokounmpo", "SF", 19, 24, 75, 98, 83, 89, 89, 99, 97, 90, 99);
        Player cp3 = new Player("Chris Paul", "PG", 20, 33, 93, 87, 98, 96, 80, 75, 78, 98, 92);
        Player dame = new Player("Damian Lillard", "PG", 22, 28, 96, 93, 86, 85, 79, 82, 88, 93, 94);
        Player kat = new Player("Karl Anthony-Towns", "C", 20, 23, 92, 94, 77, 82, 96, 96, 88, 85, 96);
        Player pg13 = new Player("Paul George", "SG", 20, 28, 96, 90, 75, 92, 83, 93, 90, 94, 94);
        Player kyrie = new Player("Kyrie Irving", "PG", 19, 26, 96, 95, 85, 76, 73, 75, 85, 90, 90);
        Player wall = new Player("John Wall", "PG", 20, 28, 82, 92, 94, 90, 78, 87, 97, 87, 95);
        Player butler = new Player("Jimmy Butler", "SG", 22, 29, 88, 86, 80, 93, 82, 89, 87, 93, 90);
        Player hayward = new Player("Gordon Hayward", "SF", 20, 28, 86, 83, 80, 82, 76, 83, 82, 90, 86);
        Player gobert = new Player("Rudy Gobert", "C", 21, 26, 60, 82, 75, 99, 95, 93, 86, 85, 88);
        Player lowry = new Player("Kyle Lowry", "PG", 20, 32, 93, 80, 87, 87, 80, 78, 76, 90, 83);
        Player blake = new Player("Blake Griffin", "PF", 21, 29, 79, 88, 82, 84, 80, 82, 93, 83, 90);
        Player joker = new Player("Nikola Jokic", "C", 20, 23, 90, 87, 92, 74, 86, 83, 80, 94, 90);
        Player unicorn = new Player("Kristaps Porzingis", "PF", 20, 23, 90, 82, 73, 86, 80, 93, 81, 90, 90);
        Player joel = new Player("Joel Embiid ", "C", 22, 24, 79, 94, 80, 89, 94, 93, 88, 95, 96);
        Player simmons = new Player("Ben Simmons", "PG", 21, 22, 57, 95, 92, 90, 87, 99, 96, 90, 99);
        Player derozan = new Player("Demar Derozan", "SG", 20, 29, 88, 86, 80, 82, 72, 84, 88, 87, 87);
        Player marc = new Player("Marc Gasol", "C", 24, 34, 84, 86, 80, 89, 82, 88, 68, 85, 83);
        Player love = new Player("Kevin Love", "PF", 20, 30, 90, 84, 75, 73, 87, 81, 73, 89, 82);
        Player kemba = new Player("Kemba Walker", "PG", 21, 28, 89, 84, 77, 73, 73, 76, 84, 87, 82);
        Player deandre = new Player("Deandre Jordan", "C", 20, 30, 54, 87, 65, 85, 99, 83, 92, 85, 90);
        Player oladipo = new Player("Victor Oladipo", "SG", 21, 26, 87, 88, 79, 96, 82, 79, 91, 90, 90);
        Player beal = new Player("Bradley Beal", "SG", 19, 25, 92, 85, 78, 77, 75, 79, 80, 88, 85);
        Player whiteside = new Player("Hassan Whiteside", "C", 21, 29, 50, 85, 66, 94, 96, 88, 88, 80, 88);
        Player middleton = new Player("Khris Middleton", "SG", 21, 27, 87, 82, 77, 80, 80, 85, 78, 86, 85);
        Player melo = new Player("Carmelo Anthony", "SF", 19, 34, 85, 80, 71, 73, 80, 80, 75, 70, 80);
        Player doncic = new Player("Luca Doncic", "PG", 19, 19, 88, 85, 90, 76, 80, 90, 77, 97, 90);
        Player tatum = new Player("Jayson Tatum", "SF", 19, 20, 93, 87, 75, 85, 82, 84, 89, 92, 97);
        Player brown = new Player("Jaylen Brown", "SG", 20, 22, 85, 81, 72, 87, 75, 85, 90, 86, 93);
        Player booker = new Player("Devin Booker", "SG", 19, 22, 95, 83, 75, 70, 73, 80, 80, 82, 88);
        Player ayton = new Player("Deandre Ayton", "C", 19, 19, 78, 85, 70, 84, 88, 93, 90, 80, 95);
        Player bagley = new Player("Marvin Bagley", "PF", 19, 19, 76, 84, 70, 75, 85, 83, 92, 85, 92);
        Player bamba = new Player("Mohamed Bamba", "C", 20, 20, 71, 79, 69, 88, 87, 99, 85, 90, 99);
        Player cj = new Player("C.J. Mccollum", "SG", 22, 27, 91, 84, 77, 75, 70, 72, 78, 87, 84);
        Player dragic = new Player("Goran Dragic", "PG", 22, 32, 87, 82, 83, 76, 74, 73, 78, 90, 82);
        Player tobias = new Player("Tobias Harris", "SF", 19, 26, 87, 85, 76, 72, 80, 82, 77, 86, 85);
        Player wiggins = new Player("Andrew Wiggins", "SF", 19, 23, 79, 83, 71, 85, 75, 78, 93, 80, 94);
        Player clint = new Player("Clint Capela", "C", 20, 24, 52, 82, 72, 84, 85, 80, 80, 88, 84);
        Player jrue = new Player("Jrue Holiday", "PG", 19, 28, 78, 85, 80, 80, 70, 80, 80, 85, 82);
        Player barnes = new Player("Harrison Barnes", "PF", 20, 26, 81, 81, 73, 85, 80, 78, 83, 87, 85);
        Player conley = new Player("Mike Conley", "PG", 20, 31, 79, 75, 74, 70, 68, 70, 70, 85, 76);
        Player avery = new Player("Avery Bradley", "SG", 20, 28, 85, 77, 73, 90, 70, 75, 85, 87, 83);
        Player lonzo = new Player("Lonzo Ball", "PG", 20, 21, 62, 65, 88, 82, 82, 87, 88, 85, 92);
        Player ingram = new Player("Brandon Ingram", "SG", 19, 21, 86, 83, 70, 80, 83, 90, 82, 80, 94);
        Player it4 = new Player("Isiah Thomas", "PG", 22, 29, 90, 83, 80, 66, 70, 66, 93, 90, 87);
                
        ArrayList<Player> players = new ArrayList();
        players.add(king);
        players.add(claw);
        players.add(harden);
        players.add(westbrook);
        players.add(brow);
        players.add(giannis);
        players.add(cp3);
        players.add(dame);
        players.add(kat);
        players.add(pg13);
        players.add(kyrie);
        players.add(wall);
        players.add(butler);
        players.add(hayward);
        players.add(gobert);
        players.add(lowry);
        players.add(blake);
        players.add(joker);
        players.add(unicorn);
        players.add(joel);
        players.add(simmons);
        players.add(derozan);
        players.add(marc);
        players.add(love);
        players.add(kemba);
        players.add(deandre);
        players.add(oladipo);
        players.add(beal);
        players.add(whiteside);
        players.add(middleton);
        players.add(melo);
        players.add(doncic);
        players.add(tatum);
        players.add(brown);
        players.add(booker);
        players.add(ayton);
        players.add(bagley);
        players.add(bamba);
        players.add(cj);
        players.add(dragic);
        players.add(tobias);
        players.add(wiggins);
        players.add(clint);
        players.add(jrue);
        players.add(barnes);
        players.add(conley);
        players.add(avery);
        players.add(lonzo);
        players.add(ingram);
        players.add(it4);
        
        ArrayList<Player> lakersPlayers = new ArrayList();
        ArrayList<Player> knicksPlayers = new ArrayList();
        ArrayList<Player> celticsPlayers = new ArrayList();
        ArrayList<Player> pistonsPlayers = new ArrayList();
        ArrayList<Player> rocketsPlayers = new ArrayList();
        ArrayList<Player> heatPlayers = new ArrayList();
        ArrayList<Player> jazzPlayers = new ArrayList();
        ArrayList<Player> spursPlayers = new ArrayList();
        ArrayList<Player> bullsPlayers = new ArrayList();
        ArrayList<Player> phillyPlayers = new ArrayList();
        
        Team lakers = new Team("Los Angelos Lakers", lakersPlayers);
        Team knicks = new Team("New York Knicks", knicksPlayers);
        Team celtics = new Team("Boston Celtics", celticsPlayers);
        Team pistons = new Team("Detroit Pistons", pistonsPlayers);
        Team rockets = new Team("Houston Rockets", rocketsPlayers);
        Team heat = new Team("Miami Heat", heatPlayers);
        Team jazz = new Team("Utah Jazz", jazzPlayers);
        Team spurs = new Team("San Antonio Spurs", spursPlayers);
        Team bulls = new Team("Chicago Bulls", bullsPlayers);
        Team philly = new Team("Philadelphia 76ers", phillyPlayers);
        
        ArrayList<Team> teams = new ArrayList();
        teams.add(lakers);
        teams.add(knicks);
        teams.add(celtics);
        teams.add(pistons);
        teams.add(rockets);
        teams.add(heat);
        teams.add(jazz);
        teams.add(spurs);
        teams.add(bulls);
        teams.add(philly);
        
        Team userTeam;
        gameIntro();
        userTeam = userFranchise(teams);
        teams.remove(userTeam);
        draft(players, userTeam, teams);
        
        League nba = new League(teams, userTeam, "NBA", 2018);
        int wins1 = nba.getTotalWins();
        int losses1 = nba.getTotalLosses(wins1);
        nba.printLeagueInfo();
        
        System.out.println("");
        System.out.println(" Your record for the 2018 nba season was " + wins1 + "-" + losses1);
        nba.leagueUpdate();
        
        System.out.println(" This is your 2019 team");
        userTeam.printTeamInfo();
        
        int wins2 = nba.getTotalWins();
        int losses2 = nba.getTotalLosses(wins2);
        
        System.out.println("");
        System.out.println(" Your record for the 2019 nba season was " + wins2 + "-" + losses2);
        nba.leagueUpdate();
        
        System.out.println(" This is your 2020 team");
        userTeam.printTeamInfo();
        
        int wins3 = nba.getTotalWins();
        int losses3 = nba.getTotalLosses(wins3);
        
        System.out.println("");
        System.out.println(" Your record for the 2020 nba season was " + wins3 + "-" + losses3);
        
        nba.leagueUpdate();
        System.out.println(" This is your 2021 team");
        userTeam.printTeamInfo();
        
        int wins4 = nba.getTotalWins();
        int losses4 = nba.getTotalLosses(wins4);
        
        System.out.println("");
        System.out.println(" Your record for the 2021 nba season was " + wins4 + "-" + losses4);       
        
    }

}
