import sys
input = sys.stdin.readline

height, width = map(int, input().split())
map_ = list(map(int, input().split()))

ans = 0
for i in range(1, width - 1):
    left_max = max(map_[:i])
    right_max = max(map_[i + 1:])

    compare = min(left_max, right_max)

    if map_[i] < compare:
        ans += compare - map_[i]

print(ans)