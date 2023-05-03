from sys import stdin as s

n = int(s.readline().strip())

for i in range(1,n+1):
    a,b = map(int, s.readline().strip().split())
    print(f'Case #{i}: {a + b}')