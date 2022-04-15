/*
Main Mobile Network Simulation for BE Project
Author - Amit R Bhandarkar
BE IT Engineering Student
Hence this is LATEST VERSION.........blah
*/

package BEProject.IT8.Simulation;

import java.io.*;
import java.lang.*;
import java.util.*;

class Num_user
{
	   
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random(); 
        int N = 100;    //indicates total no. of usrs
        int rl_online,rh_online,uid;      
        float r_online;
        int r_lo_online;
        int r_hi_online;
        int num_usrs_online;
         
        public void random_gen_usrs_online() //Generates random nos.for
                                             //the no.of users who are online
        {
            rl_online = (int)((float)90/100*N); //rl gives the upper lt. for 
                               //rand no. generation for values of r[] < 0.1
                               //i.e.90 in case of [0,90).
        	      	 
        	rh_online = N-rl_online+1; //rh is used for generating rand nos. 
        	             //in the range [rl,N] i.e [90,100]
         
            r_online = rand.nextFloat(); //Generates random numbers b/w (0,1)
                                        
            if(r_online<0.1) 
            {
               	 //to generate rand nos. for the no. of usrs who are offline 
               	 //(i.e 10% of the usrs are offline)
               	 
                r_lo_online = rand.nextInt(rl_online);// r_lo[] will contain random nos.
               	                   // generated b/w [0,90).i.e. 90 exclusive.
       
            }
               
            else 
            {
               	  //to generate rand nos. for the no. of usrs who are online 
               	 //(i.e 90% of the usrs are online)
               	  
                r_hi_online = rand.nextInt(rh_online) + rl_online;//r_hi[] will contain random nos.
                                    // generated b/w [90,100] ,both inclusive.
     
            }
   
      }
      
      
      public void assign_online()
      {
      	       	  
     	  	if(r_hi_online<rl_online)
      	  	{ 	
      	    	num_usrs_online = r_lo_online;//num_usrs[] gives the no. of usrs 
      	    	                //who are online at each instant 'i' of time.
      	   	    	
      	    }
      	    	
      	    else
      	    
      	    {
      	    	num_usrs_online = r_hi_online;
      	   
      	    }
      	   
      	    if(num_usrs_online == 0)//To ensure that no_usrs_online is never = 0
      	    {
      	   	  do
      	      {
      	      	 num_usrs_online = rand.nextInt(rl_online);
      	      	 
      	      }while(num_usrs_online == 0);
      	      
      	    }
      
      
      }
      	 
          
      
      public void disp_online(int i) //will display 'the no. of usrs who are online'
      {                             //at each time instant
 
      	  	
      }
      
      
      public void getch() throws IOException //implements the getch() function 
      {
      	String st;
      	int ch;
      	
      	do
      	{
      		st = br.readLine();
      		
      		ch = Integer.parseInt(st);
           		
        }while(ch!= 1);
   
      }

      public void display(int i, int num_usrs_rechble)// displays the no. of usrs  who are online and 
      {                                  // the no. of usrs who are reachable.
  	
      }
         
         
      
} //End of class Num_user


class User 
{
	  
	  int uid;  
	  boolean reachable;
	  Random rand = new Random(); 
	  int re_l_rechble,re_h_rechble;   
      float re_rechble;
      int re_lo_rechble;
      int re_hi_rechble;
        
	  
	  public User()
	  {
	  	uid = -1;
	  }
	  
	  
	   
      public void random_gen_uid(int k)//Randomly generates user_id for each user
      {
      	    int k1;
      	    k1 = k+2;
      	    uid = rand.nextInt(k1);
      }
      	 	
      
    
      public boolean compare_uid(int k, User u[])//Compares uid of users, so that they are unique
      {                                  //returns 'true' if they are same
         boolean same = false;

         for(int k2=k;k2>0;k2--)
         {
         	 if(u[k].uid == u[k2-1].uid)
         	     same = true;
         }
         return(same);
      }  
      
      
      
       public int random_gen_reach(int no_usrs_online, int cnt_reach)//randomly generates the no. of usrs who are reachable.
       {                             //returns 'the no. of people who are reachable'.
       	  
       	  re_l_rechble = (int)((float)75/100*no_usrs_online); //rl gives the upper lt. for 
                               //rand no. generation for values of r[] < 0.1
                               //i.e.90 in case of [0,90).
        	      	 
          re_h_rechble = no_usrs_online-re_l_rechble+1; //rh is used for generating rand nos. 
        	             //in the range [rl,N] i.e [90,100]
                	    
          re_rechble = rand.nextFloat(); //Generates random numbers b/w (0,1)
                                        
          if(re_rechble<0.25) 
          {
             reachable = false;
          }
               
          else 
          {
             reachable = true;
          }
               	   
      
       	  if(reachable == true)
       	  	 ++cnt_reach;
       	  return (cnt_reach);	 
       }  	 
       
     	  	
       public void print_uid(int k) throws IOException //prints the uid of each user
       {
       	  
       }	    	
       
       
       
       public void print_reach(int k, int cnt, Num_user n, int cnt_reach, int uid_rechble[], int uid_rechble_index) throws IOException
       {                      //prints whether the usr is reachable or not.
	
      	  	if(reachable == true)
      	  	{
      	  	    uid_rechble_index = cnt_reach;
      	  		uid_rechble[uid_rechble_index] = uid;// PS: the index for the 
      	  			//array 'uid_rechble[]' starts at 1 
      	  			//=> i.e. the 1st element is uid_rechble[1]. 
      	  	}
      	  	
       } 
      
} // End of class User

	
public class MobileNetworkSimulation
{
	
	public Num_user n = new Num_user();
    public int num = n.N;
    public User u[] = new User[num];
	public int uid_rechble_index;
	public int uid_rechble[] = new int[num]; //PS:the index for this array is 
			//initialised to 'the total no. of usrs' (i.e.num) of this system. 
	//An ideal index would have been 'the no. of usrs reachable'(i.e. cnt_reach).   
	
	public int[] runSim()throws IOException
	{
        boolean flag = false;
        for(int i=0;i<num;i++)   // creating an array of users
        
           u[i] = new User(); //PS: the index for the array u[] starts at 0.
            //=> i.e. the 1st element is u[0].


        int no_usrs_online; 
        int no_usrs_rechble;
        int cnt,cnt_reach;
        
        for(int j=0;j<2;j++)
        {
             cnt =0
             cnt_reach = 0;
             n.random_gen_usrs_online();
             n.assign_online();
             n.disp_online(j); 
              
        	 ; 
        	 
        //	 ("\n USER \t\t USER_ID \t\t REACHABLE\n");
        	 
        	 no_usrs_online = n.num_usrs_online;
        	 for(int k=0;k<no_usrs_online;k++)
        	 {   
        	     boolean same;
        	     do
        	     {
        	 	     u[k].random_gen_uid(k);
        	 	     same = u[k].compare_uid(k,u);
        	 	 }while(same != false);   //will be performed until the uids are diff
        	 	 
        	 	 cnt_reach = u[k].random_gen_reach(no_usrs_online,cnt_reach);
        	 	 ++cnt;
        	     u[k].print_uid(k); 
        	     u[k].print_reach(k,cnt,n,cnt_reach,uid_rechble,uid_rechble_index);
             }
             
             no_usrs_rechble = cnt_reach;
             n.display(j,no_usrs_rechble);
             uid_rechble_index = cnt_reach;
         }  
        uid_rechble[0] = uid_rechble_index; 
     	return uid_rechble;
     }
    
}
