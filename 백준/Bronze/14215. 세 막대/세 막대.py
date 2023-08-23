from sys import stdin as s

lst = sorted(map(int, s.readline().split()))
x,y,z = lst[0], lst[1], lst[2]

if z >= x + y:
    z = x + y - 1

print(x+y+z)
