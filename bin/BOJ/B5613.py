result = int(input())

while True:
    op = input()
    if op == '=':
        break
    num = int(input())
    if op == '+':
        result += num
    elif op == '-':
        result -= num
    elif op == '*':
        result *= num
    elif op == '/':
        result //= num
        
print(result)