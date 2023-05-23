# https://school.programmers.co.kr/learn/courses/30/lessons/148652

dp = dict()

def bit(n, i):
    if n == 0:
        return 1
    
    if n in dp:
        if i in dp[n]:
            return dp[n][i]
    else:
        dp[n] = dict()
    
    idx = i//5
    offset = i%5
    prev = bit(n-1, idx)
    
    if prev == 0 or offset == 2:
        dp[n][i] = 0
        return 0
    else:
        dp[n][i] = 1
        return 1

def solution(n, l, r):
    answer = 0
    
    for i in range(l-1, r):
        answer += bit(n, i)
    
    return answer
