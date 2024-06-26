from sys import stdin as s

n, m = map(int, s.readline().split())
frequency = dict()

for i in range(n):
    prompt = s.readline().rstrip()
    if len(prompt) >= m:
        if prompt not in frequency.keys():
            frequency[prompt] = [len(prompt), 1]
        else:
            frequency[prompt][1] += 1

l = list(sorted(frequency.items(), key=lambda x: (-x[1][1], -x[1][0], x[0])))

for x, y in l:
    print(x)