from sys import stdin as s


def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)


n = int(s.readline())

print(factorial(n))