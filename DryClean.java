
public class DryClean extends LaundryService
{
    private int numOfPiece; 
    private int typeOfClothes;  
    
    public DryClean (){}
    
    public DryClean(String n, String i, String c,int p, int t)
    {
        super(n,i,c);
        this.numOfPiece=p;
        this.typeOfClothes=t;
    }
    
    public DryClean (DryClean a)
    {
        super(a);
        this.numOfPiece= a.getNumOfPiece();
        this.typeOfClothes=a.getTypeOfClothes(); 
    }
    
    public int getNumOfPiece()
    {
        return this.numOfPiece;
    }
    public int getTypeOfClothes()
    {
        return this.typeOfClothes;
    }
    
    public void setNumOfPiece(int w)
    {
        this.numOfPiece=w;
    }
    public void setTypeOfClothes(int w)
    {
        this.typeOfClothes=w;
    }
    
    public double calcCharge()
    {  
        double charge=0;
        int opt = this.getTypeOfClothes();
        int num = this.getNumOfPiece();
        if(opt==1)
           charge= 70 * num;
        else if(opt==2)
           charge= 18 * num;
        else if(opt==3)
           charge= 24 * num;
        else if(opt==4)
           charge= 9 * num;
        else if(opt==5)
           charge= 5 * num;   
           
        return charge;   
    }
    
    public String toString()
    {
        return  "\nCustomer Name\t: " + super.custName +
                "\nCustomer Id\t: " + super.custID +
                "\nContact Num\t: " + super.contactNumber;
    }
}
