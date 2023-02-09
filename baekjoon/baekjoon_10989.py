# 첫 번째, arr까지 담아야하므로 메모리 초과

n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))

count = [0] * (max(arr)+1)  # 0~배열의 최댓값까지 범위의 0 리스트

for i in arr:
    count[i] += 1

for i in range(n): # 오름차순으로 각 개수대로 출력
    for j in range(count[i]):
        print(i)

# 두 번째, 문제에서 최댓값 10000을 넘지 않는다 했으니 max를 10000으로 잡기

n = int(input())
count = [0] * 10001
for i in range(n):
    count[int(input())] += 1
for i in range(10001):
    for _ in range(count[i]):
        print(i)