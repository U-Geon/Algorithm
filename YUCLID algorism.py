# 재귀함수 -> 유클리드 알고리즘
def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


a = int(input())
b = int(input())
print(a, b, gcd(a, b))

# 유클리드 알고리즘1 (최대공약수)
a = int(input("a="))
b = int(input("b="))
while b != 0:
    x = a
    a = b
    b = x % b
print("GCD is %d" % a)

# 유클리드 알고리즘2
a = int(input("a="))
b = int(input("b="))
while b:
    a, b = b, a % b
print("GCD is %d" % a)

# 최소공배수 = x*y // gcd(x,y)
