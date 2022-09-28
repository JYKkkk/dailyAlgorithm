def solution(info, edges):
    
    child = dict()
    for i in range(len(info)):
        child[i] = []
    for p, c in edges:
        child[p].append(c)
        
    def expand(node, wolves):
        if info[node] == 0:
            answer = 1
            for c in child[node]:
                answer += expand(c, wolves)
            return answer
        else:
            wolves.append(node)
            return 0

    def dfs(sheep, wolf, wolves):
        wolf+=1
        if wolf >= sheep:
            return sheep
        # 방문 가능한 늑대 노드 순회
        maxres = sheep
        for node in wolves:
            newwolf = []
            newsheep = 0
            for c in child[node]:
                newsheep += expand(c, newwolf)
            
            temp = wolves+[]
            temp.remove(node)
            newres = dfs(sheep + newsheep, wolf, temp + newwolf)
            if newres > maxres:
                maxres = newres

        return maxres
        
    available = []
    sheep = expand(0, available)
    
    answer = dfs(sheep, 0, available)
    return answer