public class Snorkeling extends DoubleZ {
   private String roomType;
   private String dayType;   //weekdays or weekend
   private int rent=0;
   //constructor
   public Snorkeling(){}
   public Snorkeling(String s, String p, String b, int n,String r, String d,int num)
   {
       super(s,p,b,n);
       roomType=r;
       dayType=d;
        rent=num;
    }
   //appropriate accessors and mutators
   public void setRoomType(String r){roomType=r;}
   public void setDayType(String d){dayType=d;}
   public void setRent(int n){rent=n;}
   
   public String getRoomType(){return roomType;}
   public String getDayType(){return dayType;}
   public int getRent(){return rent;}
   //printer 
   public void printer(){
        System.out.println("\nCustomer Name:\t\t "+super.custName+
                            "\nBook Date:\t\t "+super.bookDate+
                             "\nNo of people:\t\t "+super.num+
                             "\nPackage:\t\tSnorkeling "+
                             "\nRoom Type:\t\t "+roomType+
                             "\nDay Type:\t\t "+dayType+
                             "\nNo set rent:\t\t "+rent);
    }
   //other methods
   public double calcCharge()
   {
       int charge=0;
       if( dayType.equalsIgnoreCase("weekdays") )
       {
           if (roomType.equalsIgnoreCase("twin") )
           {
               charge=390;
            }
            else if (roomType.equalsIgnoreCase("triple") )
           {
               charge=320;
            }
            else if (roomType.equalsIgnoreCase("quad") )
           {
               charge=270;
            }
        }
        else if( dayType.equalsIgnoreCase("weekends") )
       {
           if (roomType.equalsIgnoreCase("twin") )
           {
               charge=400;
            }
            else if (roomType.equalsIgnoreCase("triple") )
           {
               charge=340;
            }
            else if (roomType.equalsIgnoreCase("quad") )
           {
               charge=280;
            }
        }
       return charge;
    }
   
    public double totalSnorkeling()
    {
     double totalSnorkeling=0.0;
     totalSnorkeling= calcCharge() * super.num ;
     return totalSnorkeling;
    }
    
    public double discountSnorkeling()
    {
        double discount=0.0;
        if (super.num>8)
            {
                discount=calcCharge()*0.1;
            }
        return discount;    
    }
   
    public double rentSnorkeling()
    {
        double totalRent=0.0;
        totalRent=100*rent;
        return totalRent;
    }
    
    public double billSnorkeling()
    {
        double billSnorkeling=0.0;
        billSnorkeling= totalSnorkeling()-discountSnorkeling()+rentSnorkeling();
        return billSnorkeling;
    }
    
    public String printBill()
    {
        printer();
        return(
            "\n-----------------------"+
            "\nReceipt----"+
            "\nPackage Charge:\t\t RM"+totalSnorkeling()+ 
            "\nDiscount:\t\t RM"+discountSnorkeling()+
            "\nRent equipment:\t\t "+rentSnorkeling()+
            "\n-----------------------"+
            "\nAmount Due:\t\t "+billSnorkeling());
    }
    
    
    
   
   
   
}//end of class Snorkeling
