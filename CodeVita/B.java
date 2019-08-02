import java.util.*;
public class B {
    public static void main(String args[]) {
       
       Scanner s=new Scanner(System.in);
       
       String a=s.nextLine();
      
       String ans="";
       ArrayList<Integer> slab=new ArrayList<>();
       for(int i=0;i<a.length();i++)
       {
           if(a.charAt(i)==' ')
           {
               int x=Integer.parseInt(ans);
               slab.add(x);
               ans="";
           }
           else
           ans+=a.charAt(i);
       }
       
       slab.add(Integer.parseInt(ans));
      // System.out.println(slab);
      
      int tex[]=new int[slab.size()];
      for(int i=0;i<tex.length;i++)
      tex[i]=s.nextInt();
      
      
      
      
      int rebate=s.nextInt();
      s.nextLine();
      String et=s.nextLine();
      
      ArrayList<Integer> etax=new ArrayList<>();
      ans="";
      for(int i=0;i<et.length();i++)
      {
           if(et.charAt(i)==' ')
           {
               int x=Integer.parseInt(ans);
               etax.add(x);
               ans="";
           }
           else
           ans+=et.charAt(i);
      }
      
     etax.add(Integer.parseInt(ans));
   
     double fullans=0;
     for(int i=0;i<etax.size();i++)
     {
       double rtax=etax.get(i);

       double output=slab.get(0);
       for(int j=0;j<slab.size()-1;j++)
       {
           double tt=((slab.get(j+1)-slab.get(j))*tex[j])/100;
          //  System.out.println(tt);
           if(rtax>tt)
           {
               output+=slab.get(j+1)-slab.get(j);
               // System.out.println(output);
               rtax-=tt;
           }
           else
           {
               output+=(100*rtax)/tex[j];
               rtax=0;
               break;
           }
           
       }
       output+=(100*rtax)/tex[tex.length-1];
      //  System.out.println(output+rebate);
       fullans+=output+rebate;
       
       
         
     }
     System.out.println(fullans);
       
    }
}