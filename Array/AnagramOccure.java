/*
**************** Problem Description ****************
Given a word pat and a text txt.
Return the count of the occurences of anagrams of the word in the text.
  Example : 
  Input:
  txt = forxxorfxdofr
  pat = for
  Output: 3
  
  Explanation: for, orf and ofr appears
  in the txt, hence answer is 3.
*/

class AnagramOccure {

    int search(String pat, String txt) {
        // code here
        int ans = 0;

        int i = 0;
        int j = 0;
        HashMap<Character, Integer> pattern = new HashMap<>();
        HashMap<Character, Integer> subset = new HashMap<>();
        char[] ar = pat.toCharArray();

        for (char ch : ar) {
            pattern.put(new Character(ch), new Integer(pattern.getOrDefault(ch, 0) + 1));
        }

        while (j < txt.length()) {

            subset.put(new Character(txt.charAt(j)), new Integer(subset.getOrDefault(txt.charAt(j), 0) + 1));
            if (j - i + 1 < pat.length()) {
                j++;
            } else if (j - i + 1 == pat.length()) {
                if (areAnagram(pattern, subset)) {
                    ans++;
                }

                subset.put(new Character(txt.charAt(i)), new Integer(subset.getOrDefault(txt.charAt(i), 0) - 1));

                i++;
                j++;

            }
        }
        return ans;
    }

    static boolean areAnagram(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        boolean b = true;

        for (char ch1 : map1.keySet()) {

            if (!map1.get(ch1).equals(map2.get(ch1)))
                return false;

        }
        // System.out.println(map1+" "+map2+" "+b);

        return b;
    }

}

/*
 **************** Logic **************** Sliding window. Create map for anagram to store char
 * and frequency. Create a count variable to store distinct char count and to
 * avoid traversing map for checking anagram.
 */