# https://school.programmers.co.kr/learn/courses/30/lessons/154540

import sys
sys.setrecursionlimit(10000)

def explore(maps, x, y):
    if x<0 or y<0 or x>=len(maps) or y>=len(maps[0]) or maps[x][y] == 'X':
        return 0
    
    total = int(maps[x][y])
    maps[x][y] = 'X'

    total += explore(maps, x-1, y)
    total += explore(maps, x+1, y)
    total += explore(maps, x, y-1)
    total += explore(maps, x, y+1)
    
    
    return total

def solution(maps):
    maps = [[ch for ch in line] for line in maps]
    answer = []
    
    for x in range(len(maps)):
        for y in range(len(maps[x])):
            answer.append(explore(maps, x, y))
    answer = [num for num in answer if num > 0]
    answer.sort()
    if not answer:
        answer = [-1]
    return answer
