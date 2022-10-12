import sys

N, M, K = map(int, sys.stdin.readline().split())
nums = [int(sys.stdin.readline()) for _ in range(N)]
segtree = [1 for _ in range(4*N)]
DIV = 1_000_000_007

def init(node, lo, hi):
    if lo==hi:
        segtree[node] = nums[lo-1]
    else:
        mid = (lo+hi)//2
        segtree[node] = init(node*2 + 1, lo, mid) * init(node*2 + 2, mid+1, hi) % DIV
    return segtree[node]

def change(node, lo, hi, b, c):
    if lo<= b and b<=hi:
        if lo==hi:
            segtree[node] = c
        else:
            mid = (lo+hi)//2
            segtree[node] = change(node*2 + 2, mid+1, hi, b, c) * change(node*2 + 1, lo, mid, b, c) % DIV
    return segtree[node]

def query(node, lo, hi, fr, to):
    if fr<=lo and hi<=to:
        return segtree[node]
    elif to<lo or hi<fr:
        return 1
    
    mid = (lo+hi)//2
    
    return query(node*2 + 1, lo, mid, fr, to) * query(node*2 + 2, mid+1, hi, fr, to) % DIV
    
init(0, 1, N)

for _ in range(M + K):
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 1:
        change(0, 1, N, b, c)
    else:
        print(query(0, 1, N, b, c))



