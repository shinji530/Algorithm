import sys
input = sys.stdin.readline

N = int(input())
S, T = '', ''
# S 문자열 입력
for _ in range(N):
    s = input().rstrip()
    S += s

# T 문자열 입력 
# 앞 뒤 중 더 작은 글자 입력
# 인덱스 생성하여 포인터 생성
l_idx, r_idx = 0, N-1
# 80글자마다 새 줄 문자 출력해야 하므로 cnt변수
cnt = 0
while l_idx <= r_idx:
    if S[l_idx] < S[r_idx]:
        T += S[l_idx]
        l_idx += 1
    elif S[l_idx] > S[r_idx]:
        T += S[r_idx]
        r_idx -= 1
    else:
				# 같은 글자가 나왔을 때 어디까지 중복으로 나오는지 체크하기 위한 인덱스 추가
        l, r = l_idx, r_idx
        same = True
        while l <= r:
            if S[l] < S[r]:
                T += S[l_idx]
                l_idx += 1
                same = False
                break

            elif S[l] > S[r]:
                T += S[r_idx]
                r_idx -= 1
                same = False
                break
            # 포인터가 가운데에서 만날 때까지 동일하다면
            else:
                l += 1
                r -= 1
        # 왼쪽에서 입력        
        if same:
            T += S[l_idx]
            l_idx += 1

    cnt += 1
    # 80줄마다 새 줄로 끊어줘야 함
    if cnt % 80 == 0:
        T += '\n'

print(T)