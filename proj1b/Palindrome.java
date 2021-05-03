public class Palindrome {
    /**Given a String, wordToDeque should return a Deque
     * where the characters appear in the same order as in the String.*/
    public Deque<Character> wordToDeque(String word){
        Deque<Character> cd = new LinkedListDeque<>();
        for(int i = 0;i<word.length();i++){
            cd.addLast(word.charAt(i));
        }
        return cd;
    }

    /**Return true if the given word is a palindrome, and false otherwise.
     * A palindrome is defined as a word that is the same whether it is read forwards or backwards.*/
    public boolean isPalindrome(String word){
        Deque<Character> wordDeque= wordToDeque(word);
        boolean isP = removeFirstAndLast(wordDeque);
        while(wordDeque.size()>1 && isP){
            isP = removeFirstAndLast(wordDeque);
        }
        return isP;
    }
    private boolean removeFirstAndLast(Deque d){
        if(d.isEmpty() || d.size()==1){
            return true;
        }else if(d.removeLast()==d.removeFirst()){
            return true;
        }else{
            return false;
        }
    }
    /**
     * return true if the word is a palindrome
     * according to the character comparison test
     * provided by the CharacterComparator passed in as argument cc.
     * A character comparator is defined as shown below:
     * This interface defines a method for determining equality of characters. */
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wordDeque= wordToDeque(word);
        boolean isP = removeFirstAndLast(wordDeque,cc);
        while(wordDeque.size()>1 && isP){
            isP = removeFirstAndLast(wordDeque,cc);
        }
        return isP;
    }
    private boolean removeFirstAndLast(Deque d,CharacterComparator cc){

        if(d.isEmpty() || d.size()==1){
            return true;
        }else if(cc.equalChars((char) d.removeLast(),(char)d.removeFirst())){
            return true;
        }else{
            return false;
        }
    }
}
