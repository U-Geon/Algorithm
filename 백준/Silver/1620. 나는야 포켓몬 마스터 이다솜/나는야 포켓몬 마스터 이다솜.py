from sys import stdin as s

n, m = map(int, s.readline().split())
book = {}

for i in range(1,n+1):
    inp = s.readline().strip()
    book[i] = inp
    book[inp] = i

for i in range(m):
    inp = s.readline().strip()
    if inp.isdigit():
        print(book[int(inp)])
    else:
        print(book[inp])