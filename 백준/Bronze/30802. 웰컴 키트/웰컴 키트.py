from sys import stdin as s

n = int(s.readline())
size = list(map(int, s.readline().split()))
t, p = map(int, s.readline().split())

tshirt = 0
for i in size:
    if i == 0: continue
    if i % t == 0:
        tshirt += i // t
    else:
        tshirt += i // t + 1
print(tshirt)
print(n // p, n % p)