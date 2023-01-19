DELTA = ((1,0),(-1,0),(0,1),(0,-1))

N, M = map(int, input().split())

NL = [list(map(int, input().split())) for _ in range(N)]

def count():
    visited = [[False for _ in range(M)] for _ in range(N)]

    result = 0
    for n in range(N):
        for m in range(M):
            if NL[n][m]>0 and not visited[n][m]:
                stack = [[n, m]]
                visited[n][m] = True
                while len(stack)>0:
                    x, y = stack.pop()
                    for dx, dy in DELTA:
                        nx = x+dx
                        ny = y+dy
                        if nx<0 or ny<0 or nx>=N or ny>=M:
                            continue
                        if NL[nx][ny]<=0 or visited[nx][ny]:
                            continue
                        stack.append([nx, ny])
                        visited[nx][ny] = True
                result += 1
    
    return result

def melt():
    visited = [[False for _ in range(M)] for _ in range(N)]
    record = [[0 for _ in range(M)] for _ in range(N)]

    for n in range(N):
        for m in range(M):
            if NL[n][m]>0 and not visited[n][m]:
                stack = [[n, m]]
                visited[n][m] = True
                while len(stack)>0:
                    x, y = stack.pop()
                    for dx, dy in DELTA:
                        nx = x+dx
                        ny = y+dy
                        if nx<0 or ny<0 or nx>=N or ny>=M:
                            continue
                        if visited[nx][ny]:
                            continue
                        if NL[nx][ny]<=0:
                            record[x][y]+=1
                            continue
                        stack.append([nx, ny])
                        visited[nx][ny] = True
    
    for n in range(N):
        for m in range(M):
            NL[n][m] -= record[n][m]
            if NL[n][m]<0:
                NL[n][m] = 0


year = 0
while True:
    year+=1
    melt()

    ice = count()
    if ice > 1:
        print(year)
        break
    if ice == 0:
        print(0)
        break

