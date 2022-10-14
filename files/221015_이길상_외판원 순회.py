import sys
N = int(sys.stdin.readline())
W = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

MAX_BIT= (1<<N) - 1
MAX = 1_000_000_000
dp = [[-1 for _ in range(1<<N)] for n in range(N)]

def travel(city, check):

    if check == MAX_BIT:
        if W[city][0]>0:
            return W[city][0]
        else:
            return MAX

    if dp[city][check] == -1:
        dp[city][check] = MAX
        for next in range(1, N):
            if W[city][next]==0: continue
            if check & (1<<next): continue
            dp[city][check] = min(dp[city][check], W[city][next] + travel(next, check+(1<<next)))
    
    return dp[city][check]

print(travel(0, 1))