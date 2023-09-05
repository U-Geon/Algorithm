from sys import stdin as s

n = int(input())
vertical = list(map(int, s.readline().split()))
vertical2 = sorted([[vertical[i], i] for i in range(n)])

index = 0

for i in range(n-1):
    vertical2[i].append(index)
    if vertical2[i][0] != vertical2[i+1][0]:
        index += 1

vertical2[-1].append(index)

result = sorted(vertical2, key=lambda x: x[1])

for i in result:
    print(i[2], end=" ")