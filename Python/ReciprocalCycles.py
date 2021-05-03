import math

def simplify(num, den):
    gcd = math.gcd(num, den)
    while gcd > 1:
        num = num // gcd
        den = den // gcd
        gcd = math.gcd(num, den)
    return num, den

def get_cycle_len(den):
    seen = {}
    decimal = []
    num = 1
    idx = 0
    while (num, den) not in seen:
        seen[(num, den)] = idx
        idx += 1
        number = (num * 10) // den
        num = (num * 10) % den
        if num  == 0:
            return 0
        decimal.append(number)
        num, den = simplify(num, den)
    return idx - seen[(num, den)]


if __name__ == "__main__":
    ans = 0
    maxCyc = 0
    for den in range(2, 1000):
        cyc = get_cycle_len(den)
        if cyc > maxCyc:
            maxCyc = cyc
            ans = den
    print(f"Answer: {ans}")

