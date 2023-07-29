from sys import stdin as s

n = int(input())
time = sorted(map(int, s.readline().split()))
result = 0
for i in range(n):
    result += sum(time[:i+1])

print(result)