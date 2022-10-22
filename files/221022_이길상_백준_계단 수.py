import sys
N = int(sys.stdin.readline())

dp = [[[0 for i in range(10)] for bit in range(1<<10)] for n in range(N+1)]

# dp[n][bit][i] = 길이n, i로 끝남, bit의 숫자가 등장하는 계단 수의 개수

for i in range(1, 10):
    dp[1][1<<i][i] = 1

for n in range(2, N+1):
    for i in range(10):
        mask = 1<<i
        for bit in range(1<<10):
            if i>0:
                dp[n][bit|mask][i] += dp[n-1][bit][i-1]
            if i<9:
                dp[n][bit|mask][i] += dp[n-1][bit][i+1]
            dp[n][bit|mask][i] %= 1_000_000_000

print(sum(dp[N][(1<<10) - 1])%1_000_000_000)
