from sys import stdin as s

n = int(s.readline())
students = list(map(int, s.readline().split()))


def solution():
    stack = []

    cnt = 1
    i = 0

    while cnt <= n:
        if len(stack) != 0 and stack[-1] == cnt:
            stack.pop()
            cnt += 1
        elif i >= n:
            return "Sad"
        elif cnt != students[i]:
            stack.append(students[i])
            i += 1
        else:
            cnt += 1
            i += 1

    return "Nice"

print(solution())