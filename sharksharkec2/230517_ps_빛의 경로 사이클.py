# https://school.programmers.co.kr/learn/courses/30/lessons/86052

# 동 남 서 북
delta = [[0,1],[1,0],[0,-1],[-1,0]]

def solution(grid):
    X = len(grid)
    Y = len(grid[0])
    field =  [[[False, False, False, False] for ch in line] for line in grid]
    answer = []
    
    for x in range(X):
        for y in range(Y):
            for i in range(4):
                if not field[x][y][i]:
                    r = x
                    c = y
                    count = 0
                    while not field[r][c][i]:
                        field[r][c][i] = True
                        
                        r = (r+delta[i][0])%X
                        c = (c+delta[i][1])%Y
                        
                        if grid[r][c] == 'R':
                            i = (i+1)%4
                        
                        if grid[r][c] == 'L':
                            i = (i-1)%4
                        count +=1
                    answer.append(count)
    
    answer.sort()
    return answer
