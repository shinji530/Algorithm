import sys
input = sys.stdin.readline

def is_pseudo(string, left, right):
    while True:
        if left > right : 
            break
        if string[left] == string[right]:
            left += 1
            right -= 1
        else:
            return False
    return True

def is_palindrome(string):
    # 배열이 역순과 일치할 때 성립
    if string == string[::-1]:
        return 0
    else:
        # 인덱스
        left = 0
        right = len(string) - 1
        while True:
            if left > right : 
                break
            # 회문이 아닐 때
            if string[left] != string[right]:
                # 인덱스를 한 칸씩 안 쪽으로 옮김
                l_idx = is_pseudo(string, left + 1, right)
                r_idx = is_pseudo(string, left, right - 1)
                # 인덱스가 끝나면 회문이 될 수 없음 1 반환
                if l_idx or r_idx : 
                    return 1
                # 한 문자를 뛰어넘어 회문이 가능하다면 2 반환
                else: 
                    return 2
            else:
                left += 1
                right -= 1

for _ in range(int(input())):
    print(is_palindrome(input().rstrip()))