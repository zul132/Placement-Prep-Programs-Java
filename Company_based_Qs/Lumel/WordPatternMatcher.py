def solve(pattern, str):
    # TODO: Implement the function logic here
    lenP = len(pattern) # get the no of characters in the pattern
    words = str.split(" ")
    lenT = len(words) # get the number of words in the text

    # Check whether the pattern length matches the no of words in the text
    if (lenP == lenT):
      patMatcher = dict() # initialize an empty dictionary for storing the matched pattern words
      uniqueWords = set() # initialize an empty set to store the unique words
      
      for i in range(0,lenP):
        char = pattern[i]
        word = words[i]
        # when a new unique character is found, see if it can be matched to any word in the text
        if char not in patMatcher:
          if word not in uniqueWords:
            patMatcher[char] = word  # if the word is not already mapped to another char, then add the matching word to the dictionary
            uniqueWords.add(word)
          else:
            return False

        # If char is already mapped to a word earlier, check if the new word matches the word that was previously mapped to that char
        elif word != patMatcher[char]:
          return False # if an inconsistancy is found, return False

      # if all characters were mapped to the corresponding words in the text consistantly, then return True
      return True
          
      
    # If the pattern is longer or shorter than the the no of words in the text, return False
    return False;

# Driver Code
result1 = solve("abba","dog cat cat dog") # test case 1
result2 = solve("abba","dog cat cat fish") # test case 2
result3 = solve("abba","cat cat cat cat") # test case 3

# print the results of the sample test cases
print(result1)
print(result2)
print(result3)