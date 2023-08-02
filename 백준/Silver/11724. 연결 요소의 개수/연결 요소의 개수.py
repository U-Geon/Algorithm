from sys import stdin as s
from collections import deque


def bfs(num):
    queue = deque([num])
    visited[num] = True

    while queue:
        tmp = queue.popleft()
        for i in component[tmp]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


n,m = map(int, s.readline().split())
component = [list() for i in range(n+1)]
visited = [False] * (n + 1)
count = 0

for i in range(m):
    x,y = map(int, s.readline().split())
    component[x].append(y)
    component[y].append(x)

for i in range(1, n+1):
    if not visited[i]:
        count += 1
        bfs(i)

print(count)