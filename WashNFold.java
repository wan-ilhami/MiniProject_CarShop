
public class WashNFold extends LaundryService
{
    private double weight;
    private boolean specialCare;

    public WashNFold (){}

    public WashNFold(String n, String i, String c,double w, boolean s)
    {
        super(n,i,c);
        this.weight=w;
        this.specialCare=s;
    }

    public WashNFold (WashNFold a)
    {
        super(a);
        this.weight= a.getWeight();
        this.specialCare=a.getSC(); 
    }

    public double getWeight()
    {
        return this.weight;
    }

    public boolean getSC()
    {
        return this.specialCare;
    }

    public void setWeight(double w)
    {
        this.weight=w;
    }

    public void setSC(boolean s)
    {
        this.specialCare=s;
    }

    public double calcCharge()
    {
        double charge=0;
        charge = this.getWeight() * 7.5;
        if (this.getSC() == true)
        {
            charge = charge + 10;
        }
        return charge;
    }

    public String toString()
    {
        return  "\nCustomer Name\t: " + super.custName +
                "\nCustomer Id\t: " + super.custID +
                "\nContact Num\t: " + super.contactNumber;
    }
}
