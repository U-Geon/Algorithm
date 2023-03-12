from sys import stdin as s

N, M = map(int, s.readline().split())
trees = sorted(list(map(int, s.readline().split())))

left = 0
right = max(trees) - 1

while True:
    answer = 0
    mid = (left + right) // 2
    for i in trees:
        if mid <= i:
            answer += i - mid

    if left > right:
        print(right)
        break

    if answer < M:
        right = mid - 1
    elif answer > M:
        left = mid + 1
    else:
        print(mid)
        break