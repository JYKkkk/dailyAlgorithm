N, R, G, B = map(int, input().split())

def combination(n, r):
    parent = 1
    child = 1
    for i in range(1, r+1):
        parent *= (n+1 - i)
        child *= i
    return parent//child

def case(k, r, g, b):
    answer = 1
    answer *= combination(r+g+b, g+b)
    answer *= combination(g+b, b)
    return answer


def level(k, r, g, b):
    if k == N+1:
        return 1
    count = 0

    if r>=k: 
        count += level(k+1, r-k, g, b)
    if g>=k:
        count += level(k+1, r, g-k, b)
    if b>=k:
        count += level(k+1, r, g, b-k)
    
    if k%2 == 0:
        d = k//2
        cs = case(k, d, d, 0)
        if r>=d and g>=d:
            count += cs*level(k+1, r-d, g-d, b)
        if g>=d and b>=d:
            count += cs*level(k+1, r, g-d, b-d)
        if r>=d and b>=d:
            count += cs*level(k+1, r-d, g, b-d)
    
    d = k//3
    if k%3 == 0 and r>=d and g>=d and b>=d:
        count += case(k, d, d, d)*level(k+1, r-d, g-d, b-d)

    return count

print(level(1,R,G,B))

