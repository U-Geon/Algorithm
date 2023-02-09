def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2] # 리스트의 정 가운데 있는 값을 pivot 값으로 선택
    lesser_arr, equal_arr, greater_arr = [], [], [] # pivot 값보다 작은 값, 동일한 값 그리고 큰 값을 담아둘 3개의 리스트를 생성
    for num in arr: # 각 값을 pivot과 비교 후에 해당하는 리스트에 추가
        if num < pivot:
            lesser_arr.append(num)
        elif num > pivot:
            greater_arr.append(num)
        else:
            equal_arr.append(num)
    # 그 다음 작은 값과 큰 값을 담고 있는 배열을 대상으로 퀵 정렬 함수를 재귀 호출 후 재귀 호출의 결과를 다시 크기 순으로 합친다.
    return quick_sort(lesser_arr) + equal_arr + quick_sort(greater_arr)