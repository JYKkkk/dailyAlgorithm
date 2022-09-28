def trans(point, origin):
    x = point[0]-origin[0]
    y = point[1]-origin[1]
    return [origin[0] - y, origin[1] + x]

dx = [1, 0,-1, 0]
dy = [0,-1, 0, 1]

# ======================

N = int(input())

cc = [[False for i in range(101)] for j in range(101)]

for i in range(N):
    x, y, d, g = map(int, input().split())

    points = [[x, y], [x+dx[d], y+dy[d]]]

    for j in range(g):
        origin = points[-1]

        for k in range(len(points)-2, -1, -1):
            points.append(trans(points[k], origin))

    for r, c in points:
        cc[r][c] = True

answer = 0
for i in range(100):
    for j in range(100):
        if cc[i][j] and cc[i+1][j] and cc[i][j+1] and cc[i+1][j+1]:
            answer+=1

print(answer)
