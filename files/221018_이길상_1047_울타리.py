import sys

N = int(sys.stdin.readline())

TR = [list(map(int, sys.stdin.readline().split())) for i in range(N)]

USED = [False for _ in range(N)]
X = [[i, TR[i][0]] for i in range(N)]
Y = [[i, TR[i][1]] for i in range(N)]
S = [[i, TR[i][2]] for i in range(N)]


X.sort(key=lambda x:x[1])
Y.sort(key=lambda x:x[1])
S.sort(key=lambda x:x[1])

answer = N-1

req = X[-1][1]-X[0][1] + Y[-1][1]-Y[0][1]

hav1 = 0
for xl in range(N-1):
  hav2 = hav1
  temp2 = USED[:]
  for xh in range(N-1, xl, -1):
    hav3 = hav2
    temp3 = USED[:]
    for yl in range(N-1):
      hav4 = hav3
      temp4 = USED[:]
      for yh in range(N-1, yl, -1):
        req = (X[xh][1]-X[xl][1] + Y[yh][1]-Y[yl][1])*2
        if hav4>= req:
          answer = min(answer, sum(USED))
        #   if answer == 3:
        #     pass
        elif sum(USED)<answer:
          hav5 = hav4
          temp5 = USED[:]
          idx = N-1
          while sum(USED)<answer:
            while USED[S[idx][0]]: idx-=1
            hav5+= TR[S[idx][0]][2]
            USED[S[idx][0]] = True
            if hav5>=req:
              answer = min(answer, sum(USED))
              break
        USED = temp5
           
        if not USED[Y[yh][0]]:
          hav4+= TR[Y[yh][0]][2]
          USED[Y[yh][0]] = True
      USED = temp4
      if not USED[Y[yl][0]]:
        hav3+= TR[Y[yl][0]][2]
        USED[Y[yl][0]] = True
    USED = temp3
    if not USED[X[xh][0]]:
      hav2+= TR[X[xh][0]][2]
      USED[X[xh][0]] = True
  USED = temp2
  if not USED[X[xl][0]]:
    hav1+= TR[X[xl][0]][2]
    USED[X[xl][0]] = True

print(answer)