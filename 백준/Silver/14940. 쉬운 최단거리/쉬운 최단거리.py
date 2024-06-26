from collections import deque
from sys import stdin as s

n, m = map(int, s.readline().split())
array = [list(map(int, s.readline().split())) for i in range(n)]
direction = [(-1, 0), (0, -1), (1, 0), (0, 1)]


def bfs(y, x):
    visited = [[False] * m for _ in range(n)]
    queue = deque()
    queue.append((y, x))
    visited[y][x] = True
    array[y][x] = 0

    while queue:
        y, x = queue.popleft()

        for dx, dy in direction:
            ny, nx = y + dy, x + dx

            if 0 <= nx < m and 0 <= ny < n:
                if not visited[ny][nx] and array[ny][nx] == 1:
                    visited[ny][nx] = True
                    array[ny][nx] = array[y][x] + 1
                    queue.append((ny, nx))

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and array[i][j] == 1:
                array[i][j] = -1

    for i in array:
        print(*i)


for i in range(n):
    for j in range(m):
        if array[i][j] == 2:
            x, y = i, j
            break

bfs(x, y)