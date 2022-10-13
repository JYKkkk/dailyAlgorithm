import sys
N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

# dp[i] = 길이가 i인 증가하는 부분수열이 어느 숫자로 끝나는가
dp = [0 for i in range(N+1)]
dp[1]

answer = 0
for n in range(N):
    if dp[answer] < A[n]:
        answer+=1
        dp[answer] = A[n]
    
    else:
        lo = 1
        hi = answer

        while lo<hi:
            mid = (lo+hi)//2
            if A[n] <= dp[mid]:
                hi = mid
            else:
                lo = mid + 1
        dp[hi] = A[n]

#print(dp)
print(answer)

