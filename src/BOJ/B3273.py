import sys
input = sys.stdin.readline

n = int(input())
list_ = sorted(list(map(int, input().split())))
x = int(input())
cnt = 0
i, j = 0, n - 1

while i < j:
    temp = list_[i] + list_[j]
    if temp == x:
        cnt += 1
        i += 1
    elif temp < x:
        i += 1
    else:
        j -= 1

print(cnt)