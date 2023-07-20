import java.util.*;

public class LaundryApp
{
    public static void main (String [] args)
    {
        Scanner inline = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        LaundryService[] user = new LaundryService[9];
        int x =0;
        double money=0;

        for(int i=0;i<user.length;i++)
        {
            System.out.print("\nEnter Customer Name: ");
            String name = inline.next();
            System.out.print("Enter Customer ID: ");
            String id = inline.next();
            System.out.print("Enter Customer Contact Number: ");
            String num = inline.next();

            if(x==0||x==3||x==4||x==7||x==8)
            {
                System.out.println("WashNFold Service");
                System.out.print("\tEnter Clothes Weight(kg): ");
                int weight = in.nextInt();
                System.out.print("\tDo you want to separating white clothes from coloured clothes [Y]es/[N]o: ");
                char op = in.next().toUpperCase().charAt(0);
                boolean sc=false;
                if (op=='Y'||op=='y')
                {
                    sc=true;
                }

                user[i] = new WashNFold(name,id,num,weight,sc);
                money = money + ((WashNFold)user[i]).calcCharge();
            }
            else if(x==1||x==2||x==5||x==6)
            {
                System.out.println("DryClean Service");
                System.out.print("\tEnter type of clothes [1.Dress||2.Baju Kurung/Baju Melayu ||3.Suits||4.Pants/T-Shirt ||5.Others] : ");
                int opt = in.nextInt();
                System.out.print("\tNumber of clothes : ");
                int count = in.nextInt();

                user[i] = new DryClean(name,id,num,count,opt);
                money = money + ((DryClean)user[i]).calcCharge();
            }

            x++;
        }
        
        System.out.println("\nTotal Amount for Laundry service : RM" + money);

        System.out.println("\nList of the Customer that use WashNFold service");
        for(int i=0;i<user.length;i++)
        {
            if(user[i]instanceof WashNFold)
            {
                System.out.println("\n" + user[i].toString());
            }

        }

        System.out.println("\nList of the Customer that use DryClean service");
        for(int i=0;i<user.length;i++)
        {
            if(user[i]instanceof DryClean)
            {
                System.out.println("\n" + user[i].toString());
            }

        }

        System.out.println("\nList of the Customer who send Baju Kurung/Baju Melayu  ");
        for(int i=0;i<user.length;i++)
        {
            if(user[i]instanceof DryClean)
            {
                if(((DryClean)user[i]).getTypeOfClothes()==2)
                {
                    System.out.println("\n" + user[i].toString());
                }
            }

        }
    }
}
