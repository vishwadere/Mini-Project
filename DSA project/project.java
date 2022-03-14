class Booth
{
	Booth link;
	String n;
	int t;	
	Booth(String s, int no)
	{
		n=s;
		t=no;
		link=null;
	}
}

import java.util.*;
import java.io.*;
class ticket
{
	Booth arr[]=new Booth[6];
	Scanner sc1=new Scanner(System.in);
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	void counters()throws IOException
	{
		for(int i=0;i<6;i++)
		{
			System.out.println("Enter movie name:-");
			String s=br.readLine();
			System.out.println("Enter price per ticket:-");
			int pr=sc1.nextInt();
			Booth nn=new Booth(s,pr);
			nn.link=null;
			arr[i]=nn;
		}
	}
	void enqueue(int q)
	{
		Booth nn=new Booth("",0);
		nn.link=null;
		Booth ptr=arr[q];
		if(ptr.link==null)
			ptr.link=nn;
		else
		{
			while(ptr.link!=null)
    			ptr=ptr.link;
    		ptr.link=nn;
		}
	}
	void dequeue(int q)throws IOException
	{
		Booth ptr=arr[q];
		if(ptr.link==null)
			System.out.println("Queue is empty.");
		else
		{
			System.out.println("Enter your name:-");
			String s=br.readLine();
			System.out.println("Enter no. of tickets you'd like to buy:-");
			int no=sc1.nextInt();
			int k=ptr.t*no;
			System.out.println("Your total would be Rs."+k+".\nThank you.");
			ptr.link=ptr.link.link;
		}
	}
	void display()
	{
		Booth p1,p2,p3,p4,p5,p6;
		p1=arr[0];
		p1=p1.link;
		p2=arr[1];
		p2=p2.link;
		p3=arr[2];
		p3=p3.link;
		p4=arr[3];
		p4=p4.link;
		p5=arr[4];
		p5=p5.link;
		p6=arr[5];
		p6=p6.link;
		int i=1;
		System.out.print("Counter 1 playing "+arr[0].n+"  Queue ");
		while(p1!=null)
		{
			System.out.print("-->"+i+" ");
			p1=p1.link;
			i++;
		}
		i=1;
		System.out.println();
		System.out.print("Counter 2 playing "+arr[1].n+" Queue ");
		while(p2!=null)
		{
			System.out.print("-->"+i+" ");
			p2=p2.link;
			i++;
		}
		i=1;
		System.out.println();
		System.out.print("Counter 3 playing "+arr[2].n+" Queue ");
		while(p3!=null)
		{
			System.out.print("-->"+i+" ");
			p3=p3.link;
			i++;
		}
		i=1;
		System.out.println();
		System.out.print("Counter 4 playing "+arr[3].n+" Queue ");
		while(p4!=null)
		{
			System.out.print("-->"+i+" ");
			p4=p4.link;
			i++;
		}
		i=1;
		System.out.println();
		System.out.print("Counter 5 playing "+arr[4].n+" Queue ");
		while(p5!=null)
		{
			System.out.print("-->"+i+" ");
			p5=p5.link;
			i++;
		}
		i=1;
		System.out.println();  
		System.out.print("Counter 6 playing "+arr[5].n+" Queue "); 
		while(p6!=null)
		{
			System.out.print("-->"+i+" ");
			p6=p6.link;
			i++;
		}
		System.out.println();
	}
}

import java.util.*;
import java.io.*;
class Main
{
	public static void main(String args[])throws IOException
	{
		ticket ob=new ticket();
		ob.counters();
		Scanner sc=new Scanner(System.in);
		int h=1;
		do
		{
			System.out.println("MENU \n1. To join a queue. \n2. To place order. \n3. To display all ticket counter queues.");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the no. of the counter you wish to join.");
				int c=sc.nextInt();
				switch(c)
				{
				case 1:
					ob.enqueue(0);
					break;
				case 2:
					ob.enqueue(1);
					break;
				case 3:
					ob.enqueue(2);
					break;
				case 4:
					ob.enqueue(3);
					break;
				case 5:
					ob.enqueue(4);
					break;
				case 6:
					ob.enqueue(5);
					break;
				default:
					System.out.println("Invalid choice.");
				}
				break;
			case 2:
				System.out.println("Enter the no. of the counter you are in.");
				int x=sc.nextInt();
				ob.dequeue(x-1);
				break;
			case 3:
				ob.display();
				break;
			default:
				System.out.println("Invalid choice.");
			}
			System.out.println("Enter 1 to continue.");
			h=sc.nextInt();
		}while(h==1);
	}
}