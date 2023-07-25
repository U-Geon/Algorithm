# 재귀함수 : 시간 복잡도 O(logN)
# 정렬된 nList 가운데 값이 찾는 값보다 크다면 리스트를 자름
import sys


def searchInput(num, start, end):
    mid = (start + end) // 2
    if nList[mid] == num:
        return nList[start: end + 1].count(num)
    elif nList[mid] > num:
        return searchInput(num, start, mid)
    else:
        return searchInput(num, mid + 1, end)


N = int(input())
nList = sorted(list(map(int, sys.stdin.readline().split())))
M = int(input())
mList = list(map(int, sys.stdin.readline().split()))
dictNum = dict()


for i in nList:
    if i not in dictNum:
        start = 0
        end = N - 1
        dictNum[i] = searchInput(i, start, end)

for i in mList:
    if i in dictNum.keys():
        print(dictNum[i], end=" ")
    else:
        print(0, end=" ")
