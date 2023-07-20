public class newCar extends Buyer
{
    double importDuty=0.0;
    boolean warehouse;
    double price=0.0;
    String model="";
    String modelName="";
    public newCar(){}
    public newCar(String i,String b, String c, double id, boolean w, double np,String m,String mn)
    {
        super(i,b,c);
        importDuty=id;
        warehouse=w;
        price=np;
        model=m;
        modelName=mn;
    }
    
    public void setImportDuty(double id) {importDuty=id;}
    public void setWarehouse(boolean w) {warehouse=w;}
    public void setPrice(double p) {price=p;}
    public void setModel(String m){model=m;}
    public void setModelName(String mn){modelName=mn;}
    
    public double getImportDuty() {return importDuty;}
    public boolean getWarehouse() {return warehouse;}
    public double getPrice() {return price;}
    public String getModel(){return model;}
    public String getModelName(){return modelName;}
    
    public double carPrice()
    {
        double newPrice=0.0;
        newPrice=getPrice() + 2000 +( getPrice() * getImportDuty() );
        return newPrice;
    }

    public double sumRevenue()
    {
        double sumRevenue=0.0;
        sumRevenue=sumRevenue+carPrice();
        return sumRevenue;
    }

}