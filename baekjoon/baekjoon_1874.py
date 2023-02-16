# 스택 수열 class 2
'''
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
이를 계산하는 프로그램을 작성하라.
'''

n = int(input())
idx = 0 # 루프의 기준으로 할 lst의 인덱스
count = 1 # 오름차순으로 스택에 넣을 숫자. (1 ~ n)
lst = [int(input()) for i in range(n)] # 입력 받은 수열
stack = [] # 사용할 스택
answer = [] # 스택에 push, pop을 하며 만들어지는 수열
addPlusMinus = [] # + - 이 추가되는 리스트

# 입력받은 수열의 idx번째 요소부터 스택에 없으면 넣고 count를 1 더함.
while True:
    if lst[idx] not in stack: # 스택 맨 앞이 lst[idx]가 아니라면 count(1부터)를 stack에 추가
        stack.insert(0, count)
        count += 1
        addPlusMinus.append("+")
    else: # 스택에 idx번째 lst의 요소가 있다면 answer 리스트에 넣고 idx + 1 인덱스의 요소 체크
        a = stack.pop(0)
        idx += 1
        answer.append(a)
        addPlusMinus.append("-")

    # 마지막 idx까지 돌았을 때 스택에 남은 수를 answer list에 추가하는 마지막 과정
    if idx == n-1:
        for i in stack:
            answer.append(i)
            addPlusMinus.append("-")
        break

# 만들어진 answer 리스트가 입력받은 lst와 같으면 + - 과정 출력
if answer == lst:
    for i in addPlusMinus:
        print(i)
else: # 아닌 경우 NO 출력
    print("NO")