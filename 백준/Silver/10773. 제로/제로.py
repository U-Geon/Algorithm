K=int(input())
List=[]

for i in range(K):
    a=int(input())
    if a==0:
        List.pop()
    else:
        List.append(a)
if List==[]:
    print(0)
else:
    print(sum(List))