import sys
# dfs, bfs 알고리즘 참고하기!

def searchCabbage(list):
    cnt = 0

    for x in range(len(list)-1):
        frontXValue = list[x][0]
        backXValue = list[x+1][0]
        frontYValue = list[x][1]
        backYValue = list[x+1][1]
        if (frontXValue == backXValue and abs(backYValue-frontYValue) == 1) or (frontYValue == backYValue and abs(backXValue-frontXValue) == 1):
            cnt += 1
    return k - cnt


a = int(input())
answer = []


for i in range(a):
    m, n, k = map(int, sys.stdin.readline().split())

    field = []
    for j in range(k):
        a, b = map(int, sys.stdin.readline().split())
        field.append(tuple([a, b]))
    answer.append(searchCabbage(field))

for i in answer:
    print(i)