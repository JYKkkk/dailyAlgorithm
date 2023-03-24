# https://school.programmers.co.kr/learn/courses/30/lessons/12987

def solution(A, B):
    A.sort()
    B.sort()    
    
    answer = 0
    N = len(A)
    a = N-1
    for b in range(N-1, -1, -1):
        while a >= 0 and B[b] <= A[a]:
            a-=1
            
        if a>= 0:
            a-=1
            answer+=1
    
    return answer
