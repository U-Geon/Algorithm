m = int(input())
if m == 1:
    m = 2
n = int(input())

sieve = [0] * (n + 1)
for i in range(2, n + 1):
    if sieve[i] == 1:
        continue
    for j in range(i * 2, n + 1, i):
        sieve[j] = 1

result = []
for i in range(m, n + 1):

    if sieve[i] == 0:
        result.append(i)

if len(result) > 0:
    print(sum(result))
    print(result[0])
else:
    print(-1)