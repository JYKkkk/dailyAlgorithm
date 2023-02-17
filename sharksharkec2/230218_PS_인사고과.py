# https://school.programmers.co.kr/learn/courses/30/lessons/152995?language=python3

def solution(scores):
    
    N = len(scores)

    # value = [점수, scores의 index]
    ATTCOL = [[att, col, idx] for idx, (att, col) in enumerate(scores)]
    ATTCOL.sort(key = lambda x: (-x[0], x[1]))

    # index = scores의 index, value = 인센티브 여부
    VALID = [True for _ in range(N)]

    # 근무 태도 점수가 큰 순서대로 순회
    max_col = -1
    for att, col, idx in ATTCOL:
        
        # 이전까지의 사원(자신보다 근무 태도 점수가 큼) 중 동료 평가 점수가 자신보다 큰 사원이 있을 경우
        if col < max_col:
            VALID[idx] = False
        else:
            max_col = col
    
    # 인센티브를 못받는 경우
    if not VALID[0]:
        return -1

    
    # index = 석차, value = [인사 점수, scores의 index]
    TOTAL = [att+col for index, (att, col) in enumerate(scores) if VALID[index]]
    TOTAL.sort(key = lambda x: -x)
    
    # 완호와 같은 점수일 경우를 찾는다.
    wanho = sum(scores[0])
    for rank, score in enumerate(TOTAL):
        if score == wanho:
            return rank+1
        
    return 0
