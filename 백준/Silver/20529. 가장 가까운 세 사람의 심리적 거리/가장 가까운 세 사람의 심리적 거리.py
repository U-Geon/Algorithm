from sys import stdin as s


def differDistance(a, b, c):
    count = 0
    lst = [a, b, c]
    for j in range(len(lst)-1):
        for k in range(j+1,len(lst)):
            for i in range(4):
                if lst[j][i] != lst[k][i]:
                    count += 1
    return count


T = int(input())
for i in range(T):
    n = int(input())
    MBTI = s.readline().split()
    result = 999999999

    for j in range(len(MBTI) - 2):
        for k in range(j + 1, len(MBTI) - 1):
            for l in range(k + 1, len(MBTI)):
                tmp = differDistance(MBTI[j], MBTI[k], MBTI[l])
                result = tmp if result >= tmp else result
                if result == 0:
                    break
            if result == 0:
                break
        if result == 0:
            break

    print(result)