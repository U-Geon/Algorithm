from sys import stdin as s

n = s.readline().strip()

arr = sorted([int(i) for i in n],reverse=True)

print(''.join(map(str,arr)))