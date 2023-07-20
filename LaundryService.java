
public abstract class LaundryService
{
    protected String custName;
    protected String custID; 
    protected String contactNumber;

    public LaundryService(){}
    
    public LaundryService(String n, String i, String c)
    {
        this.custName=n;
        this.custID=i;
        this.contactNumber=c;
    }
    
    public LaundryService( LaundryService a)
    {
        this.custName= a.getCustName();
        this.custID= a.getCustID();
        this.contactNumber= a.getNum();
    }
    
    public String getCustName()
    {
        return this.custName;
    }
    public String getCustID()
    {
        return this.custID;
    }
    public String getNum()
    {
        return this.contactNumber;
    }
    
    public void setCustName(String n)
    {
        this.custName=n;
    }
    public void setCustID(String n)
    {
        this.custID=n;
    }
    public void setNum(String n)
    {
        this.contactNumber=n;
    }
    
    public abstract double calcCharge();
    public abstract String toString();
    
    
}
