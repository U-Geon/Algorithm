# 소수 리스트에서 최대 최소값 범위만큼 슬라이싱 - 시간복잡도 O(logn)

from sys import stdin as s
from math import sqrt

mn, mx = map(int, s.readline().split())

sieve = [True] * (mx+1)

for i in range(2, round(sqrt(mx)) + 1):
    if sieve[i]:  # i가 소수인 경우
        for j in range(i*2, mx+1, i):  # i이후 i의 배수들을 False 판정
            sieve[j] = False

for i in range(mn,mx+1):
    if sieve[i] and i>1:
        print(i)

# 두 번째, 함수 이용

def prime_list(a, n):
    # 에라토스테네스의 체 초기화: n개 요소에 True 설정(소수로 간주)
    sieve = [True] * n

    # n의 최대 약수가 sqrt(n) 이하이므로 i=sqrt(n)까지 검사
    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if sieve[i] == True:  # i가 소수인 경우
            for j in range(i + i, n, i):  # i이후 i의 배수들을 False 판정
                sieve[j] = False

    # 소수 목록 산출
    return [i for i in range(a, n) if sieve[i] == True]


import sys

a, b = sys.stdin.readline().split()

for i in prime_list(int(a), int(b)):
    print(i)
