from sys import stdin as s

inputStr = s.readline()
i = 0
stack = 0
ans = 0

for i in range(len(inputStr)-1):
    if inputStr[i] == '(' and inputStr[i+1] == ')':
        ans += stack
    elif inputStr[i] == '(' and inputStr[i+1] == '(':
        stack += 1
    elif inputStr[i] == ')' and inputStr[i+1] == ')':
        stack -= 1
        ans += 1

print(ans)