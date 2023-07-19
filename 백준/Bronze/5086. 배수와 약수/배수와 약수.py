from sys import stdin as s

a, b = 1, 1
while True:
    a, b = map(int, s.readline().split())
    if a==0 and b==0:
        break
    if a >= b:
        if a % b == 0:
            print("multiple")
        else:
            print("neither")
    else:
        if b % a == 0:
            print("factor")
        else:
            print("neither")