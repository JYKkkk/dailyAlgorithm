# https://school.programmers.co.kr/learn/courses/30/lessons/43238

def solution(n, times):

    low = 1
    high = 1_000_000_000**2
    
    while low < high:
        mid = (low+high) // 2
        cap = sum([mid//t for t in times])
        
        if cap < n:
            low = mid+1
        elif cap >= n:
            high = mid
    return high
