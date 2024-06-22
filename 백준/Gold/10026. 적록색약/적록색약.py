from sys import stdin as s
from collections import deque


n = int(s.readline())

lst = []
for i in range(n):
    lst.append(list(s.readline().strip()))

count, rgBlind = 0, 0

stack = deque()
visited = [[False] * n for _ in range(n)]
vector = [[0,1], [1,0], [0,-1], [-1,0]]


def bfs(a, b):
    stack.append([a, b])

    while stack:
        x, y = stack.popleft()

        for dx, dy in vector:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if lst[nx][ny] == lst[a][b] and not visited[nx][ny]:
                    visited[nx][ny] = True
                    stack.append([nx, ny])


# 비적록색약
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            count += 1

visited = [[False] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if lst[i][j] == 'R':
            lst[i][j] = 'G'

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            rgBlind += 1

print(count, rgBlind)