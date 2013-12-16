package fb;

public class IsPalindrome {

}"""
bool isPalindrome(string s);
/**
A palindrome is a string that is the same when read backwards or forwards.  For example, "aba", "abba", and "racecar" are all palindromes.
You will implement a method to determine whether a string is a palindrome.

- Palindromes are case insensitive, so "Aba" is a palindrome.
- Palindromes ignore non a-z characters, so "a0ba" and "a- #&#b*b-a" are palindromes
- The empty string "" and strings with no letters, e.g. "123" are not palindromes.

1a2
"""
*/

def isPalindrome(s):
    left = 0
    right = len(s) - 1
    hasCompared = False
    while left <= right:
        if not isLetter(s[left]):
            left += 1
        elif not isLetter(s[right]):
            right -= 1
        else:
            hasCompared = True
            if s[left] != s[right]:
                return False
            else:
                left += 1
                right -= 1
    if hasCompared:           
        return True
    else:
        return False
        
        
def isLetter(c):
    // return if it is a letter
















"""
array anagramBuckets(array strings)

Write a function to group an array of strings by anagrams.

Input: An array of strings (possibly with duplicates)
Output: An array of arrays.  Each array contains a set of strings from the input array that are anagrams of each other.  The output should not contain any duplicates.

Example:
Input: ('abc', 'bac', 'xyz', 'xyz')
Output: (('abc', 'bac'), ('xyz'))

length of array: m
average length of strings: n
O(m*n*log(n))
"""

def anagramBuckets(strings):
    result = {}
    for string in strings:
        sig = get_sig(string)
        if not result.get(sig):
            result[sig] = set()
        result[sig].append(string)
       
    return result
        
def get_sig(string):
    # return sorted string
