'''
1,1    1

1,2    2
2,1    3

3,1    4
2,2    5
1,3    6

1,4    7
2,3    8
3,2    9
4,1    10

5,1    11
4,2    12
3,3    13
2,4    14
1,5    15

규칙성 파악하기!!
'''

x = int(input())

idxNum = 1
sumCnt = 1
ans = 0

if x == 1:
    print('1/1')
else:
    while True:
        if x <= idxNum:
            ans = sumCnt + 1
            break
        sumCnt += 1
        idxNum += sumCnt

    ansList = [i for i in range(idxNum-sumCnt+1, idxNum+1)]

    if sumCnt%2 == 0:
        print(f'{ansList.index(x)+1}/{ans-ansList.index(x)-1}')
    else:
        print(f'{ans-ansList.index(x)-1}/{ansList.index(x)+1}')