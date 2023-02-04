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

# 2. 에라토스테네스의 체 (하나씩 지워나가기)

from sys import stdin as s
from math import sqrt


def prime_list(mx, lst):
    # 에라토스테네스의 체 초기화: n개 요소에 True 설정(소수로 간주)
    sieve = [True] * mx

    for i in range(2, round(sqrt(mx)) + 1):
        if sieve[i]:           # i가 소수인 경우
            for j in range(i+i, mx, i): # i이후 i의 배수 들을 False 판정
                sieve[j] = False

    # 나눠야 하는 제곱수 목록 산출
    sqaureNumList = [i**2 for i in range(2, mx) if sieve[i] == True]
    for i in sqaureNumList:
        for j in lst:
            if j % i == 0:
                lst.remove(j)
    return lst


mn, mx = map(int, s.readline().split())
inputList = [i for i in range(mn, mx+1)]


if mn == 1:  # mn이 1일 경우에 1을 제외하고 함수 계산 후 다시 1이 포함된 제곱ㄴㄴ수 리스트의 개수 출력
    inputList.remove(1)
    print(len(prime_list(mx, inputList))+1)
else:
    print(len(prime_list(mx, inputList)))