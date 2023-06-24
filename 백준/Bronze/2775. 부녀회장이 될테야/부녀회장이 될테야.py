t = int(input())
for i in range(t):
    k = int(input())
    n = int(input())

    floor = [i for i in range(n,0,-1)]

    x = 1
    while x < k:
        tmp = []
        for i in range(n):
            tmp.append(sum(floor[i:]))
        floor = tmp

        x += 1
    print(sum(floor))