# Combination 사용!

from math import factorial as fac
import sys

T = int(input())
for i in range(T):
    n,m = map(int, sys.stdin.readline().split())

    print(fac(m) // (fac(n) * fac(m-n)))