# 병합 정렬 (merge sort) 사용!

from sys import stdin as s

N = int(s.readline())

inputList = []

for i in range(N):
    x, y = map(int, s.readline().split())
    inputList.append([x, y])


def merge_sort(arr):
    if len(arr) < 2:  # 단일 개체로 쪼개지면 리턴
        return arr

    mid = len(arr) // 2
    low_arr = merge_sort(arr[:mid])  # 절반으로 쪼갠 이후 왼쪽 배열
    high_arr = merge_sort(arr[mid:])  # 절반으로 쪼갠 이후 오른쪽 배열

    merged_arr = []  # 정렬 후 병합된 배열
    l = h = 0  # 정렬 카운트
    while l < len(low_arr) and h < len(high_arr): # 왼쪽, 오른쪽 배열의 요소들을 각각 비교하는 과정
        low = low_arr[l]
        high = high_arr[h]
        if low[0] < high[0]:
            merged_arr.append(low)
            l += 1
        elif low[0] > high[0]:
            merged_arr.append(high)
            h += 1
        elif low[0] == high[0] and low[1] < high[1]:
            merged_arr.append(low)
            l += 1
        else:
            merged_arr.append(high)
            h += 1
    # 정렬되어 merged_arr에 추가된 데이터 이외의 데이터 추가하는 과정
    merged_arr += low_arr[l:]
    merged_arr += high_arr[h:]

    return merged_arr


for i in merge_sort(inputList):
    for j in i:
        print(j, end=" ")
    print()