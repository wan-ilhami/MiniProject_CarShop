import java.util.*;
import java.util.Scanner;
public class DoubleZApp
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Scanner text=new Scanner(System.in);
        Scanner c= new Scanner(System.in);
        
        DoubleZ s[] = new DoubleZ[50];
        

        boolean option= true;
        int index=0;
        int countSnorkeling=0;
        int countDiving=0;

        while(option)
        {
            System.out.println("Enter Name: ");
            String name = text.next();

            System.out.println("Enter Phone Number: ");
            String phoneNum = text.next();

            System.out.println("Enter Booking Date: ");
            String bookDate = text.next();

            System.out.println("Enter Number of Persons: ");
            int num = in.nextInt();

            System.out.println("Choose your type of package 1-Snorkelling | 2-Diving");
            int tp = in.nextInt();

            if(tp == 1)
            {
                System.out.println("Choose your room type: Twin | Triple | Quad");
                String roomType = in.next();

                System.out.println("Choose your day: Weekends or Weekdays");
                String dayType = in.next();

                System.out.println("Do you need equipment? True | False");
                boolean equip = text.nextBoolean();

                System.out.println("How many rent for equipment?");
                int numRent = in.nextInt();
                countSnorkeling++;
                s[index] =new  Snorkeling(name,phoneNum,bookDate,num,roomType,dayType,numRent);
            }
            else if(tp == 2)
            {
                System.out.println("Choose your travel type D-Day | N-Night");
                char travelType = in.next().charAt(0);

                System.out.println("Choose your transport: Shore | Boat");
                String transport = in.next();

                System.out.println("Do you need equipment? True | False");
                boolean equip = text.nextBoolean();

                System.out.println("How many rent for equipment?");
                int rent = in.nextInt();
                countDiving++;
                s[index] =new Diving(name,phoneNum,bookDate,num,travelType,transport,equip,rent);

            }

            System.out.println("Do you want to continue? [1]Yes | [2]No");
            int ans = in.nextInt();
            index++; 

            if(ans == 1)
                option = true;
            else if(ans == 2)
                option = false;

        }
        for(int i = 0; i <index; i++)
        {   
            if(s[i] instanceof Snorkeling)
                System.out.println(s[i].printBill()); 
            else if(s[i] instanceof Diving)
                System.out.println(s[i].printBill()); 
        }
        
        int divers = 0;
        for(int i = 0; i < index; i++)
        {
            if(s[i] instanceof Diving)
            {
                divers = divers + s[i].getNum();
            }
        }
        System.out.println("\n\nTotal Divers visit DoubleZ Resort: "+divers);
        System.out.println("\n");
        
        double totalRentSnorkeling = 0;
        double totalCollSnorkeling = 0;
        double totalRentDiving = 0;
        double totalCollDiving = 0;
        int totalPersonSnorkeling = 0;
        int totalPersonDiving = 0;
        
        for(int i=0 ; i < index; i++)
        {
            if(s[i] instanceof Snorkeling)
            {
                totalRentSnorkeling = totalRentSnorkeling + ((Snorkeling)s[i]).rentSnorkeling();
                totalCollSnorkeling = totalCollSnorkeling + ((Snorkeling)s[i]).totalSnorkeling();
                totalPersonSnorkeling = totalPersonSnorkeling + s[i].getNum();
            }
        }
        for(int i=0 ; i < index; i++)
        {
            if(s[i] instanceof Diving)
            {
                totalRentDiving = totalRentDiving + ((Diving)s[i]).rentDiving();
                totalCollDiving = totalCollDiving + ((Diving)s[i]).totalDiving();
                totalPersonDiving = totalPersonDiving + ((Diving)s[i]).getNum();
            }
        }
        int totalBook = countSnorkeling + countDiving;
        int totalPerson = totalPersonSnorkeling + totalPersonDiving;
        double totalRental = totalRentSnorkeling + totalRentDiving;
        double totalCollection = totalCollSnorkeling + totalCollDiving;
        
        System.out.println("\nSUMMARY DoubleZ Resort");
        System.out.println("Package\t\tNo of Booking\tTotal Person\tRental Collection(RM)\tTotal Collection(RM)");
        System.out.println("Snorkelling\t\t"+countSnorkeling+"\t\t"+totalPersonSnorkeling+"\t\t"+totalRentSnorkeling+"\t\t\t"+totalCollSnorkeling);
        System.out.println("Diving\t\t\t"+countDiving+"\t\t"+totalPersonDiving+"\t\t"+totalRentDiving+"\t\t\t"+totalCollDiving);
        System.out.println("TOTAL\t\t\t"+totalBook+"\t\t"+totalPerson+"\t\t"+totalRental+"\t\t\t"+totalCollection);
        
        
        double countJSnorkeling = 0;       
        for(int i = 0; i < index; i++)
        {
            if(s[i] instanceof Snorkeling)
            {
                if(s[i].getBookDate().substring(3,5).equals("07"))
                {
                    countJSnorkeling=countJSnorkeling+ ((Snorkeling)s[i]).billSnorkeling();
                }
            }
        }
        
        System.out.println("\n\nTotal Collection Snorkeling for July:RM "+countJSnorkeling);
        
        
        
    }
}