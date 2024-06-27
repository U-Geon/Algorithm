from sys import stdin as s

n = int(s.readline())

for i in range(n):
    x, target = map(int, s.readline().split())
    lst = list(map(int, s.readline().split()))
    array = []
    for i in range(x):
        array.append([lst[i], i])

    maxValue = max(lst)
    count = 1

    while True:
        if array[0][0] == maxValue:
            if array[0][1] == target:
                break
            else:
                pop = array.pop(0)
                lst.remove(pop[0])
                maxValue = max(lst)
                count += 1
        else:
            pop = array.pop(0)
            array.append(pop)
    print(count)