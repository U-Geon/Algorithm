# x in list는 list를 한 번씩 쭉 순회하는 과정이므로 시간이 걸릴 수 밖에 없다.

from sys import stdin as s

n = int(s.readline())

stack = []
num = 1
answer = ""

for _ in range(n):
    a = int(s.readline())

    if a >= num:
        for i in range(num, a + 1):
            stack.append(i)
            answer += "+\n"
        num = a + 1
        stack.pop()
        answer += "-\n"
    else:
        n = stack.pop()
        answer += "-\n"
        if n != a:
            print("NO")
            break
else:
    print(answer)
