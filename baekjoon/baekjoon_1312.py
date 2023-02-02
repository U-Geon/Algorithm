'''
# 1 번째 - 나머지만 분류해서 index값 사용 [indexError]
from sys import stdin

a, b, n = map(int, stdin.readline().split())
diffList = list(set(str(a/b).split(".")))
extraList = []

print(diffList[1][n-1])


# 2 번째 - round 함수 이용[indexError]

from sys import stdin

a, b, n = map(int, stdin.readline().split())
rst = str(round(a/b, n+1))
print(rst)


# 3 번째 - 재귀함수 이용 [RecursionError]

from sys import stdin

a, b, n = map(int, stdin.readline().split())
cnt = 0

def divisionAB(a,b,n):
    global cnt
    remainder = (10 * a // b)
    cnt += 1

    if cnt == n:
        return remainder
    else:
        nextDivision = 10*a - remainder*b
        if nextDivision == 0 and cnt < n:
            return 0
        else:
            return divisionAB(nextDivision, b, n)


if a < b:
    print(divisionAB(a,b,n))
else:
    print(divisionAB(a - a//b*b, b, n))

'''
# 4 번째 - 수작업

from sys import stdin

a, b, n = map(int, stdin.readline().split())

for i in range(n):
    a = (a%b)*10
    result = a//b

print(result)