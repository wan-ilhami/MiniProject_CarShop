public class Diving extends DoubleZ {
    private char travelType;    //D for day, N for Night.
    private String transport;   //transportation to the sea.
    private boolean equip;      //either the diver wants to rent the
    private int rent=0;                            //equipment or not.
    //constructor
    public Diving(){}

    public Diving(String s, String p, String b, int n,char tt, String t, boolean e,int r)
    {
        super(s,p,b,n);
        travelType=tt;
        transport=t;
        equip=e;
        rent=r;
    }
    //appropriate accessors and mutators
    public void setTravelType(char tt){travelType=tt;}

    public void setTransport(String t){transport=t;}

    public void setEquip(boolean e){equip=e;}

    public void setRent( int r){rent=r;}

    public char getTravelType(){return travelType;}

    public String getTransport(){return transport;}

    public boolean getEquip(){return equip;}

    public int getRent(){return rent;}
    //printer
    public void printer(){
        System.out.println("\nCustomer Name:\t\t "+super.custName+
                            "\nBook Date:\t\t "+super.bookDate+
                             "\nNo of people:\t\t "+super.num+
                             "\nPackage:\t\tDiving "+
                             "\nTravel Type:\t\t "+travelType+
                             "\nTransport:\t\t "+transport+
                              "\nEquipment:\t\t "+equip+
                              "\nNo set rent:\t\t "+rent);
    }
    //other methods
    public double calcCharge()
    {
        int shore=0,boat=0,chargeDiving=0;
        if( travelType=='d' || travelType=='D')
        {
            if( transport.equalsIgnoreCase("boat") )
            {
                chargeDiving=90;
            }
            else if( transport.equalsIgnoreCase("shore") ) 
            {
                chargeDiving=50;
            }
        }
        else if( travelType=='n' || travelType=='N')
        {
            if( transport.equalsIgnoreCase("boat") )
            {
                chargeDiving=150;
            }
            else if( transport.equalsIgnoreCase("shore") ) 
            {
                chargeDiving=80;
            }
        }
        return chargeDiving;
    }

    public double totalDiving()
    {
        double totalDiving=0.0;
        totalDiving= super.num * calcCharge() ;
        return totalDiving;
    }

    public double discountDiving()
    {
        double discount=0.0;
        if (super.num>8)
        {
            discount=calcCharge()*0.1;
        }
        return discount;
    }

    public double rentDiving()
    {
        double rentDiving=0.0;
        rentDiving=200*rent;
        return rentDiving;
    }

    public double billDiving()
    {
        double billDiving=0.0;
        billDiving= totalDiving()-discountDiving()+rentDiving();
        return billDiving;
    }

    public String printBill()
    {
        printer();
        return("\n-----------------------"+
            "\nReceipt----"+
            "\nPackage Charge:\t\t "+totalDiving()+
            "\nDiscount:\t\tRM "+discountDiving()+
            "\nNo set rent:\t\t "+rentDiving()+
            "\n-----------------------"+
            "\nAmount Due:\t\t "+billDiving());
    }

}//end of class Diving
