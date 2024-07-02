from collections import deque
import sys
input = sys.stdin.readline

N, M, V = map(int, input().split())

graph = [[0] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

visited_list = [0] * (N + 1)
visited_list_ = [0] * (N + 1)

def BFS(V):
    q = deque()
    q.append(V)
    visited_list[V] = 1
    while q:
        V = q.popleft()
        print(V, end = ' ')
        for i in range(1, N + 1):
            if visited_list[i] == 0 and graph[V][i] == 1:
                q.append(i)
                visited_list[i] = 1

def DFS(V):
    visited_list_[V] = 1
    print(V, end = ' ')
    for i in range(1, N + 1):
        if visited_list_[i] == 0 and graph[V][i] == 1:
            DFS(i)

DFS(V)
print()
BFS(V)