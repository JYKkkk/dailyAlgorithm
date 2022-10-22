import sys
N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

# dp[i] = 길이가 i인 증가하는 부분수열이 어느 [숫자, idx]로 끝나는가
dp = [[-1_000_000_001,0] for i in range(N+1)]
# prev[i] = A[i]가 마지막인 최장 부분수열의 이전 숫자 위치
prev = [-1 for i in range(N)]

answer = 0
for n in range(N):
    if dp[answer][0] < A[n]:
        answer+=1
        dp[answer][0] = A[n]
        dp[answer][1] = n
        prev[n] = dp[answer-1][1]
    
    else:
        lo = 1
        hi = answer

        while lo<hi:
            mid = (lo+hi)//2
            if A[n] <= dp[mid][0]:
                hi = mid
            else:
                lo = mid + 1
                
        dp[hi][0] = A[n]
        dp[hi][1] = n
        prev[n] = dp[hi-1][1]

# print(dp)
# print(prev)
print(answer)

idx = dp[answer][1]
result = [A[idx]]

while idx != prev[idx]:
    idx = prev[idx]
    result.append(A[idx])

for i in range(answer-1, -1, -1):
    sys.stdout.write(str(result[i]) + " ")
