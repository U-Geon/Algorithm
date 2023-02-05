'''

# 1. 시간 복잡도 O(n) - 일일이 지우기  [시간 초과]

from sys import stdin as s
from math import sqrt


mn, mx = map(int, s.readline().split())
squareNum = [i*i for i in range(2, round(sqrt(mx))+1) if i*i < mx]
cnt = 0


for i in range(mn, mx+1):
    for j in squareNum:
        if i % j == 0:
            print(i)
            cnt += 1
            break

print(cnt)
print(mx-mn+1-cnt)
'''

# 2. 에라토스테네스의 체 알고리즘 사용(하나씩 지워나가기)
# 에라토스테네스의 체 초기화: n개 요소에 False 설정(소수로 간주)
# 어짜피 제곱수 4의 배수를 지우면 16의 배수도 마찬가지로 지워지는 개념
# 빼야하는 제곱수의 최솟값을 min보다 작은 제곱수 중 가장 큰 제곱수부터 mx전까지의 제곱수의 배수를 제외한다.
# 메모리 초과를 방지할 수 있음

from sys import stdin as s
from math import sqrt


mn, mx = map(int, s.readline().split())
inputList = [i for i in range(mn, mx+1)]
cnt = mx-mn+1


sieve = [False] * cnt

for i in range(2, round(sqrt(mx)) + 1):
    square = i ** 2
    for j in range((((mn - 1) // square) + 1) * square, mx+1, square):  #
        if not sieve[j-mn]:
            sieve[j - mn] = True # 한 번 제외된 제곱수의 배수들을 다시 계산하지 않게끔 true로 설정
            cnt -= 1

print(cnt)
