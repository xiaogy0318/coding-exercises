def chunks(l, n):
    for x in range(0, n*n, n):
        yield l[x:x+n]

l = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        
print(list(chunks(l, 3))[2][2])

