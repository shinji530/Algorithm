import sys
input = sys.stdin.readline

N = int(input())

def draw_star(n):
    if n == 1:
        return ['*']
    stars = draw_star(n // 3)
    M = []
    for s in stars:
        M.append(s * 3)
    for s in stars:
        M.append(s + ' ' * (n // 3) + s)
    for s in stars:
        M.append(s * 3)

    return M

print('\n'.join(draw_star(N)))