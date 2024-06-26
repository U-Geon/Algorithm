from sys import stdin as s

n = int(s.readline())

set = set()

set.add('ChongChong')

for i in range(n):
    x, y = s.readline().split()
    if x in set:
        set.add(y)
    elif y in set:
        set.add(x)

print(len(set))