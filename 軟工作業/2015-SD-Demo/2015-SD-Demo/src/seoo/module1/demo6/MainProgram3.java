package seoo.module1.demo6;

import java.util.ArrayList;
import java.util.List;

public class MainProgram3
{

    public static void main(String[] args)
    {
        List<RpgPerson> people = new ArrayList<RpgPerson>();
        
        people.add(RpgPerson.newInstance("Tom", "swordsman"));
        people.add(RpgPerson.newInstance("Mary", "magacian"));
       
        for(RpgPerson p:people)
        {
            System.out.println(p.getName());
            p.attack();
            p.cure();
        }

    }

}
