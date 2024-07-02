import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))
M = int(input())
compare_num = list(map(int, input().split()))

check = {}

for i in range(N):
    check[num[i]] = 0

for j in range(M):
    if compare_num[j] in check:
        print(1, end = ' ')
    else:
        print(0, end = ' ')