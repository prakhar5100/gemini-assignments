def are_anagrams(str1, str2):

    def clean_string(s):
        cleaned_chars = [char.lower() for char in s if char.isalnum()]
        return "".join(cleaned_chars)

    cleaned_str1 = clean_string(str1)
    cleaned_str2 = clean_string(str2)

    if len(cleaned_str1) != len(cleaned_str2):
        return False

    return sorted(cleaned_str1) == sorted(cleaned_str2)

if __name__ == "__main__":
    print("--- Test Case 1: Basic Anagrams ---")
    s1_1 = "Listen"
    s1_2 = "Silent"
    print(f"'{s1_1}' and '{s1_2}' are anagrams: {are_anagrams(s1_1, s1_2)}") 
