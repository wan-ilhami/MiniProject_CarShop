public class usedCar extends Buyer
{
    int yearMade;
    double depreciationRate;
    double price;
    String localImported;
    String model="";
    String modelName="";
    
    public usedCar(){}
    public usedCar(String i,String b, String c, int y, double d, double p,String l,String m,String mn)
    {
        super(i,b,c);
        yearMade=y;
        depreciationRate=d;
        price=p;
        localImported=l;
        model=m;
        modelName=mn;
    }
    
    public void setYearMade(int y){yearMade=y;}
    public void setDepreciationRate(double d){depreciationRate=d;}
    public void setPrice(double u){price=u;}
    public void setlocalImported(String l){localImported=l;}
    public void setModel(String m){model=m;}
    public void setModelName(String mn){modelName=mn;}
    
    public int getYearMade(){return yearMade;}
    public double getDepreciationRate(){return depreciationRate;}
    public double getPrice(){return price;}
    public String getLocalImported(){return localImported;}
    public String getModel(){return model;}
    public String getModelName(){return modelName;}
    
    
    public double carPrice()
    {
        double usedPrice=0.0;
        double cleanPrice=0.0;
        cleanPrice=getPrice()* (( 2020-getYearMade() ) *getDepreciationRate() );
        usedPrice= getPrice()-cleanPrice;
        return usedPrice;
    }
    
    public double sumRevenue()
    {
        double sumRevenue=0.0;
        sumRevenue=sumRevenue+carPrice();
        return sumRevenue;
    }
   
}