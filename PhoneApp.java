import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
public class PhoneApp
{
    private static DecimalFormat deci = new DecimalFormat("#.00");
    public static void main (String[] args) throws Exception
    {
        try 
        {
            FileReader fr = new FileReader ("PhoneList.txt");
            BufferedReader br = new BufferedReader (fr);

            FileWriter fw = new FileWriter ("SalesReport.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter (bw);

            FileWriter fw1 = new FileWriter ("SummaryReport.txt");
            BufferedWriter bw1=new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter (bw1);
            
            Phone[] p= new Phone[50];
            String input = br.readLine();
            String name;
            String model;
            double price = 0;
            int index = 0;
            int[] ts= new int[50];
            double[] collection= new double[50];
            
            
            while(input!=null)
            {
                int[] numSale = new int[12];
                StringTokenizer st= new StringTokenizer(input,";");
                name = st.nextToken();
                model = st.nextToken();
                price = Double.parseDouble(st.nextToken());
                
                for( int i=0;i<12;i++)
                {
                    numSale[i]=Integer.parseInt(st.nextToken());
                    ts[index] = ts[index] + numSale[i];
                }
                collection[index] = ts[index] * price;
                p[index] = new Phone(name,model,price,numSale);
                index++;
                input = br.readLine();
                
                
            }

            pw.println("\nBRAND\tMODEL\t\t\tPRICE\t\tJAN\tFEB\tMAC\tAPRIL\tMAY\tJUNE\tJULY\tAUG\tSEPT\tOCT\tNOV\tDEC\tTOTAL SALES\tCOLLECTION(RM)");
            pw.println("===============================================================================================================================================================================");
            
            
            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Samsung"))
                {
                    pw.print(p[x].toString() + "\t"); 
                    for (int j=0; j<12; j++)
                    {
                        pw.print("\t" + p[x].getNumSale()[j] );
                    }
                    pw.print("\t" + ts[x] + "\t\t" + deci.format(collection[x]));
                    pw.print("\n");
                }
            }

            pw.print("\n");

            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Apple"))
                {
                    pw.print(p[x].toString() + "\t"); 
                    for (int j=0; j<12; j++)
                    {
                        pw.print("\t" + p[x].getNumSale()[j] );
                    }
                    pw.print("\t" + ts[x] + "\t\t" + deci.format(collection[x]));
                    pw.print("\n");
                }
            }

            pw.print("\n");

            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Huawei"))
                {
                    pw.print(p[x].toString() + "\t"); 
                    for (int j=0; j<12; j++)
                    {
                        pw.print("\t" + p[x].getNumSale()[j] );
                    }
                    pw.print("\t" + ts[x] + "\t\t" + deci.format(collection[x]));
                    pw.print("\n");
                }
            }

            pw.print("\n");

            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Oppo"))
                {
                    pw.print(p[x].toString() + "\t"); 
                    for (int j=0; j<12; j++)
                    {
                        pw.print("\t" + p[x].getNumSale()[j] );
                    }
                    pw.print("\t" + ts[x] + "\t\t" + deci.format(collection[x]));
                    pw.print("\n");
                }
            }

            pw.print("\n");

            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Vivo"))
                {
                    pw.print(p[x].toString() + "\t"); 
                    for (int j=0; j<12; j++)
                    {
                        pw.print("\t" + p[x].getNumSale()[j] );
                    }
                    pw.print("\t" + ts[x] + "\t\t" + deci.format(collection[x]));
                    pw.print("\n");
                }
            }

            pw.print("\n");

            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Xiomi"))
                {
                    pw.print(p[x].toString() + "\t"); 
                    for (int j=0; j<12; j++)
                    {
                        pw.print("\t" + p[x].getNumSale()[j] );
                    }
                    pw.print("\t" + ts[x] + "\t\t" + deci.format(collection[x]));
                    pw.print("\n");
                }
            }

            //For SummaryReport File
            pw1.println("\t\t\tJAN\tFEB\tMAC\tAPRIL\tMAY\tJUNE\tJULY\tAUG\tSEPT\tOCT\tNOV\tDEC\tBRAND TOTAL SALES\tCOLLECTION(RM)");
            pw1.println("**************************************************************************************************************************************************************");

            int[] samsung = new int[12];
            int[]  apple= new int[12];
            int[] huawei = new int[12];
            int[] oppo= new int[12];
            int[] vivo = new int[12];
            int[] xiomi = new int[12];
            //int[] ts = new int[6];
            int[] bts = new int[6];
            int[] c = new int[6];
            int[] mts = new int[12];
            int tmts = 0;
            double[] cs = new double[6];

            pw1.print("Samsung \t\t");
            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Samsung"))
                {

                    for (int y=0; y<12; y++)   
                    {  
                        samsung[y] = samsung[y] + p[x].getNumSale()[y];
                    }
                    cs[0] = cs[0] + collection[x];
                }
            }

            for (int x=0; x<12; x++)   
            {  
                bts[0] = bts[0] + samsung[x];
                pw1.print(samsung[x] + "\t");
            }
            pw1.print(bts[0] + "\t\t\t" + deci.format(cs[0]));

            pw1.println();

            pw1.print("Apple\t\t\t");
            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Apple"))
                {

                    for (int y=0; y<12; y++)   
                    {  
                        apple[y] = apple[y] + p[x].getNumSale()[y];
                    }
                    cs[1] = cs[1] + collection[x];
                }
            }

            for (int x=0; x<12; x++)   
            {  
                bts[1] = bts[1] + apple[x];
                pw1.print(apple[x] + "\t");
            }
            pw1.print(bts[1] + "\t\t\t" + deci.format(cs[1]));

            pw1.println();

            pw1.print("Huawei\t\t\t");
            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Huawei"))
                {

                    for (int y=0; y<12; y++)   
                    {  
                        huawei[y] = huawei[y] + p[x].getNumSale()[y];
                    }
                    cs[2] = cs[2] + collection[x];
                }
            }

            for (int x=0; x<12; x++)   
            {  
                bts[2] = bts[2] + huawei[x];
                pw1.print(huawei[x] + "\t");
            }
            pw1.print(bts[2] + "\t\t\t" + deci.format(cs[2]));

            pw1.println();

            pw1.print("Oppo\t\t\t");
            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Oppo"))
                {

                    for (int y=0; y<12; y++)   
                    {  
                        oppo[y] = oppo[y] + p[x].getNumSale()[y];
                    }
                    cs[3] = cs[3] + collection[x];
                }
            }

            for (int x=0; x<12; x++)   
            {  
                bts[3] = bts[3] + oppo[x];
                pw1.print(oppo[x] + "\t");
            }
            pw1.print(bts[3] + "\t\t\t" + deci.format(cs[3]));

            pw1.println();

            pw1.print("Vivo\t\t\t");
            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Vivo"))
                {

                    for (int y=0; y<12; y++)   
                    {  
                        vivo[y] = vivo[y] + p[x].getNumSale()[y];
                    }
                    cs[4] = cs[4] + collection[x];
                }
            }

            for (int x=0; x<12; x++)   
            {  
                bts[4] = bts[4] + vivo[x];
                pw1.print(vivo[x] + "\t");
            }
            pw1.print(bts[4] + "\t\t\t" + deci.format(cs[4]));

            pw1.println();

            pw1.print("Xiomi\t\t\t");
            for (int x=0; x<50; x++)
            {
                if (p[x].getBrand().equalsIgnoreCase("Xiomi"))
                {

                    for (int y=0; y<12; y++)   
                    {  
                        xiomi[y] = xiomi[y] + p[x].getNumSale()[y];
                    }
                    cs[5] = cs[5] + collection[x];
                }
            }

            for (int x=0; x<12; x++)   
            {  
                bts[5] = bts[5] + xiomi[x];
                pw1.print(xiomi[x] + "\t");
            }
            pw1.print(bts[5] + "\t\t\t" + deci.format(cs[5]));

            double tc = 0;
            for (int x=0; x<6;x++)   
            {  
                tc = tc + cs[x];
            }

            pw1.print("\nMONTHLY TOTAL SALES\t");
            for (int x=0; x<12; x++)   
            {  
                mts[x] = samsung[x] + apple[x] + huawei[x] + oppo[x] + vivo[x] + xiomi[x];
                tmts = tmts + mts[x];
                pw1.print(mts[x] + "\t");
            }
            pw1.print(tmts);
            pw1.print("\t\t\t" + deci.format(tc));

            String[] m = new String[12];
            m[0] = "January"; m[1] = "February"; m[2] = "March"; m[3] = "April";
            m[4] = "May"; m[5] = "June"; m[6] = "July"; m[7] = "August";
            m[8] = "September"; m[9] = "October"; m[10] = "November"; m[11] = "December";

            String[] b = new String[6];
            b[0] = "Samsung"; b[1] = "Apple"; b[2] = "Huawei";  
            b[3] = "Oppo"; b[4] = "Vivo"; b[5] = "Xiomi";  

            //Calculating HIGHEST SUMMARY
            int high = 0; 
            String bhigh = null;
            for (int x=0; x<6; x++)
            {
                if (bts[x] > high)
                {
                    high = bts[x];
                    bhigh = b[x];
                }
            }

            double hcoll = 0;
            String bhc = null;
            for (int x=0; x<6; x++)
            {
                if (cs[x] > hcoll)
                {
                    hcoll = cs[x];
                    bhc = b[x];
                }
            }

            int hmonth = 0;
            String hm = null;
            for (int x=0; x<12; x++)
            {
                if (mts[x] > hmonth)
                {
                    hmonth = mts[x];
                    hm = m[x];
                }
            }

            pw1.println("\n\nHIGHEST SUMMARY");

            pw1.println("\nBrand Total Sales : " + high + "\t" + "Brand : " + bhigh);
            pw1.println("Collection (RM) : " + deci.format(hcoll) + "\t" + "Brand : " + bhc);
            pw1.println("Monthly Total Sales : " + hmonth +"\t" + "Month : " + hm);

            //Calculating LOWEST SUMMARY
            int lowsale = 999999; 
            String blowsale = null;
            for (int i=0; i<6; i++)
            {
                if (bts[i] < lowsale)
                {
                    lowsale = bts[i];
                    blowsale = b[i];
                }
            }

            double lowcoll = 999999999;
            String blowcoll = null;
            for (int s=0; s<6; s++)
            {
                if (cs[s] < lowcoll)
                {
                    lowcoll = cs[s];
                    blowcoll = b[s];
                }
            }

            int lowmts = 99999;
            String lowmonth = null;
            for (int j=0; j<12; j++)
            {
                if (mts[j] < lowmts)
                {
                    lowmts = mts[j];
                    lowmonth = m[j];
                }
            }
            pw1.println("\nLOWEST SUMMARY");

            pw1.println("\nBrand Total Sales : " + lowsale + "\t\t" + "Brand : " + blowsale);
            pw1.println("Collection (RM) : " + deci.format(lowcoll) +"\t" + "Brand : " + blowcoll);
            pw1.println("Monthly Total Sales : " + lowmts + "\t" + "Month : " + lowmonth);

            br.close();
            pw.close();
            pw1.close();

        }
        catch (Exception e1) {System.err.println(e1.getMessage());}
        
    }
}
