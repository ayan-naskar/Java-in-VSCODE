package all_programs;
import java.util.*;
public class snklinkedlist {
    public static void main(String[] a){
        linkedlist ob=new linkedlist();
        ob.mainn();
    }
}

class Nodee
{
    int data;
    Nodee next;

    public Nodee()
    {
        data=0;
        next=null;
    }

    public Nodee(int n)
    {
        data=n;
        next=null;
    }
}



class linkedlist
{
    public void mainn()
    {
        Scanner sc = new Scanner(System.in);

        list s = new list();
        boolean flag=true;
        int ch,val,pos;
        
        while(flag)
        {
            System.out.println("**Menu**");
            System.out.println("______");
            System.out.println("1. Insert at begin");
            System.out.println("2. Insert at middle");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete position wise");
            System.out.println("5. Delete value wise");
            System.out.println("6. Display");
            System.out.println("7. Count number of nodes");
            System.out.println("8. Reverse linked list");
            System.out.println("9. Quit\n");

            System.out.print("Print your choice : ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1  :   System.out.print("Enter the number : ");
                            val=sc.nextInt();
                            s.InsertAtBegin(val);
                            break;
                            
                case 2  :   System.out.print("Enter the number : ");
                            val=sc.nextInt();
                            System.out.print("\nEnter the position at which the no. will be inserted : ");
                            pos=sc.nextInt();
                            s.InsertAtMiddle(val,pos);
                            break;
                            
                case 3  :   System.out.print("Enter the number : ");
                            val=sc.nextInt();
                            s.InsertAtEnd(val);
                            break;

                case 4  :   System.out.print("Enter the position to be deleted : ");
                            val=sc.nextInt();
                            s.DeletePositionWise(val);
                            break;
                            
                case 5  :   System.out.print("Enter the value to be deleted : ");
                            val=sc.nextInt();
                            s.DeleteValueWise(val);
                            break;
                            
                case 6  :   s.display();
                            break;
                            
                case 7  :   s.countnode();
                            break;
                            
                case 8  :   s.reverselist();
                            break;                            

                case 9  :   flag=false; 
                            System.out.print("End of the program");
                            break;

                default :   System.out.print("Wrong choice input");
            }
        }
        sc.close();
    }
}



class list
{
    Nodee start=null;

    public void InsertAtBegin(int n)
    {
        Nodee nptr = new Nodee(n);
        
        nptr.next=start;
        start=nptr;        
    }
    
    public void InsertAtMiddle(int n , int p)
    {
        int i;
        
        if(p==1)
        {
            Nodee nptr = new Nodee(n);
            nptr.next = start;
            start = nptr;
        }
        else
            if(start==null)
            {
                System.out.print("Wrong Input");
                return ;
            }
            else
            {                
                Nodee ptr=start;
                for(i=1;i<p-1;i++)
                {
                    ptr=ptr.next;
                    if(ptr==null)
                    {
                        System.out.print("Wrong Input");
                        return ;
                    }
                }     
                Nodee nptr=new Nodee(n);
                nptr.next=ptr.next;
                ptr.next=nptr;
            }        
    }

    public void InsertAtEnd(int n)
    {
        Nodee nptr = new Nodee(n);
        
        if(start==null)
            start=nptr;
        else
        {
            Nodee ptr=start;
            
            while(ptr.next!=null)
                ptr=ptr.next;
                
            ptr.next=nptr;
        }
    }
        
    public void DeletePositionWise(int pos)
    {
        int i;
        
        if(start==null)
            System.out.print("Wrong Input");
        else
            if(pos==1)
                start=start.next;
            else
            {
                Nodee ptr = start;
                Nodee old = start;
                
                for(i=1;i<pos;i++)
                {
                    old=ptr;
                    ptr=ptr.next;
                    
                    if(ptr==null)
                    {
                        System.out.print("Wrong Input");
                        return ;
                    }
                }
                old.next=ptr.next;
            }         
    }
    
    public void DeleteValueWise(int n)
    {
        if(start==null)
            System.out.print("Wrong Input");
        else
            if(start.data==n)
                start=start.next;
            else
            {
                Nodee ptr=start.next;
                Nodee old=start;
                
                while(ptr!=null)
                {
                    if(ptr.data == n)
                    {
                        old.next = ptr.next;
                        return ;
                    }
                    old=ptr;
                    ptr=ptr.next;
                }
                
                System.out.print("Value not found");
            }
    }                  
    
    public void display()
    {
        if(start==null)
            System.out.print("List is empty");
        else
        {
            Nodee ptr=start;
            while(ptr!=null)
            {
                System.out.print(ptr.data+"  ");
                ptr=ptr.next;
            }
        }
    }
    
    public void countnode()
    {
        int c=0;
        
        if(start==null)
            System.out.print("List is empty");
        else
        {
            Nodee ptr=start;
            while(ptr!=null)
            {
                c++;
                ptr=ptr.next;
            }
            System.out.print("The number of Nodee(s) is/are : "+c); 
        }
    }    
    
    public void reverselist()
    {
        if(start==null)
            System.out.print("List is empty and cannot be reversed");
        else
        {
            Nodee ptr=start,nptr;
            start=null;
            
            while(ptr!=null)
            {
                nptr=ptr;
                ptr=ptr.next;
                nptr.next=start;
                start=nptr;                
            }
        }
    }
}