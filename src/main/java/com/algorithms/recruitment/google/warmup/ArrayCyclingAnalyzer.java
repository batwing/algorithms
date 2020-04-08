package com.algorithms.recruitment.google.warmup;

/** Google coding intervie warmup ***

 Check if an array has cycles

 Test1
 in: [0,1,2,3,4]
 out: false

 Test2
 in: []
 out: false

 Test3
 in: [0,1,2,1,3,4,5]
 out: true
 ************************************/

public class ArrayCyclingAnalyzer {

  public Boolean isCyclingInArray(int[] array){
    int rabbit = 0;
    int turtle = 0;

    while(rabbit != array.length){

      rabbit = array[rabbit];
      if (rabbit == turtle) {
        return true;
      }

      if (rabbit == array.length) {
        return false;
      }

      rabbit = array[rabbit];
      if (rabbit == turtle) {
        return true;
      }

      if (rabbit == array.length) {
        return false;
      }

      turtle = array[turtle];
      if (rabbit == turtle) {
        return true;
      }

    }

    return false;
  }
}
