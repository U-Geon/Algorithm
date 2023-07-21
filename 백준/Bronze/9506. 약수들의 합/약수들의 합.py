def result(num):
    print(num, "=", end=" ")
    for num in range(len(lst) - 2):
        print(lst[num], "+", end=" ")
    print(lst[-2])


while True:
    a = int(input())
    if a == -1:
        break
    lst = [1]
    for i in range(2, a + 1):
        if a % i == 0:
            lst.append(i)
    if sum(lst[:-1]) == a:
        result(a)
    else:
        print(f'{a} is NOT perfect.')