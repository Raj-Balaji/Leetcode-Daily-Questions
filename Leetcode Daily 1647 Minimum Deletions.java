class Solution {
    public int minDeletions(String s) {
        
        // Minimum deletions in order to make a string good
        // Okay this involves just counting all the characters 100%
        // But which data structure to store in?
        
        
        // Hashmap -> out of order, hard to compare
        // Maybe sort of a hashtable/array
        // Since all the characters are lower case -> a  to z
        // we can store this in a array for quick lookup/access
        // by converting the value to ASCII we can store the instances quicker
        
        Integer[]  charFrequency = new Integer[26];
        
        for(int i=0; i<26;i++)
            charFrequency[i]=0;
        
        int asciiOffset = 97; // lowercase a = 97 for Java
        
        char[] charString = s.toCharArray();

        for(int i=0; i< charString.length;i++)
        {
            charFrequency[charString[i]  -asciiOffset]++;
        }
     
        // now we have all the instances stored let's check if they're all unique from each other
        
        
        // a.k.a if we have [10, 9, 9, 8, 7 , 5, 4] instances
        // 10 is good, delete 1 character from 9 -> 8, then delete another from 8->7, another from 7->6
        // we're left with 10,9,8,7,6,5,4
        // or another path is to delete basically 4 from 10
        // but i think that's the same as deleting 1 from "9", "8" and "7"
        // so go from largest occurence -> smallest occurence while making each instance "unique"
        // since we only have to return the minimum deletions and not the characters themselves we can just work 
        // with an integer set
                
        
        int deletions=0;
        Set<Integer> set = new HashSet();
        for(int i=0; i<charFrequency.length;i++)
        {
          
            if(set.contains(charFrequency[i]) && charFrequency[i]!=0)
            {
                charFrequency[i]--;
                deletions++;
                i--;
            }
            else
                set.add(charFrequency[i]);
        }
        
       
    
        return deletions;
    }
}