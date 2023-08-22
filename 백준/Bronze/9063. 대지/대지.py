from sys import stdin as s


xList = []
yList = []

n = int(s.readline())
if n == 1:
    print(0)
else:
    for i in range(n):
        x, y = map(int, s.readline().split())
        xList.append(x)
        yList.append(y)

    width = max(xList)-min(xList)
    length = max(yList) - min(yList)

    print(width * length)