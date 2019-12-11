
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Player
{
    private String name, position;
    private int age, ageEntered, shooting, finishing, passing, defense, rebounding,
    size, athleticism, intangibles, potential, overall;
    
    public Player(String name, String position, int ageEntered, int age, 
    int shooting, int finishing, int passing, int defense, int rebounding, int size, int athleticism,
    int intangibles, int potential)
    {
        this.name = name;
        this.position = position;
        this.ageEntered = ageEntered;
        this.age = age;
        this.shooting = shooting;
        this.finishing = finishing;
        this.passing = passing;
        this.defense = defense;
        this.rebounding = rebounding;
        this.size = size;
        this.athleticism = athleticism;
        this.intangibles = intangibles;
        this.potential = potential;
        
        overall = (int)((shooting + finishing + passing + defense + rebounding
        + size + athleticism + intangibles)/8);
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getAgeEntered()
    {
        return ageEntered;
    }
    
    public int getShooting()
    {
        return shooting;
    }
    
    public int getFinishing()
    {
        return finishing;
    }
    
    public int getPassing()
    {
        return passing;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public int getDefense()
    {
        return defense;
    }
    
    public int getRebounding()
    {
        return rebounding;
    }
    
    public int getAthleticism()
    {
        return athleticism;
    }
    
    public int getIntangibles()
    {
        return intangibles;
    }
    
    public int getPotential()
    {
        return potential;
    }
    
    public int getOverall()
    {
        return overall;
    }
    
    public void increaseAge()
    {
        age++;
    }
    
    public void printPlayerInfo()
    {
        System.out.println(getName() + "\t" + getPosition() + "\t" + getAge() + " OVR: " + getOverall() + " Pot: " + getPotential() +
        " shot: " + getShooting() + " finish: " + getFinishing() + " Pass: " + getPassing() + " Def: " + getDefense() + 
        " Reb: " + getRebounding() + " Size: " + getSize() + " ath: " + getAthleticism() + " intangibles: " + getIntangibles() + "\n");

    }
    
    public void changeOverall()
    {
        if(getAge() - getAgeEntered() < 5)
        {
            int random = (int)(Math.random() * (5 + 1));
            if((overall + random) <= getPotential())
            {
            overall = overall + random;
            }
            else
            {
                overall = potential;
            }
        }
        else if(getAge() - getAgeEntered() > 12)
        {
            int random = (int)(Math.random() * (5 + 1));
            overall = overall - random;
        }
        else
        {
            int random1 = (int)(Math.random() * (2 + 1));
            double random2 = Math.random();
            if(random2 >= 0.5 && (overall + random1) <= potential)
            {
                overall = overall + random1;
            }
            else
            {
                overall = overall - random1;
            }
        }
    }
    
    public void yearlyPlayerUpdate()
    {
        increaseAge();
        changeOverall();
    }

}
