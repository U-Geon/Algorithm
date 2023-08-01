from sys import stdin as s
from collections import deque


def bfs():
    global count
    queue = deque()
    queue.append(1)

    while len(queue) > 0:
        next = queue.popleft()
        if not visited[next]:
            visited[next] = True
            count += 1
            for i in range(len(computer[next])):
                queue.extend(computer[next])


n = int(input())
m = int(input())
computer = [list() for i in range(n + 1)]
visited = [False] * (n + 1)
count = 0

for i in range(m):
    x, y = map(int, s.readline().split())
    computer[x].append(y)
    computer[y].append(x)

bfs()
print(count - 1)