import sys

c = int(input())

for i in range(c):
    lst = list(map(int, sys.stdin.readline().split()))
    avg = sum(lst[1:]) / (len(lst) - 1)
    count = 0
    for i in lst[1:]:
        if i > avg:
            count += 1
    print("{:.3f}%".format(count / lst[0] * 100))