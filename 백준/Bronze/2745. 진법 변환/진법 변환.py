from sys import stdin as s

n, b = map(str, s.readline().split())
b = int(b)
rst = 0

for i in range(len(n)):
    if n[i].isalpha():
        rst += (ord(n[i]) - 55) * (b ** (len(n) - i - 1))
    else:
        rst += int(n[i]) * (b ** (len(n) - i - 1))

print(rst)
