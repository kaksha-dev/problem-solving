def pow_mod(x, y, n):
    # (x^^y)%m = ((x^^y/2)%m * (x^^y/2)%m)%m for even y
    # (x^^y)%m = (x * (x^^y/2)%m * (x^^y/2)%m)%m for even y
    x = x % n
    if y == 1:
        return x
    m = pow_mod(x, y//2, n) % n
    if y % 2 == 0:
        return (m*m) % n
    return (x*m*m) % n


def test():
    assert pow_mod(2, 10, 7) == (2**10) % 7
    assert pow_mod(19, 1987, 71) == (19**1987) % 71


# find (x**y)%m without using power function and taking care of overflows. assume this question in c or java
# as python takes care of overflows by dynamically increase size of number.
test()
