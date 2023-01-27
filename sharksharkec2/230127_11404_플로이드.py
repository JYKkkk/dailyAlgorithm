N = int(input())
M = int(input())
GRAPH = [[0 for _ in range(N)] for _ in range(N)]
for m in range(M):
    a, b, c = map(int, input().split())
    if GRAPH[a-1][b-1] == 0 or GRAPH[a-1][b-1] > c:
        GRAPH[a-1][b-1] = c
for k in range(N):
    for i in range(N):
        if i==k: continue
        for j in range(N):
            if j==i or j==k: continue
            if GRAPH[i][k]==0 or GRAPH[k][j]==0: continue
            if GRAPH[i][j]==0 or GRAPH[i][j] > GRAPH[i][k] + GRAPH[k][j]:
                GRAPH[i][j] = GRAPH[i][k] + GRAPH[k][j]

for line in GRAPH:
    print(" ".join(map(str,line)))
