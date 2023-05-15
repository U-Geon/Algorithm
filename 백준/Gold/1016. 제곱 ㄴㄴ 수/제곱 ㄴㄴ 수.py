from sys import stdin as s
from math import sqrt


mn, mx = map(int, s.readline().split())
inputList = [i for i in range(mn, mx+1)]
cnt = mx-mn+1
sieve = [False] * cnt

for i in range(2, round(sqrt(mx)) + 1):
    square = i ** 2
    for j in range((((mn - 1) // square) + 1) * square, mx+1, square):  #
        if not sieve[j - mn]:
            sieve[j - mn] = True # 한 번 제외된 제곱수의 배수들을 다시 계산하지 않게끔 true로 설정
            cnt -= 1

print(cnt)