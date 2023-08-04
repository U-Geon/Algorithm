from sys import stdin as s
from queue import PriorityQueue

n = int(s.readline().strip())
queue = PriorityQueue()
for i in range(n):
    x = int(s.readline().strip())
    if x == 0:
        if queue.empty():
            print(0)
        else:
            print(queue.get(x))
    else:
        queue.put(x)