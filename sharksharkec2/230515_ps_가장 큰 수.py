# https://school.programmers.co.kr/learn/courses/30/lessons/42746#

def fkey(x):
    result = [ch for ch in x]
    L = len(result)
    for i in range(L, 4):
        result.append(result[i-L])
    return result


def solution(numbers):
    
    converted = [str(num) for num in numbers]
    converted.sort(key = fkey, reverse = True)
    
    if converted[0] == '0':
        return '0'
    
    return ''.join(converted)
