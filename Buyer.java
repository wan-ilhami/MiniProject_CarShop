public abstract class Buyer
{
    private String icNumber;
    private String buyerName;
    private String carRegNum;
    
    public Buyer(){}
    
    public Buyer (String i,String b, String c)
    {
        icNumber=i;
        buyerName=b;
        carRegNum=c;
    }
    
    public void setIcNumber(String i){icNumber=i;}
    public void setBuyerName(String b){buyerName=b;}
    public void setCarRegNum(String c){carRegNum=c;}
    
    public String getIcNumber(){return icNumber;}
    public String getBuyerName(){return buyerName;}
    public String getCarRegNum(){return carRegNum;}
    
    public String toString()
    {
        return ("Buyer's Name: "+buyerName+
                "\nBuyer's IC: "+icNumber+
                "\nBuyer's Number plate: "+carRegNum);
    }
    
    public abstract double carPrice();
    public abstract double sumRevenue();
    
}