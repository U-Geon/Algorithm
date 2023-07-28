from sys import stdin as s

n, k = map(int, s.readline().split())
price = [s.readline().strip() for i in range(n)]
count = 0

for i in range(n-1,-1,-1):
    if k == 0:  break
    coin = int(price[i])
    if k >= coin:
        count += k // coin
        k %= coin

print(count)