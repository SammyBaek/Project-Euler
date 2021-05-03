# 31

denominations = [1, 2, 5, 10, 20, 50, 100, 200]

mem = {}
def find(dens, amount):
    if amount < 0:
        return 0
    if len(dens) == 0:
        return (amount == 0) + 0
    key = (dens, amount)
    if key in mem:
        return mem[key]
    total = 0
    total += find(dens, amount - dens[-1])
    total += find(dens[:-1], amount)

    mem[(dens, amount)] = total
    return total

ans = find(tuple(denominations), 200)
print(f"answer: {ans}")
