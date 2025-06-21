def generate_fibonacci_and_find_primes(n):
    if not isinstance(n, int) or n < 0:
        print("Error: N must be a non-negative integer.")
        return

    print(f"Generating Fibonacci sequence up to {n} and finding primes...")

    fib_sequence = []
    a, b = 0, 1
    while a <= n:
        fib_sequence.append(a)
        a, b = b, a + b

    print(f"\nFibonacci sequence up to {n}: {fib_sequence}")

    prime_fib_numbers = []
    for num in fib_sequence:
        if is_prime(num):
            prime_fib_numbers.append(num)

    print(f"\nPrime numbers in the Fibonacci sequence up to {n}: {prime_fib_numbers}")

def is_prime(num):
  
    if num < 2:  # Numbers less than 2 are not prime
        return False
    if num == 2:  # 2 is the only even prime number
        return True
    if num % 2 == 0:  # Other even numbers are not prime
        return False
    
    i = 3
    while i * i <= num:
        if num % i == 0:
            return False
        i += 2
    return True

if __name__ == "__main__":
    print("--- Test Case 1: N = 100 ---")
    generate_fibonacci_and_find_primes(100)
    print("\n" + "="*30 + "\n")
