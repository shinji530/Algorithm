import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    PS = input().strip('\n')

    li = list()
    result = True

    for i in PS:
        if i == '(':
            li.append(i)
        else:
            if (len(li) == 0):
                result = False
                break

            li.pop()

    if result and len(li) == 0 :
        print("YES")
    else:
        print("NO")