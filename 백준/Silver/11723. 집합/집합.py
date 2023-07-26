from sys import stdin as s

M = int(s.readline())
# 비트마스킹 문제
S = 0b0

for _ in range(M):
    inp = s.readline().strip().split()

    if len(inp) == 1:
        if inp[0] == "all":
            S = 0b111111111111111111111
        else:
            S = 0b0
        continue

    if inp[0] == "add":
        S = S | (0b1 << int(inp[1]))
    elif inp[0] == "remove":
        S = S & ~(0b1 << int(inp[1]))
    elif inp[0] == "check":
        print(1 if S & (0b1 << int(inp[1])) else 0)
    elif inp[0] == "toggle":
        S = S ^ (0b1 << int(inp[1]))