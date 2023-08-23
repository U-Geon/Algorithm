from sys import stdin as s

a1, a0 = map(int, s.readline().split())
c = int(s.readline())
n0 = int(s.readline())

f_ = lambda x: (a1 - c)*x + a0

is_right = 0
if a1 == c and a0 <= 0:
    is_right = 1
elif a1 < c and f_(n0) <= 0:
    is_right = 1

print(is_right)