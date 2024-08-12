import java.util.Scanner;

class Anagram 
{
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            int[] hash = new int[26];
            for (int i = 0; i < a.length(); i++) {
				hash[a.charAt(i) - 97]++;
                hash[b.charAt(i) - 97]--;
            }
            for (int i = 0; i < 26; i++)
                if (hash[i] != 0)
                    return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

        if (isAnagram(s1, s2))
            System.out.println("Anagram");
        else
            System.out.println("Not an Anagram");
        sc.close();
    }
}
