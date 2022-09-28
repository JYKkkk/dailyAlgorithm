def solution(n, s, a, b, fares):
    
    adj = [[1000000000000 for i in range(n)] for j in range(n)]
    
    for c, d, f in fares:
        adj[c-1][d-1] = f
        adj[d-1][c-1] = f
    
    for i in range(n):
        adj[i][i] = 0
    for k in range(n):
        for i in range(n):
            if i==k: continue
            for j in range(n):
                if i==j or j==k: continue
                if adj[i][j] > adj[i][k] + adj[k][j]:
                    adj[i][j] = adj[i][k] + adj[k][j]
    s-=1
    a-=1
    b-=1
    
    answer = adj[s][a] + adj[s][b]
    
    for i in range(n):
        route = adj[s][i] + adj[i][a] + adj[i][b]
        if route < answer:
            answer = route
    
    return answer