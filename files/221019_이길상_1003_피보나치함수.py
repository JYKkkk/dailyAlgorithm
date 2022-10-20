import sys

T = int(sys.stdin.readline())

OZ = [[-1,-1] for i in range(41)]

OZ[0][0] = 1
OZ[0][1] = 0
OZ[1][0] = 0
OZ[1][1] = 1

for i in range(2, 41):
  OZ[i][0] = OZ[i-1][0]+OZ[i-2][0]
  OZ[i][1] = OZ[i-1][1]+OZ[i-2][1]

for t in range(T):
  N = int(sys.stdin.readline())
  sys.stdout.write(str(OZ[N][0]) + " " +  str(OZ[N][1]) + '\n')
