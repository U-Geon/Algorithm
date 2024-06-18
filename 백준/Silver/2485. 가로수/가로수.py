from sys import stdin as s
from math import gcd

n = int(s.readline())
array = []
for i in range(n):
    array.append(int(s.readline()))
array.sort()

maxTree = array[-1]
minTree = array[0]

# 나무 사이 간격
tmp = []
for i in range(len(array) - 1):
    tmp.append(array[i + 1] - array[i])

# 나무 사이 간격의 최대 공약수 result 구하기
result = tmp[0]
for i in tmp:
    result = gcd(result, i)

# 최대공약수 간격의 전체 나무 개수
count = 0
for i in tmp:
    count += i // result - 1

print(count)