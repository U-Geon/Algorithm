# 행렬 덧셈 No.2738
'''
from sys import stdin

n, m = map(int, stdin.readline().split())
mat1 = []
mat2 = []

for i in range(n):
    mat1.append(list(map(int, stdin.readline().split())))
for j in range(n):
    mat2.append(list(map(int, stdin.readline().split())))

for row in range(n):
    for column in range(m):
        print(mat1[row][column] + mat2[row][column], end=" ")
    print()
'''

# 과제 안내신 분..? No.5597
'''
ipt = []
rst = [i for i in range(1, 31)]
for i in range(28):
    ipt.append(int(input()))

ans = sorted(list(set(rst)-set(ipt)))

for i in ans:
    print(i)
'''

# 대소문자 바꾸기 No.2744
"print(input().swapcase())"

# 학점 계산 No.2754
'''
scoreDict = {'A+': 4.3, 'A0': 4.0, 'A-': 3.7,
             'B+': 3.3, 'B0': 3.0, 'B-': 2.7,
             'C+': 2.3, 'C0': 2.0, 'C-': 1.7,
             'D+': 1.3, 'D0': 1.0, 'D-': 0.7,
             'F': 0.0}

print(scoreDict[input()])
'''

# 그대로 출력하기 No. 11718
# EoFError란 입력 값이 빈 문자열일 경우 발생하는 에러
'''
while True:
    try:
        print(input().strip())
    except EOFError:
        break
'''

# 모음의 개수 1264

'''
import sys

gather = ['a','i','e','o','u','A','E','I','O','U']
x = True
ans = []
while x:
    cnt = 0
    a = sys.stdin.readline().strip()
    if a == '#':
        x = False
    else:
        for i in a:
            if i in gather:
                cnt += 1
        ans.append(cnt)

for i in ans:
    print(i)
'''

# 럭비 클럽 no. 2083
'''
import sys

x = True

while x:
    a, b, c = sys.stdin.readline().split()
    if a == '#':
        x = False
    elif int(b) > 17 or int(c) >= 80:
        print(a + " Senior")
    else:
        print(a + " Junior")
'''

