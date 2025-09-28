/* 
    Q1. LeetCode 3692. Majority Frequency Characters
    Link: https://leetcode.com/problems/majority-frequency-characters/description/

    You are given a string s consisting of lowercase English letters.

    The frequency group for a value k is the set of characters that appear exactly k times in s.
    The majority frequency group is the frequency group that contains the largest number of distinct characters.

    Return a string containing all characters in the majority frequency group, in any order. 
    If two or more frequency groups tie for that largest size, pick the group whose frequency k is larger.

    Example 1:
    Input: s = "aaabbbccdddde"
    Output: "ab"

    Example 2:
    Input: s = "abcd"
    Output: "abcd"

    Example 3:
    Input: s = "pfpfgi"
    Output: "fp"
*/
import java.util.*;

public class Majority_Frequency_Characters {
    public String majorityFrequencyGroup(String s) {
        String res = "";

        /* First we will find the frequency of each character in the input string */
        Map<Character, Integer> charFreq = new HashMap<>();
        /* Then we will build the frequency group for every frequency value k */
        Map<Integer, List<Character>> freqGroups = new HashMap<>();

        // Start by counting the frequency of each character in the string.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!charFreq.containsKey(ch)) {
                charFreq.put(ch, 1);
            } else {
                charFreq.put(ch, charFreq.get(ch) + 1);
            }
        }

        // Group characters based on their frequencies.
        Set<Character> chars = charFreq.keySet();
        for (Character ch : chars) {
            int k = charFreq.get(ch);

            if (!freqGroups.containsKey(k)) {
                freqGroups.put(k, new ArrayList<>(Arrays.asList(ch)));
            } else {
                freqGroups.get(k).add(ch);
            }
        }

        // Identify the group with the largest number of distinct characters.
        int maxK = 0;
        int majorGroupSize = 0;

        for (Integer k : freqGroups.keySet()) {
            int groupSize = freqGroups.get(k).size();

            if (groupSize > majorGroupSize) {
                majorGroupSize = groupSize;
                maxK = k;
            }
            // If multiple groups tie, select the one with the higher frequency value.
            else if (groupSize == majorGroupSize) {
                if (k > maxK) {
                    maxK = k;
                }
            }
        }

        // Construct the answer string using all characters from that chosen group.
        List<Character> majorFreqGroup = freqGroups.get(maxK);
        for (Character ch : majorFreqGroup) {
            res = res + ch;
        }

        return res;
    }
}
