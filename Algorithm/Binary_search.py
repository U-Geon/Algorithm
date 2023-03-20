def Binary_search(l,r):
    val = 36 # 찾는 값
    mid = (l + r) // 2

    if mid > val:
        Binary_search(l, mid - 1)
    elif mid < val:
        Binary_search(mid + 1, r)
    else:
        return mid