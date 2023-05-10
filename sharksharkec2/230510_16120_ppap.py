LINE = input()
L = len(LINE)

Pcount = 0
idx = 0

while idx < L:
    ch = LINE[idx]

    if ch == 'A':
        if Pcount < 2:
            print('NP')
            exit(0)

        Pcount -= 2

        if idx+1 >= L or LINE[idx+1] == 'A':
            print('NP')
            exit(0)

    else:
        Pcount += 1
    
    idx += 1

if Pcount == 1:
    print('PPAP')

else:
    print('NP')
