def find_second_largest(numbers):
    if not isinstance(numbers, list):
        raise TypeError("Input must be a list.")

    unique_numbers = sorted(list(set(numbers)))

    if len(unique_numbers) < 2:
        return None  
    return unique_numbers[-2]

if __name__ == "__main__":
    print("--- Test Case 1: Standard list ---")
    list1 = [10, 5, 20, 15, 25]
    print(f"List: {list1}, Second largest: {find_second_largest(list1)}") 
