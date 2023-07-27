from sys import stdin as s

n, m = map(int, s.readline().split())
notListen = set()
notSee = set()

for i in range(n):
    notListen.add(s.readline().strip())
for j in range(m):
    notSee.add(s.readline().strip())

result = sorted((notListen.intersection(notSee)))

print(len(result))
for i in result:
    print(i)