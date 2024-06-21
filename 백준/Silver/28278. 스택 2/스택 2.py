from sys import stdin as s

n = int(s.readline())

lst = []

for i in range(n):
    order = s.readline().split()
    if order[0] == '1':
        lst.append(int(order[1]))
    elif order[0] == '2':
        if len(lst) > 0:
            print(lst.pop())
            continue
        print(-1)
    elif order[0] == '3':
        print(len(lst))
    elif order[0] == '4':
        if len(lst) > 0:
            print(0)
            continue
        print(1)
    elif order[0] == '5':
        if len(lst) > 0:
            print(lst[-1])
            continue
        print(-1)