from sys import stdin as s

net = [True] * 246913
net[0] = False
net[1] = False

for i in range(2, 246913):
    if net[i]:
        for j in range(i*2, 246913, i):
            net[j] = False

while True:
    n = int(s.readline())
    if n == 0: break

    count = 0
    for i in range(n+1, n*2 + 1):
        if net[i]:
            count += 1
    print(count)
