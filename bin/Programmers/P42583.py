from collections import deque
def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = deque([0] * bridge_length)
    truck_weights = deque(truck_weights)
    # sum 시간초과 막기 위함
    cur_weight = 0

    while bridge:
        time += 1
        cur_weight -= bridge.popleft()
        if truck_weights:
            if truck_weights[0] + cur_weight <= weight:
                cur_weight += truck_weights[0]
                bridge.append(truck_weights.popleft())
            else:
                bridge.append(0)

    return time

print(solution(2, 10, [7,4,5,6]))
print(solution(100, 100, [10]))
print(solution(100, 100, [10,10,10,10,10,10,10,10,10,10]))