def counting_sort_no1(arr):
    count = [0] * (max(arr) + 1)  # 0~배열의 최댓값까지 범위의 0 리스트

    for num in arr: # count 배열의 인덱스를 값으로 갖는 arr의 요소의 갯수를 대입
        count[num] += 1

    result = []
    for i in range(max(arr)+1): # 오름차순으로 각 개수대로 출력
        for j in range(count[i]):
            result.append(i)


def counting_sort_no2(arr):
    count = [0] * (max(arr) + 1)

    for num in arr:
        count[num] += 1

    for i in range(1, len(count)):
        count[i] += count[i - 1]

    result = [0] * (len(arr))

    for num in arr:
        idx = count[num]
        result[idx - 1] = num
        count[num] -= 1

    return result
