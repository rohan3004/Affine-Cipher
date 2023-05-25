import java.util.*;
class Encrypt{

    Scanner rc =new Scanner(System.in);
    int a,b;
int gcd(int a,int b)
{
    int rem=a%b;
    // Finding GCD using Euclidean Alogrithm
    while(rem!=0)
    {
        a=b;
        b=rem;
        rem=a%b;
    }
    return b;
}

int inversemod(int num,int mod)
{
    for (int i = 1; i < mod; i++)
        if (((num % mod) * (i % mod)) % mod == 1)
            return i;
    return 0;
}

int mod_arithmetic(int num,int mod)
{
    if (num>=0)
        return num%mod;
    while (num < 0)
        num += mod;
    return num % mod;
}

void affineD()
{
    Scanner r=new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s=r.nextLine().toUpperCase();
    String temp="";
    for (int i=0;i<s.length();i++)
    {
        int c=((int)s.charAt(i))-65;
        int temp1=inversemod(a, 26)*(c-b);
        int p=mod_arithmetic(temp1,26)+65;
        temp=temp+((char)p);
    }
    System.out.println("Decrypted Text: ");
    System.out.println(temp);
}

void affineE()
{
    Scanner r=new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s=r.nextLine().toUpperCase();
    String temp="";
    for (int i=0;i<s.length();i++)
    {
        int p=((int)s.charAt(i))-65;
        int temp1=(a*p)+b;
        int c=mod_arithmetic(temp1,26)+65;
        temp=temp+((char)c);
    }
    System.out.println("Encrypted Text: ");
    System.out.println(temp);
}

void print()
{
    // System.out.println("GCD = "+gcd(252,198));
    System.out.println("Enter \'A\':");
    a=rc.nextInt();
    while(gcd(a,26)!=1)
    {
        System.out.println("Enter valid \'A\':");
        a=rc.nextInt();
        if (gcd(a, 26)==1)
        {
            break;
        }
    }
    System.out.println("Enter \'B\':");
    b=rc.nextInt();
    System.out.print("\tMenu\n1. Encrypt\n2. Decrypt\n3. Exit\nEnter your Choice: ");
    int choice=rc.nextInt();
    System.out.println();
    switch(choice)
    {
        case 1: affineE();
                break;
        case 2: affineD();
                break;
        case 3: System.exit(0);
                break;
        default:System.out.println("You have enter worng choice!");
    }
}

public static void main(String[] args)
{
    Encrypt e = new Encrypt();
    e.print();
}
}