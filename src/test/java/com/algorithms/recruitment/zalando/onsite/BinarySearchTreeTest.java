package com.algorithms.recruitment.zalando.onsite;

import static org.assertj.core.api.Assertions.*;
import static com.algorithms.recruitment.zalando.onsite.BinarySearchTree.Node;
import org.junit.Test;

public class BinarySearchTreeTest {
  @Test
  public void shouldReturnZeroWhenTreeIsEmpty(){
    BinarySearchTree<String> bst = new BinarySearchTree(null);
    assertThat(bst.getHeight()).isEqualTo(0);
  }

  @Test
  public void shouldReturn1WhenTreeHasOneNode(){
    BinarySearchTree<String> bst = new BinarySearchTree(new Node("1", null, null));
    assertThat(bst.getHeight()).isEqualTo(1);
  }

  @Test
  public void shouldReturn2WhenTreeHas3Nodes(){
    BinarySearchTree<String> bst = new BinarySearchTree(new Node("8", new Node("4", null, null), new Node("10", null, null)));
    assertThat(bst.getHeight()).isEqualTo(2);
  }

  @Test
  public void shouldReturnZeroWhenTreeDoesNotHaveRightNode(){
    BinarySearchTree<String> bst = new BinarySearchTree(new Node("8", new Node("4", null, null), null));
    assertThat(bst.getHeight()).isEqualTo(2);
  }
}
