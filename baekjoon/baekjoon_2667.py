# 단지 번호 붙히기
# dfs 사용

from sys import stdin as s

n = int(s.readline().strip())
houses = [s.readline().strip() for i in range(n)]
danG_count = 0
oneHouse = []
visited = [[False] * n for _ in range(n)]


def dfs(y, x):
    global houseCount

    visited[y][x] = True
    houseCount += 1
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx <= n - 1) and (0 <= ny <= n - 1):
            if not visited[ny][nx] and houses[ny][nx] == '1':
                dfs(ny, nx)


for y in range(n):
    for x in range(n):
        start = houses[y][x]
        houseCount = 0
        if start == '1' and not visited[y][x]:
            dfs(y, x)
            danG_count += 1
            oneHouse.append(houseCount)


print(danG_count)
for i in sorted(oneHouse):
    print(i)
