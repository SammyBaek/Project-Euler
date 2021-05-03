# 58
import math

ind = 0
num = 2
primes = []

def is_prime(num):
    for n in range(2, int(math.sqrt(num))+1):
        if num % n == 0:
            return False
    return num > 1

def get_percentage():
    return len(primes) / (ind * 4 + 1)

def add_sides(ind, num):
    for y in range(-ind, ind+1):
        if abs(ind+1) == abs(y) and is_prime(num):
            primes.append((ind+1, y))
        num += 1
    for x in range(ind+1, -ind-1, -1):
        if abs(x) == abs(ind+1) and is_prime(num):
            primes.append((x, ind+1))
        num += 1
    for y in range(ind+1, -ind-1, -1):
        if abs(-ind-1) == abs(y) and is_prime(num):
            primes.append((-ind-1, y))
        num += 1
    for x in range(-ind-1, ind+2):
        if abs(x) == abs(-ind-1) and is_prime(num):
            primes.append((x, -ind-1))
        num += 1
    return num

percentage = 1.
while percentage >= 0.1:
    num = add_sides(ind, num)
    ind += 1
    percentage = get_percentage()
    print(ind, percentage)
print(f"Answer: {2*ind + 1}")

