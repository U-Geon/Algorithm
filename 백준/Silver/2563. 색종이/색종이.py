from sys import stdin as s


n = int(input())
lst = [[0] * 101 for i in range(101)]
cnt = 0
for i in range(n):
    a, b = map(int, s.readline().split())
    for j in range(a, a+10):
        for k in range(b, b+10):
            lst[k][j] = 1
for j in lst:
    cnt += j.count(1)
print(cnt)