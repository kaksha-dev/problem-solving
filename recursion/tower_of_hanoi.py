
class TowerOfHanoi:
    """
    No of steps required to solve TOH - calculation
    as per algo move n-1 disc to aux then move 1 to dest then move n-1 from aux to dest
    f(n) = f(n-1) + 1 + f(n-1)
    f(n) = 2*f(n-1) + 1
    f(n) = 2*(2f(n-2) +1) + 1 => 2^^2*f(n-2) + 2^^2 - 1 => 2^^3*f(n-3) + 2^^3 -1
    f(n) = 2^^r*f(n-r) + 2^^r - 1
    we know the steps required when r=n-1 OR n = 1 => f(1) = 1
    f(n) = 2^^(n-1)f(1) + 2^^(n-1) + 1 => 2*2^^(n-1) + 1 = 2^^n + 1
    """

    def __init__(self):
        self.steps = 0

    def move_a_disc(self, source, dest):
        print(f"Moving a disc from {source} to {dest}")
        self.steps += 1

    def solve(self, n, source, dest, helper):
        if n == 1:
            self.move_a_disc(source, dest)
            return
        self.solve(n-1, source, helper, dest)
        self.move_a_disc(source, dest)
        self.solve(n-1, helper, dest, source)


if __name__ == '__main__':
    toh = TowerOfHanoi()
    n = 3
    toh.solve(n, "Tow1", "Tow3", "Tow2")
    print(f"{n} disc are moved as per TOH in {toh.steps} steps")
    assert toh.steps == pow(2, n) - 1
