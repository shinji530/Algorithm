import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().strip().split()))
# 1로 초기화
temp = [1] * (N)

for i in range(N):
    for j in range(i):
        if A[i] > A[j]:
            temp[i] = max(temp[j] + 1, temp[i])

print(max(temp))