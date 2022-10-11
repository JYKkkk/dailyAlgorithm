import sys

N, M = map(int, sys.stdin.readline().split())
nums = [int(sys.stdin.readline()) for _ in range(N)]
segtree = [0 for _ in range(4*N)]

def init(node, lo, hi):
    if lo==hi:
        segtree[node] = nums[lo-1]
    else:
        mid = (lo+hi)//2
        segtree[node] = min(init(node*2 + 1, lo, mid) , init(node*2 + 2, mid+1, hi))
    return segtree[node]


def query(node, lo, hi, fr, to):
    if fr<=lo and hi<=to:
        return segtree[node]
    elif to<lo or hi<fr:
        return 1_000_000_001
    
    mid = (lo+hi)//2
    
    return min(query(node*2 + 1, lo, mid, fr, to) , query(node*2 + 2, mid+1, hi, fr, to))
    
init(0, 1, N)

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    print(query(0, 1, N, a, b))



