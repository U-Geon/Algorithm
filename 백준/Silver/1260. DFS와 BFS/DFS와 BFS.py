from collections import deque
from sys import stdin as s

n, m, v = map(int, s.readline().strip().split())
graph = [list() for i in range(n + 1)]
visited = [False] * (n + 1)
for i in range(m):
    a, b = map(int, s.readline().strip().split())
    if b not in graph[a]:
        graph[a].append(b)
    if a not in graph[b]:
        graph[b].append(a)
for i in graph:
    i.sort()

def dfs(graph, start):
    visited = [False] * (n + 1)
    lst = deque([start])

    while lst:
        node = lst.pop()
        if not visited[node]:
            print(node, end=" ")
            visited[node] = True
            lst.extend(graph[node][::-1])


def bfs(graph, start):
    visited = [False] * (n + 1)
    lst = deque([start])
    # 초기값 설정.
    while lst:
        node = lst.popleft()
        if not visited[node]:
            print(node, end=" ")
        visited[node] = True
        for i in graph[node]:
            if not visited[i]:

                lst.append(i)

dfs(graph,v)
print()
bfs(graph,v)