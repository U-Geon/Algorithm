from sys import stdin as s
from itertools import combinations


while True:
    inp = list(map(int, s.readline().split()))[1:]
    if len(inp) == 0:
        break
    combi = list(combinations(inp, 6))
    for i in combi:
        for j in i:
            print(j, end=" ")
        print()
    print()
