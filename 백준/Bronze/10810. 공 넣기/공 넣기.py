from sys import stdin as s

n, m = map(int, s.readline().strip().split())
ans = [0]*n
for i in range(m):
    a,b,c = map(int, s.readline().strip().split())
    for j in range(a-1,b):
        ans[j] = c

for i in ans:
    print(i, end=" ")