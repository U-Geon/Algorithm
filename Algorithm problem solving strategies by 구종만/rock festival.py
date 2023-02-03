from sys import stdin as s


def minAverage(n, l, payList):
    minAverageList = []
    for j in range(l, n+1):
        sumList = [sum(payList[i:i + j]) for i in range(n - j + 1)]
        minAverageList.append(min(sumList) / j)
    return min(minAverageList)


c = int(input())
for i in range(c):
    n, l = map(int, s.readline().split())
    festivalPayList = list(map(int, s.readline().split()))
    print(format(minAverage(n,l,festivalPayList), ".10f"))
