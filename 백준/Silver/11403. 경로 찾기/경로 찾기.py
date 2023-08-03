from sys import stdin as s


def dfs(start):
    result = [0] * n
    visited = [False] * n
    tmpList = [start]
    result[start] = '*'

    while tmpList:
        next = tmpList.pop()
        if result[next] == 0:
            result[next] = 1
        for i in graph[next]:
            if not visited[i]:
                visited[i] = True
                tmpList.append(i)
    if visited[start]:
        result[start] = 1
    else:
        result[start] = 0
    return result


n = int(input())
graph = [list() for i in range(n)]
for i in range(n):
    tmp = s.readline().split()
    for j in range(n):
        if tmp[j] == '1':
            graph[i].append(j)

for i in range(n):
    for j in range(n):
        print(dfs(i)[j], end=" ")
    print()