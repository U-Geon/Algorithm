from sys import stdin as s


n, m = map(int, s.readline().split())
note = dict()

for i in range(n):
    site, passwd = s.readline().split()
    note[site] = passwd
for i in range(m):
    inp = s.readline().strip()
    print(note[inp])