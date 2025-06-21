def analyze_text_file(file_path):
  total_lines = 0 
  total_words = 0 
  total_characters = 0 

  try:
    with open(file_path, 'r', encoding='utf-8') as file:
      for line in file:
        total_lines += 1 
        total_characters += len(line) 
        words = line.split()
        total_words += len(words) 
        
    return (total_lines, total_words, total_characters) 

  except FileNotFoundError:
    print(f"Error : The file was not found.")
    return None 
  except Exception as e:
    print(f"An unexpected error occurred : {e}") 
    return None 

if __name__ == "__main__":
  file_path_input = input("Enter the path to the text file: ") 
  results = analyze_text_file(file_path_input) 

  if results:
    lines, words, characters = results 
    print("\n--- Analysis Results ---")
    print(f"Total number of lines: {lines}")
    print(f"Total number of words: {words}")
    print(f"Total number of characters: {characters}")
