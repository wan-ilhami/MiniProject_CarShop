import java.util.*;
import java.io.*;
import java.text.*;

public class BuyerAPPS
{
    public static int index=0;
    static DecimalFormat d=new DecimalFormat("0.00");
    public static void main(String[] args) throws Exception
    {
        try{
            FileReader fr = new FileReader ("carList.txt");
            BufferedReader br = new BufferedReader (fr);

            FileWriter fw = new FileWriter ("recordnew.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter (bw);

            FileWriter fw1 = new FileWriter ("recordused.txt");
            BufferedWriter bw1=new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter (bw1);

            Buyer[] b= new Buyer[100];
            char opt='y';
            boolean warehouse=false;
            double priceN=0.0,priceU=0.0;
            String ic="",name="",plate="",wh="",model="",modelName="";
            int car=0,yearMade=0;
            double importDuty=0.0,depreciationRate=0.0;

            String input=br.readLine();
            while(input != null)
            {
                StringTokenizer st=new StringTokenizer(input,";");

                ic=st.nextToken();
                name=st.nextToken();
                plate=st.nextToken();
                car=Integer.parseInt(st.nextToken() );

                if( car==1)
                {
                    importDuty=Double.parseDouble(st.nextToken());
                    wh=st.nextToken();
                    if(wh.equalsIgnoreCase("yes") )
                    {
                        warehouse=true;
                    }
                    else
                    {
                        warehouse=false;
                    }
                    priceN=Double.parseDouble(st.nextToken());
                    model=st.nextToken();
                    modelName=st.nextToken();
                    b[index]=new newCar(ic,name,plate,importDuty,warehouse,priceN,model,modelName);
                }
                else if( car==2)
                {
                    yearMade=Integer.parseInt(st.nextToken());
                    depreciationRate=Double.parseDouble(st.nextToken());
                    priceU=Double.parseDouble(st.nextToken());
                    String localImported=st.nextToken();
                    model=st.nextToken();
                    modelName=st.nextToken();
                    b[index] = new usedCar(ic,name,plate,yearMade,depreciationRate,priceU,localImported,model,modelName);
                }

                index++;
                input=br.readLine();
            } 

            menu(b);

            //to find revenue
            double revenue=0.0;
            double revenueNew=0.0;
            double revenueUsed=0.0;
            double totalRevenue=0.0;
            for (int y=0; y<index; y++)
            {
                if(b[y] instanceof newCar)
                {
                    newCar n =(newCar)b[y];

                    revenueNew += n.sumRevenue();

                }
                else if(b[y] instanceof usedCar)
                {
                    usedCar u =(usedCar)b[y];
                    revenueUsed=u.sumRevenue() + revenueUsed;

                }
            }
            totalRevenue=revenueNew+revenueUsed;

            //output
            for(int x=0;x<index;x++)
            {

                if( b[x] instanceof usedCar)
                { 
                    pw1.print("\n"+b[x].toString() );
                    pw1.print("\nYear Made: "+(((usedCar)b[x]).getYearMade() ) +
                        "\nDepreciation Rate: "+ (((usedCar)b[x]).getDepreciationRate() ) +
                        "\nPrice: RM "+ (((usedCar)b[x]).getPrice() ) +
                        "\nNew Price: RM "+(((usedCar)b[x]).carPrice())+
                        "\nImport || Local: "+(((usedCar)b[x]).getLocalImported()) +"\n\n");
                }
                else if( b[x] instanceof newCar )
                {

                    pw.print("\n"+b[x].toString() );
                    pw.print("\nImport Duty: "+(((newCar)b[x]).getImportDuty() ) +
                        "\nWarehouse: "+ (((newCar)b[x]).getWarehouse() ) +
                        "\nPrice: RM "+ (((newCar)b[x]).getPrice() ) +
                        "\nNew Price: RM "+(((newCar)b[x]).carPrice())+"\n\n");
                }
            }                 


            System.out.print("\nRevenue for New Car:\t\tRM"+d.format(revenueNew));
            System.out.print("\nRevenue for Used Car:\t\tRM"+d.format(revenueUsed));
            System.out.print("\n---------------------------------------------");
            System.out.print("\nRevenue for All Car: \t\tRM"+d.format(totalRevenue));

            br.close();
            pw.close();
            pw1.close();

        }catch (Exception e1) {System.err.println(e1.getMessage());}

    }

    public static void importlocal(Buyer[] b)
    {
        Scanner i=new Scanner(System.in);
        System.out.print("\f");
        int importCar=0,localCar=0;
        for(int x=0;x<index;x++)
        {
            if( b[x] instanceof newCar)
            {
                importCar++;
            }
            else if ( b[x] instanceof usedCar)
            {
                if ( (((usedCar)b[x]).getLocalImported()).equalsIgnoreCase("imported") )
                {
                    importCar++;
                }
                else if ( (((usedCar)b[x]).getLocalImported()).equalsIgnoreCase("local") )
                {
                    localCar++;
                }
            }
        }
        System.out.print("\n\nTotal Imported Car: "+importCar+ "\nTotal Local Car: "+localCar);
        System.out.print("\n\nPress Enter to Continue");
        String n=i.nextLine();
    }

    public static void search(Buyer[] b)
    {
        System.out.println("\f");
        Scanner a= new Scanner(System.in);
        boolean ans=true;
        //to find data about buyer's car
        while(ans==true)
        {
            Scanner in=new Scanner(System.in);
            System.out.print("Please enter plate Number: ");
            String search=in.nextLine();
            boolean found=false;
            for(int x=0;x<index;x++)
            {   

                if( search.equalsIgnoreCase(b[x].getCarRegNum() ) )
                {
                    found=true;
                    System.out.print("Your car have been Found");
                    System.out.print("\n"+b[x].toString());

                    if( b[x] instanceof newCar)
                    {
                        System.out.print("\nPrice: RM"+(((newCar)b[x]).getPrice()) );
                        System.out.print("\nNew Price: RM"+(((newCar)b[x]).carPrice()));

                        break;
                    }
                    else if( b[x] instanceof usedCar )
                    {
                        System.out.print("\nPrice: RM"+(((usedCar)b[x]).getPrice()) );
                        System.out.print("\nNew Price: RM"+(((usedCar)b[x]).carPrice()));

                        break;
                    }

                }

            }
            if( found!=true)
            {
                System.out.print("Cars not found");
            }
            System.out.print("\nDo you want to continue 1-Yes : ");
            int an= a.nextInt();
            if(an==1)
            {
                ans=true;
            }
            else 
            {
                ans=false;
            }

        }
    }

    public static void menu(Buyer[] b) throws Exception
    {
        try
        {
            Scanner in=new Scanner(System.in);

            boolean option = true ;
            while(option)
            {
                System.out.println("\f\n-----------------------------------------------------");
                System.out.println("\t\t      MAIN MENU"); // "\f" stands for form feed which reset the page 
                System.out.println("-----------------------------------------------------");
                System.out.println("\t[P]-Display type of Cars ");
                System.out.println("\t[S]-Search Cars " );
                System.out.println("\t[D]-Display Number of cars imports and locals ");
                System.out.println("\t[A]-Add Cars ");
                System.out.println("\t[Q]-Quit ");
                System.out.println("-----------------------------------------------------");
                System.out.print("\n\nEnter Your Choice: ");
                String choice = in.next().substring(0,1);

                if(choice.equalsIgnoreCase("Q")) break ;    
                if(choice.equalsIgnoreCase("s")){search(b);}
                else if(choice.equalsIgnoreCase("D")){importlocal(b); }
                else if(choice.equalsIgnoreCase("P")){allCars(b);}
                else if(choice.equalsIgnoreCase("A")){recordAdd(b);}
                else{System.out.println("INVALID CHOICE SIR");}
            }   
            System.out.print("\f");

            for(int x=0;x<20;x++)
            {
                System.out.print("..");
                Thread.sleep(100);
            }
            System.out.println("\n\n------------- END OF PROGRAM :D -------------");
            System.out.print("\n---------- Thank You For Using :D  ----------\n\n");
            System.out.print("\n---------------------------------------------");
            System.out.print("\n|    \t\tSUMMARY\t\t\t    |");
            System.out.print("\n---------------------------------------------\n");
        }  catch(Exception e1){System.err.println(e1.getMessage());}
    }

    public static void allCars(Buyer[] b)
    {
        System.out.println("\f");
        Scanner o= new Scanner(System.in);
        System.out.println("\tCar's Model");
        System.out.println("\n--------------------------------\n");
        System.out.println("NO\tModels\tModels Car");
        System.out.println(index);
        for(int x=0;x<index;x++)
        {
            if (b[x] instanceof newCar)
            {
                System.out.print("\n"+ (x+1) +".\t"+(((newCar)b[x]).getModel()) +"\t"+(((newCar)b[x]).getModelName()) );
            }
            else if (b[x] instanceof usedCar)
            {
                System.out.print("\n"+(x+1) +".\t"+(((usedCar)b[x]).getModel()) +"\t"+(((usedCar)b[x]).getModelName()) );
            }
        }

        System.out.println("\n\nPress  [ENTER]  to continueu ... ");
        String m = o.nextLine();

    }
    //add cars
    public static void recordAdd(Buyer[] b)
    {
        try
        {
            Scanner inline1 = new Scanner(System.in);
            Scanner inline2 = new Scanner(System.in);
            Scanner inline3 = new Scanner(System.in);

            System.out.println ("\f");
            System.out.print ("Add A Car (Y/N) : ");
            String choice = inline1.next().substring(0,1);

            if (choice.equalsIgnoreCase("Y"))
            {
                double importDuty=0.0;
                boolean warehouse=false;
                double priceN=0.0,priceU=0.0;
                int yearMade;
                double depreciationRate;
                String localImported;
                String model="";
                String modelName="";
                System.out.print ("\nEnter Buyer's IC number: ");
                String ic = inline2.next();
                System.out.print ("\nEnter Buyer's Name : ");
                String name = inline2.next();
                System.out.print ("\nPlate Number : ");
                String plate = inline2.next();
                System.out.print ("\n[1]-New Car || [2]-Used Car: ");
                int car = inline1.nextInt();
                if (car==1)
                {
                    System.out.print ("\nEnter Import Duty: ");
                    importDuty= inline3.nextDouble();
                    System.out.print ("\nDo you want warehouse?:[yes] or [no] ");
                    String wh=inline2.next();
                    if(wh.equalsIgnoreCase("yes") )
                    {
                        warehouse=true;
                    }
                    else
                    {
                        warehouse=false;
                    }
                    System.out.print ("\nPrice: ");
                    priceN= inline3.nextDouble();
                    System.out.print ("\nModel: ");
                    model = inline2.next();
                    System.out.print ("\nModel Name: ");
                    modelName = inline2.next();
                    b[index]=new newCar(ic,name,plate,importDuty,warehouse,priceN,model,modelName);
                }
                else if (car==2)
                {
                    System.out.print ("\nYear Made: ");
                    yearMade=inline1.nextInt();
                    System.out.print ("\nDepreciation Rate: ");
                    depreciationRate=inline3.nextDouble();
                    System.out.print ("\nPrice: ");
                    priceU=inline3.nextDouble();
                    System.out.print ("\nLocal || Imported: ");
                    localImported=inline2.next();
                    System.out.print ("\nModel: ");
                    model = inline2.next();
                    System.out.print ("\nModel Name: ");
                    modelName = inline2.next();
                    b[index] = new usedCar(ic,name,plate,yearMade,depreciationRate,priceU,localImported,model,modelName);
                }

                System.out.print("\n");
                index++;
                write(b);
                read(b);
                System.out.println ("\nPress [ENTER] to continue...");
                String c = inline2.nextLine();

            }
        }
        catch(Exception e1){System.err.println(e1.getMessage());}
    } 

    public static void write(Buyer[] b) throws Exception
    {
        try
        {
            File output3 = new File("carList.txt");
            FileWriter outp3 = new FileWriter (output3);
            PrintWriter out3 = new PrintWriter (outp3);

            for (int a=0; a<index; a++)
            {   
                String str ="";
                str=b[a].getIcNumber() +";"+b[a].getBuyerName() +";"+b[a].getCarRegNum() +";";
                if (b[a] instanceof newCar)
                {

                    out3.println(str+"1;"+(((newCar)b[a]).getImportDuty() )+";"+(((newCar)b[a]).getWarehouse())+";"+
                        (((newCar)b[a]).getPrice())+";"+(((newCar)b[a]).getModel())+";"+(((newCar)b[a]).getModelName())+";");
                }
                else if (b[a] instanceof usedCar)
                {
                    out3.println(str+"2;"+(((usedCar)b[a]).getYearMade() )+";"+(((usedCar)b[a]).getDepreciationRate())+";"+
                        (((usedCar)b[a]).getPrice())+";"+(((usedCar)b[a]).getLocalImported())+";"+
                        (((usedCar)b[a]).getModel())+";"+(((usedCar)b[a]).getModelName())+";");
                }
            }

            out3.close();
        }
        catch(Exception e1){System.err.println(e1.getMessage());}
    }

    public static void read(Buyer[] b) throws Exception
    {
        try 
        {
            File input = new File("carList.txt");
            FileReader inp = new FileReader(input);
            BufferedReader in2 = new BufferedReader(inp);
            
            char opt='y';
            index=0;
            boolean warehouse=false;
            double priceN=0.0,priceU=0.0;
            String ic="",name="",plate="",wh="",model="",modelName="";
            int car=0,yearMade=0;
            double importDuty=0.0,depreciationRate=0.0;

            String str2 = in2.readLine();
            while(str2 != null)
            {
                StringTokenizer st=new StringTokenizer(str2,";");
                ic=st.nextToken();
                name=st.nextToken();
                plate=st.nextToken();
                car=Integer.parseInt(st.nextToken() );
                if( car==1)
                {
                    importDuty=Double.parseDouble(st.nextToken());
                    wh=st.nextToken();
                    if(wh.equalsIgnoreCase("yes") )
                    {
                        warehouse=true;
                    }
                    else
                    {
                        warehouse=false;
                    }
                    priceN=Double.parseDouble(st.nextToken());
                    model=st.nextToken();
                    modelName=st.nextToken();
                    b[index]=new newCar(ic,name,plate,importDuty,warehouse,priceN,model,modelName);
                }
                else if( car==2)
                {
                    yearMade=Integer.parseInt(st.nextToken());
                    depreciationRate=Double.parseDouble(st.nextToken());
                    priceU=Double.parseDouble(st.nextToken());
                    String localImported=st.nextToken();
                    model=st.nextToken();
                    modelName=st.nextToken();
                    b[index] = new usedCar(ic,name,plate,yearMade,depreciationRate,priceU,localImported,model,modelName);
                }
                str2 = in2.readLine();
                index++;
            }
            in2.close();
        }
        catch(Exception e1){System.err.println(e1.getMessage());}
    }
}

