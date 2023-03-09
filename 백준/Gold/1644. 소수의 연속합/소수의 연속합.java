import java.io.*;
import java.util.*;
public class Main {

   public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
       
        if (n < 2) {
            System.out.println(0);
            return;
        }
        
        boolean[] check = new boolean[n+1];
        for(int i=2;i<=n;i++) {
        	for(int j=2;j<=Math.sqrt(i)+1;j++) {
        		if(i%j==0) {
        			check[i]=true;
        			break;
        		}
        	}
        }
        check[0]=check[1]=true;
        check[2]=false;
        
        int s=0,e=0,count=0;
        long sum=0;
        for(s=0;s<=n;s++) {
        	while(sum<n && e<=n) {
    			if(check[e]==false) {
    				sum+=e;
    			}
        		e++;
        	}
        	if(sum==n && check[s]==false) {
        		count++;
        	}
        	if(check[s]==false)
        		sum-=s;
        	
        }
        System.out.println(count);
        
   }
   
}