package com.algorithms.recruitment.zalando.onsite;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
Write a method that returns the height of a binary search tree

Test1:
{}
==>  height = 0


Test2:
{
		8
}
==>  height = 1


Test3:
{
		8
   4		10
}
==>  height = 2

Test4:
{
		8
   4		10
 2    6   9

}
==>  height = 3


Test5:
{
		8
   4		10
 2    6   9    11

}
==>  height = 3

 */

@Getter
@AllArgsConstructor
public  class BinarySearchTree<T>{
  private final Node<T> root;

  @Getter
  @AllArgsConstructor
  public static class Node <T> {
    private final T data;
    private final Node left;
    private final Node right;
  }

  private int getHeight(Node node){
    if (node == null) {
      return 0;
    }

    return getHeight(node.getLeft()) + 1;
  }

  public int getHeight(){
    return getHeight(root);
  }
}
