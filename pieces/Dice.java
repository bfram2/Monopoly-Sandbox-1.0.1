// 2 6-sided dice rolls

// 2 random numbers between 1-6 to simulate dice
public void roll() {
  int d6result = 0;
  int d6result2 = 0;
  
  d6result = (int)(Math.random() * 6) + 1;
  d6result2 = (int)(Math.random() * 6) + 1;
  //insert call to dice images that match the number
}
//return dice total to move total spaces
public int getValue() {
  int d6move = d6result + d6result2;
  return d6move;
}

//check for doubles, if true it is a double
public boolean Doubles() {
 return d6result == d6result2 & d6result + d6result2 != 0;
 //check for true, then activate movement using d6move
 //player rolls again or gets out of jail
}
