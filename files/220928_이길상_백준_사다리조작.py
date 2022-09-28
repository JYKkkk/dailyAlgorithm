# PyPy3로 제출해야 통과. python3로 제출하면 시간초과.
def simul():
    for n in range(1, N + 1):
        c = n
        for h in range(1, H + 1):
            if ladder[h][c]:
                c+=1
            elif ladder[h][c-1]:
                c-=1
        if c!= n:
            return False
    return True

answer = [4]
def newladder(i, n, h):


    if simul():
        answer[0] = min(answer[0], i)

    if i==3 or answer[0]<=i:
        return

    for r in range(h, H+1):
        for c in range(n, N):
            if ladder[r][c] or ladder[r][c+1] or ladder[r][c-1]:
                continue
            ladder[r][c] = True
            newladder(i+1, c, r)
            ladder[r][c] = False
        n = 1

#=======

N, M, H = map(int, input().split())

ladder = [[False for n in range(N+1)]  for h in range(H+1)]

for i in range(M):
    a, b = map(int, input().split())
    ladder[a][b] = True


newladder(0, 1, 1)

if answer[0] == 4:
    answer[0] = -1
print(answer[0])