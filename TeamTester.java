
/**
 * Write a description of class TeamTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class TeamTester
{
    public static void main(String[] args)
    {
        Player curry = new Player("Stephen Curry", "PG", 21, 29, 99, 95, 95, 85, 87, 84, 78, 99, 95);
        Player klay = new Player("Klay Thompson", "SG", 21, 27, 98, 88, 81, 95, 75, 86, 83, 99, 90);
        Player kd = new Player("Kevin Durant", "SF", 19, 29, 99, 99, 84, 90, 86, 99, 95, 90, 99);
        Player draymond = new Player("Draymond Green", "PF", 22, 27, 76, 80, 89, 94, 86, 75, 74, 95, 86);
        Player cousins = new Player("Demarcus Cousins", "C", 21, 30, 84, 97, 80, 89, 97, 92, 86, 84, 95);
        
        ArrayList<Player> roster = new ArrayList();
        roster.add(curry);
        roster.add(klay);
        roster.add(kd);
        roster.add(draymond);
        roster.add(cousins);
        
        Team warriors = new Team("Golden State Warriors", roster);
        warriors.printTeamInfo();
        

        
        
 
   }
    
    
    

}
