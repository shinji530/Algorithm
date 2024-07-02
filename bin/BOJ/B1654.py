import sys
input = sys.stdin.readline

K, N = map(int, input().split())

li = [0] * K

for i in range(K):
    li[i] = int(input())

value = max(li)
max_length = 0

def binary(low, high):
    if high < low: return
    global N
    global max_length
    mid = (high + low) // 2
    tmp = 0
    for i in li:
        tmp += i // mid
    if tmp >= N:
        max_length = mid
        binary(mid + 1, high)
    else:
        binary(low, mid - 1)
binary(0, value * 2)
print(max_length)