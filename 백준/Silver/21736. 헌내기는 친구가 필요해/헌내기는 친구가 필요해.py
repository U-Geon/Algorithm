from sys import stdin as s


def dfs(x, y):
    global rst
    direct = [[0, 1], [1, 0], [-1, 0], [0, -1]]
    visited = [[False] * M for _ in range(N)]
    neighbor = [[x, y]]

    while neighbor:
        tmp = neighbor.pop()
        if campus[tmp[0]][tmp[1]] == 'P' and not visited[tmp[0]][tmp[1]]:
            rst += 1
        visited[tmp[0]][tmp[1]] = True

        for i in range(4):
            dx = tmp[0] + direct[i][0]
            dy = tmp[1] + direct[i][1]

            if (0 <= dx < N and 0 <= dy < M) and not visited[dx][dy] and campus[dx][dy] != 'X':
                neighbor.append([dx, dy])


N, M = map(int, s.readline().split())
campus = []
ix, iy, rst = 0, 0, 0
for i in range(N):
    string = s.readline().strip()
    campus.append(string)
    if 'I' in string:
        iy = string.index('I')
        ix = i

dfs(ix, iy)

if rst == 0:
    print("TT")
else:
    print(rst)

