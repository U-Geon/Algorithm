from sys import stdin as s


def dfs(x, y):
    lst = [[x,y]]
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    while lst:
        tmp = lst.pop()
        visited[tmp[0]][tmp[1]] = True

        for i in range(4):
            nx = tmp[0] + dx[i]
            ny = tmp[1] + dy[i]

            if (0 <= nx <= n - 1) and (0 <= ny <= m - 1):
                if not visited[nx][ny] and field[nx][ny] == 1:
                    lst.append([nx, ny])

T = int(input())

for _ in range(T):
    m, n, k = map(int, s.readline().split())
    field = [[0] * m for _ in range(n)]
    visited = [[False] * m for _ in range(n)]

    for _ in range(k):
        y, x = map(int, s.readline().split())
        field[x][y] = 1
    earthworm = 0

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and field[i][j] == 1:
                dfs(i, j)
                earthworm += 1

    print(earthworm)