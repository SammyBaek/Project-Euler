# 59
# got lucky since the key is pretty low :P
import itertools

f = open("texts/p059_cipher.txt", "r")
cypher = list(map(int, f.read().split(",")))
f.close()

f = open("texts/google-10000-english.txt", "r")
dictionary = set(f.read().split("\n"))
f.close()

keys = itertools.product(list(range(ord('a'), ord('z')+1)), repeat=3)

def decrypt(key):
    ans = []
    for i, num in enumerate(cypher):
        ans.append(chr(num ^ key[i % len(key)]))
    return ''.join(ans)

def likelihood(text):
    total = 0
    for word in dictionary:
        total += (text.count(word) ** 3)
    return total

ans = ""
maxP = 1000000000
for key in [(101, 120, 112)]:
    text = decrypt(key)
    p = likelihood(text)
    if p > maxP:
        maxP = p
        ans = key
        sumText = sum(ord(t) for t in text)
        print(key, sumText, text)

import pdb; pdb.set_trace()

