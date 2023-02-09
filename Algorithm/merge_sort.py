def merge_sort(arr):
    if len(arr) < 2:
        return arr
    mid = len(arr) // 2
    low_arr = merge_sort(arr[:mid])  # 절반으로 쪼갠 이후 왼쪽 배열
    high_arr = merge_sort(arr[mid:])  # 절반으로 쪼갠 이후 오른쪽 배열

    merged_arr = []  # 정렬 후 병합된 배열
    l = h = 0  # 정렬 카운트
    while l < len(low_arr) and h < len(high_arr):  # 왼쪽, 오른쪽 배열의 요소들을 각각 비교하는 과정
        if low_arr[l] < high_arr[h]:
            merged_arr.append(low_arr[l])
            l += 1
        else:
            merged_arr.append(high_arr[h])
            h += 1
    # 정렬 되어 merged_arr 에 추가된 데이터 이외의 데이터를 추가하는 과정
    merged_arr += low_arr[l:]
    merged_arr += high_arr[h:]
    return merged_arr


