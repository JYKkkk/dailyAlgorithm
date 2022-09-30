# 2357번 최솟값과 최댓값: PyPy3

N, M = map(int, input().split())

bit = 1
while bit<N:
    bit<<=1

maxbit = bit

maxtree = [0 for _ in range(2*bit)]
mintree = [2_000_000_000 for _ in range(2*bit)]

for i in range(bit, bit+N):
    maxtree[i] = mintree[i] = int(input())

while bit > 0 :
    bit//=2

    for i in range(bit, 2*bit):
        maxtree[i] = max(maxtree[i*2], maxtree[i*2+1])
        mintree[i] = min(mintree[i*2], mintree[i*2+1])


def maxquery(node, low, high, fr, to):
    if to<low or high<fr:
        return 0
    if fr<=low and high<=to:
        return maxtree[node]
    
    mid = (low+high)//2

    return max(maxquery(node*2, low, mid, fr, to), maxquery(node*2+1, mid+1, high, fr, to))

def minquery(node, low, high, fr, to):
    if to<low or high<fr:
        return 2_000_000_000
    if fr<=low and high<=to:
        return mintree[node]
    
    mid = (low+high)//2

    return min(minquery(node*2, low, mid, fr, to), minquery(node*2+1, mid+1, high, fr, to))



for i in range(M):
    a, b = map(int, input().split())
    print(minquery(1, 1, maxbit, a, b),maxquery(1, 1, maxbit, a, b))


