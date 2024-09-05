def sum_even_fibs(n):
    """
    every third number in fib series is an even number
    f(n) = f(n-1) + f(n-2) => 2f(n-2) + f(n-3) => 3f(n-3)+2f(n-4) 
            => 3f(n-3)+f(n-4)+f(n-5)+f(n-6)=>4f(n-3)+f(n-6)
    f(n) = 4f(n-3) + f(n-6)
    """
    a = 2
    sum = 0
    b = 0
    while b < n:
        sum += b
        t = 4*b+a
        a = b
        b = t
    return sum


def test():
    assert sum_even_fibs(100) == 2+8+34


# find the sum of all even numbers in a fibonacci series < n. ex: 2,8,34 are even numbers in fib under 100
test()
