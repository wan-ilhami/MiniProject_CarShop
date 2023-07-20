import java.text.DecimalFormat;
public class Phone
{
    private String brand;
    private String model;
    private double price;
    private int[] numSale;
    private static DecimalFormat deci=new DecimalFormat("#.00");
    
    public Phone(){}
    
    public Phone(String b, String m,double p, int[] n)
    {
        brand=b;
        model=m;
        price=p;
        numSale=n;
    }
    
    public String getBrand(){return brand;}
    public String getModel(){return model;}
    public double getPrice(){return price;}
    public int[] getNumSale(){return numSale;}
    
    public void setBrand(String b){brand=b;}
    public void setModel(String m){model=m;}
    public void setPrice(double p){price=p;}
    public void setNumSale(int[] n){numSale=n;}
    
    public String toString()
    {
        String space = "";
        if (this.getModel().length() < 7)
        {
           space = space + "\t\t";
        }
        else if (this.getModel().length() < 15)
        {
           space = space + "\t";
        }
       return this.getBrand() + "\t " + this.getModel() + space + "\t" + deci.format(this.getPrice());  
   };
    }