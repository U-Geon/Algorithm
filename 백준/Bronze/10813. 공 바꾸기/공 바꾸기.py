from sys import stdin as s

n, m = map(int, s.readline().strip().split())
ans = [i for i in range(1,n+1)]
for i in range(m):
    a,b = map(int, s.readline().strip().split())
    tmp = ans[a-1]
    ans[a-1] = ans[b-1]
    ans[b-1] = tmp

for i in ans:
    print(i, end=" ")