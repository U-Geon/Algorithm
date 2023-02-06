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