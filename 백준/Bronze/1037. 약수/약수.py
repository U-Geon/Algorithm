from sys import stdin as s

n = int(s.readline())
array = list(map(int, s.readline().split()))
print(max(array) * min(array))