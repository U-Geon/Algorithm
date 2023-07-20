from sys import stdin as s

a,b = map(int, s.readline().split())
lst = [1]
for i in range(2, a+1):
    if a % i == 0:
        lst.append(i)
        if len(lst) == b:
            break

if len(lst) < b:
    print(0)
else:
    print(lst[b-1])