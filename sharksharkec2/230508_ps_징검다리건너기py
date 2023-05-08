def solution(stones, k):

    L = []
    for idx, val in enumerate(stones):
        L.append((val, idx+1)) 
    L.sort()

    PREV = [i-1 for i in range(len(stones)+2)]
    NEXT = [i+1 for i in range(len(stones)+2)]

    answer = 0
    for val, idx in L:
        if 0 < idx < len(PREV)-1:

            if NEXT[idx] - PREV[idx] > k:
                answer = val
                break

            NEXT[PREV[idx]] = NEXT[idx]
            PREV[NEXT[idx]] = PREV[idx]

    return answer
