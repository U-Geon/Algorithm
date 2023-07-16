from sys import stdin as s


def calc(x):
    if x >= 10:
        return chr(x + 55)
    return str(x)


n, b = map(int, s.readline().split())
rst = []

while n >= b:
    rst.insert(0, calc(n % b))
    n //= b
rst.insert(0, calc(n))

print("".join(rst))

