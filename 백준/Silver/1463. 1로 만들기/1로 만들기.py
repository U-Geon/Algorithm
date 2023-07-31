def dp(x):
    if arr[x] != 1000000:
        return arr[x]

    if x % 6 == 0:
        arr[x] = min(dp(x//3), dp(x//2)) + 1
    elif x % 3 == 0:
        arr[x] = min(dp(x//3), dp(x-1)) + 1
    elif x % 2 == 0:
        arr[x] = min(dp(x//2), dp(x-1)) + 1
    else:
        arr[x] = dp(x-1) + 1
    return arr[x]


n = int(input())
arr = [1000000] * (n+1)
arr[0] = 0
arr[1] = 0

if n <= 3:
    for i in range(2,n+1):
        arr[i] = 1

print(dp(n))