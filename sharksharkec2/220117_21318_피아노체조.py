import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())

acc = [0 for _ in range(N)]
nums = list(map(int,input().split()))


for i in range(N-1):
    acc[i+1] = acc[i]
    if nums[i] > nums[i+1]:
        acc[i+1]+=1

for _ in range(int(input())):
    x, y = map(int, input().split())
    print(str(acc[y-1]-acc[x-1]))
    print('\n')
