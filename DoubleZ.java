public abstract class DoubleZ {
   protected String custName;
   protected String phoneNum;   // 01234567891
   protected String bookDate;   // dd/mm/yyyy
   protected int num;           
   //constructors
   public DoubleZ(){}
   public DoubleZ(String s, String p, String b, int n)
   {
       custName=s;
       phoneNum=p;
       bookDate=b;
       num=n;
    }
   //appropriate accessors and mutators
   public void setCustName(String c){custName=c;}
   public void setPhoneName(String p){phoneNum=p;}
   public void setBookDate(String b){bookDate=b;}
   public void setNum(int n){num=n;}
   
   public String getCustName(){return custName;}
   public String getPhoneName(){return phoneNum;}
   public String getBookDate(){return bookDate;}
   public int getNum(){return num;}
    
   //printer
   public void printer()
   {
       System.out.println(custName+phoneNum+bookDate+num);
    }

   public abstract double calcCharge();
   
   public abstract String printBill();
   
}//end of class DoubleZ
