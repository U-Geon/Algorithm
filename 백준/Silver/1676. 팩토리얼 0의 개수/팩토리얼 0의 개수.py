from math import factorial as fac

inp = int(input())
dec = str(fac(inp))
cnt = 0
for i in range(1, len(dec)+1):
    if dec[-i] == '0':
        cnt += 1
    else:
        break

print(cnt)