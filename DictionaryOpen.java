//public class DictionaryOpen{
//  public String[] dict;
//  private int count;
//  private static final double LOAD_FACTOR = 0.6;
//  
//  //costructor. takes a size and creates an array of size s
//  //where s is the nearest prime number large than s
//  public DictionaryOpen(int size){
//    size = getNextPrime(size);
//    dict = new String [size];
//    count = 0;
//  }
//  
//  public void insert(String newWord){
//    if(!search(newWord)){
//      newWord = newWord.toLowerCase();
//      if(count >= LOAD_FACTOR*dict.length)
//        enlargeDict();
//      int key = getHashValue(newWord, dict.length);
//      int stepSize = 0;
//      if(dict[key] != null)
//        stepSize = doubleHashing(newWord);
//      while(dict[key] != null){
//        key = (key + stepSize) % dict.length;
//      }
//      dict[key] = newWord;
//      count++;
//    }
//  }
// 
//  public boolean search(String newWord){
//    newWord = newWord.toLowerCase();
//    int key = getHashValue(newWord,dict.length);
//    int stepSize = 0;
//    if(dict[key] != null && !dict[key].equals(newWord))
//      stepSize = doubleHashing(newWord);
//    int startPoint = key;
//    boolean found = newWord.equals(dict[key]);
//    key = (key + stepSize) % dict.length;
//    while(!found && key != startPoint){
//      if(newWord.equals(dict[key])){
//        found = true;
//        break;
//      }
//      key = (key + stepSize) % dict.length;
//      //System.out.println("Checking next spot");
//    }
//    return found;
//  }
//  
//  public int getSize(){
//    return count;
//  }
//  
//  public String toString(){
//    String s = "Dictionary: ";
//    for(int i = 0; i < dict.length; i++){
//      s += "\n" + dict[i];
//    }
//    return s;
//  }
//  
//  /**********************************HELPER METHODS****************************************/
//  private boolean isPrime(int p){
//    boolean prime = true;
//    for(int i = 2; (i*i <= p)&& prime; i++){
//      if(p%i == 0)
//        prime = false;
//    }
//    return prime;
//  }
//  
//  private int getNextPrime(int p){
//    int nextPrime = p;
//    while(!isPrime(nextPrime)){
//      nextPrime++;
//    }
//    return nextPrime;
//  }
//  
//  public static int getHashValue(String in, int hashArraySize){
//      int hashValue = 0;
//      int a = 27;
//      
//      
//      for(char c: in.toCharArray()){
//         hashValue = (hashValue*a) % hashArraySize;
//         hashValue += (((int) c ) - 97) % hashArraySize;
//      }
//      return hashValue%hashArraySize;
//  }
//  
//  private int doubleHashing(String in){
//    int constant = 41;
//    int sum = 0;
//    for(char c: in.toCharArray()){
//      if(c >= 'a' && c <= 'z')
//         sum += (((int) c ) - 97);
//      }
//    int stepSize = constant - (sum%constant);
//    
//    return stepSize;
//  }
//  
//  private void enlargeDict(){
//    String[] newDict = new String[getNextPrime(dict.length+1)];
//    int key;
//    int stepSize;
//    for(int i = 0; i < dict.length; i++){
//      if(dict[i] != null){
//        key = getHashValue(dict[i],newDict.length);
//        stepSize = doubleHashing(dict[i]);
//        while(newDict[key] != null){
//          key = (key + stepSize) % newDict.length;
//        }
//        newDict[key] = dict[i]; 
//      }
//    }
//    dict = newDict;
//  }
//  
//  
//}