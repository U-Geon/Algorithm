from sys import stdin

def confirm(board, x, y, input):
    count = 0
    for i in range(8):
        for j in range(8):
            if board[i][j] != input[x+i][y+j]:
                count += 1
    return count

black = [
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB'
]

white = [
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW'
]

n, m = map(int, stdin.readline().split())
inp = []
for i in range(n):
    inp.append(stdin.readline().strip())

cnt = 64
for i in range(n - 7):
    for j in range(m - 7):
        tmp1 = confirm(white, i, j, inp)
        tmp2 = confirm(black, i, j, inp)
        tmp3 = 0
        if tmp1 > tmp2:
            tmp3 = tmp2
        else:
            tmp3 = tmp1
        if cnt > tmp3:
            cnt = tmp3

print(cnt)