def hanoi(n, start, mid, end):
    if n == 1:
        print("%d : %c -> %c" % (n, start, end))
    else:
        hanoi(n - 1, start, end, mid)
        print("%d : %c -> %c" % (n, start, end))
        hanoi(n - 1, mid, start, end)


if __name__ == "__main__":
    n = int(input())
    hanoi(n, "A", 'B', 'C')

# 하노이 횟수 = 2**n-1

