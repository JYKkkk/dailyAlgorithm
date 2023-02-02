def solution(n, wires):
    adj = [[False for _ in range(n)] for _ in range(n)]
    
    for v1, v2 in wires:
        adj[v1-1][v2-1] = True
        adj[v2-1][v1-1] = True
    
    answer = n
    
    def count(node, root):
        nonlocal answer
        result = 1
        
        for other in range(n):
            if other != root and adj[node][other]:
                result += count(other, node)
        
        gap = abs(n-result-result)
        answer = min(answer, gap)
        
        return result
    count(0, -1)
    
    return answer
