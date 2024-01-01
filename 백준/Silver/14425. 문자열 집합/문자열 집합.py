from sys import stdin as s

n, m = map(int, s.readline().split())

target = [s.readline().strip() for i in range(n)]
inspection = [s.readline().strip() for i in range(m)]
cnt = 0

for i in inspection:
    if i in target:
        cnt += 1

print(cnt)