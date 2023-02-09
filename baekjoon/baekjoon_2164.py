from collections import deque

n = int(input())
deq = deque([i for i in range(1, n+1)])

while len(deq) > 1:
    deq.popleft()
    a = deq.popleft()
    deq.append(a)

print(deq[0])