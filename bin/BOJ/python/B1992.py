import sys
from collections import deque
input = sys.stdin.readline
josephus = deque()

N, K = map(int, input().split())

for i in range(1, N + 1):
    josephus.append(i)

print("<", end = '')

while josephus:
    for i in range(K - 1):
        josephus.append(josephus.popleft())
    print(josephus.popleft(), end = '')
    if josephus:
        print(", ", end = '')

print(">")