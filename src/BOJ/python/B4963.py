import sys
from collections import deque
input = sys.stdin.readline

# 상하좌우대각선 연결 시 한 섬으로 봄
dx = [-1, 1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, -1, 1, 1, -1, 1, -1]

def bfs(x, y):
    # 방문한 곳 표시
    graph[x][y] = 0
    queue = deque([(x, y)])

    while queue:
        x, y = queue.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < h and 0 <= ny < w:
                if graph[nx][ny] == 1:
                    graph[nx][ny] = 0
                    queue.append((nx, ny))
while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0: break

    # 지도
    graph = []
    answer = 0

    for _ in range(h):
        graph.append(list(map(int, input().split())))

    for x in range(h):
        for y in range(w):
            if graph[x][y] == 1:
                bfs(x, y)
                answer += 1
    print(answer)