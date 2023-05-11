# https://school.programmers.co.kr/learn/courses/30/lessons/12904

def solution(s):
    
    L = len(s)
    
    PLD = [[True if i>=j else False for j in range(L)] for i in range(L)]
    answer = 1
    
    for i in range(L):
        for j in range(i-1, -1, -1):
            if PLD[j+1][i-1] and j>=0 and s[j]==s[i]:
                PLD[j][i] = True
                answer = max(answer, i-j+1)

    return answer
