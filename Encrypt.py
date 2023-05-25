
a=0
b=0
def gcd(a,b):
    rem=a%b
    while rem!=0:
        a=b
        b=rem
        rem=a%b
    return b

def inversemod(num,mod):
    for i in range(1,mod):
        if (((num % mod) * (i % mod)) % mod == 1):
            return i
        
def mod_arithmetic(num,mod):
    if num>=0:
        return num%mod
    while num<0:
        num+=mod
    return num % mod

def affineD():
    global a,b
    s=input("Enter a string:").upper()
    temp=""
    for i in s:
        c=ord(i)-65
        temp1=inversemod(a,26)*(c-b)
        p=int(mod_arithmetic(temp1,26))+65
        temp=temp+chr(p)
    print(f"Decrypted Text: {temp}")

def affineE():
    global a,b
    s=input("Enter a string:").upper()
    temp=""
    for i in s:
        p=ord(i)-65
        temp1=(a*p)+b
        c=mod_arithmetic(temp1,26)+65
        temp=temp+chr(c)
    print(f"Encrypted Text: {temp}")

def main():
    global a,b
    a=int(input("Enter \'A\': "))
    while gcd(a,26)!=1:
        a=int(input("Enter valid \'A\'"))
        if gcd(a,26)==1:
            break
    b=int(input("Enter \'B\': "))
    choice=int(input("\tMenu\n1. Encrypt\n2. Decrypt\n3. Exit\nEnter your Choice: "))
    if choice==1:
        affineE()
    elif choice==2:
        affineD()
    
if __name__=='__main__':
    main()
