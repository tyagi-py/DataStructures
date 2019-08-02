
import java.util.*;
import java.lang.*;
import java.io.*;

class D
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int t=s.nextInt();
		
		int a[][]=new int[n][t+1];
		
		for(int i=0;i<a.length;i++)
		{
		    for(int j=0;j<a[i].length;j++)
		    {
		        a[i][j]=s.nextInt();
		    }
		}
		//	int x=t/2;
		int win[]=new int[n];
	
		for(int i=0;i<t;i++)
		{
		    int max=0;
		    for(int j=0;j<n;j++)
		    {
		        if(i!=0)
		        {
		            a[j][i]=a[j][i-1]+a[j][i]*a[j][t];
		            if(max<a[j][i])
		            max=a[j][i];
		        }
		        else
		        {
		            a[j][i]=a[j][i]*a[j][t];
		        }
		       
		    }
		    
		    if(i!=0 && i%2!=0)
		    {
		        
		        for(int k=0;k<n;k++)
		        {
		           // System.out.print(a[k][i]+" ");
		            if(a[k][i]==max)
		            win[k]+=1;
		        }
		    }
		    
		    
		}
		int fi=0;
		int ans=0;
		for(int i=0;i<n;i++)
		{
		    if(win[i]>fi)
		    {
		         fi=win[i];
		         ans=i+1;
		    }
		   
		    
		}
		System.out.println(ans);
	}
}