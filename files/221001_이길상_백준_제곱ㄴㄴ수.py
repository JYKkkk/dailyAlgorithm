import math
MIN, MAX = map(int, input().split())

nonsquare = [True for _ in range(MIN, MAX +1)]
prime = [True for _ in range(1_000_001)]
prime[0] = prime[1] = False

i = 2
while i <= 1_000_000:
    if  prime[i]:
        sq = i*i
        start = math.ceil(MIN/sq)*sq
        for j in range(start, MAX+1, sq):
            if nonsquare[j-MIN]:
                nonsquare[j-MIN] = False

        if i <= 1_000:
            j = i*2
            while j <= 1_000_000:
                if prime[j]:
                    prime[j] = False
                j+=i
    i+=1

print(sum(nonsquare))

# 에라토스테네스의 체
# for i in range(2, 1001):
#     if  prime[i]:
#         for j in range(i*2, 1_000_001, i):
#             if prime[j]:
#                 prime[j] = False
# 
# print(sum(prime))

# for i in range(2, int(math.sqrt(MAX)) + 1):
#     sq = i*i
#     start = math.ceil(min/sq)*sq
#     for j in range(start, MAX+1, sq):
#         if nonsquare[j-MIN] and j%sq == 0:
#             nonsquare[j-MIN] = False


