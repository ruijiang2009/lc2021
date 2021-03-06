package com.myrj.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question388Test {
  Question388 solution = new Question388();
  @Test
  public void test1() {
    String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
    int result = solution.lengthLongestPath(input);
    Assert.assertEquals(20, result);
  }

  @Test
  public void test4() {
    String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    int result = solution.lengthLongestPath(input);
    Assert.assertEquals(32, result);
  }

  @Test
  public void test5() {
    String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    int result = solution.lengthLongestPath(input);
    Assert.assertEquals(32, result);
  }

  @Test
  public void test6() {
    String input = "sladjf\n\tlkjlkv\n\t\tlkjlakjlert\n\t\t\tlaskjglaksjf\n\t\t\t\tlakjgfljrtlj\n\t\t\t\t\tlskajflakjsvlj\n\t\t\t\t\t\tlskgjflkjrtlrjt\n\t\t\t\t\t\t\tlkjglkjlvkjdlvkj\n\t\t\t\t\t\t\t\tlfjkglkjfljdlv\n\t\t\t\t\t\t\t\t\tlkdfjglerjtkrjkljsd.lkvjlkajlfk\n\t\t\t\t\t\t\tlskfjlksjljslvjxjlvkzjljajoiwjejlskjslfj.slkjflskjldfkjoietruioskljfkljf\n\t\t\t\t\tlkasjfljsaljlxkcjzljvl.asljlksaj\n\t\t\t\tasldjflksajf\n\t\t\t\talskjflkasjlvkja\n\t\t\t\twioeuoiwutrljsgfjlskfg\n\t\t\t\taslkjvlksjvlkjsflgj\n\t\t\t\t\tlkvnlksfgk.salfkjaslfjskljfv\n\t\t\tlksdjflsajlkfj\n\t\t\tlasjflaskjlk\n\t\tlsakjflkasjfkljas\n\t\tlskjvljvlkjlsjfkgljfg\n\tsaljkglksajvlkjvkljlkjvksdj\n\tlsakjglksajkvjlkjdklvj\n\tlskjflksjglkdjbkljdbkjslkj\n\t\tlkjglkfjkljsdflj\n\t\t\tlskjfglkjdfgkljsdflj\n\t\t\t\tlkfjglksdjlkjbsdlkjbk\n\t\t\t\t\tlkfgjlejrtljkljsdflgjl\n\t\t\t\t\tsalgkfjlksfjgkljsgfjl\n\t\t\t\t\tsalkflajwoieu\n\t\t\t\t\t\tlaskjfglsjfgljkkvjsdlkjbklds\n\t\t\t\t\t\t\tlasjglriotuojgkjsldfgjsklfgjl\n\t\t\t\t\t\t\t\tlkajglkjskljsdljblkdfjblfjlbjs\n\t\t\t\t\t\t\t\t\tlkajgljroituksfglkjslkjgoi\n\t\t\t\t\t\t\t\t\t\tlkjglkjkljkljdkbljsdfljgklfdj\n\t\t\t\t\t\t\t\t\t\t\tlkjlgkjljgslkdkldjblkj\n\t\t\t\t\t\t\t\t\t\t\t\tlkjfglkjlkjbsdklj.slgfjalksjglkfjglf\n\t\t\t\t\t\t\t\t\t\t\t\tlkasjrlkjwlrjljsl\n\t\t\t\t\t\t\t\t\t\t\t\t\tlksjgflkjfklgjljbljls\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjsglkjlkjfkljdklbjkldf\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjglkjdlsfjdglsdjgjlxljjlrjsgjsjlk\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjsgkllksjfgjljdslfkjlkasjdflkjxcljvlkjsgkljsfg\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlaskjlkjsakljglsdjfgksdjlkgjdlskjb\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkajsgfljfklgjlkdjgfklsdjklj\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjfglkjlkgjlkjl.aslkjflasjlajglkjaf\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlkjasflgjlskjglkfjgklgsdjflkbjsdklfjskldfjgklsfdjgklfdjgl\n\tlskadjlkjsldwwwwwfj\n\t\tlkjflkasjlfjlkjajslfkjlasjkdlfjlaskjalvwwwwwwwwwwwwwwwkjlsjfglkjalsjgflkjaljlkdsjslbjsljksldjlsjdlkjljvblkjlkajfljgasljfkajgfljfjgldjblkjsdljgsldjg.skljf";
    int result = solution.lengthLongestPath(input);
    Assert.assertEquals(528, result);
  }

  @Test
  public void test7() {
    String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    int result = solution.lengthLongestPath(input);
    Assert.assertEquals(32, result);
  }


  @Test
  public void test8() {
    String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    int result = solution.lengthLongestPath(input);
    Assert.assertEquals(32, result);
  }

  @Test
  public void test2() {
    String input = "\t\tfile.ext";
    int result = solution.countTab(input);
    Assert.assertEquals(2, result);
  }

  @Test
  public void test3() {
    String input = "\tfile.ext";
    int result = solution.countTab(input);
    Assert.assertEquals(1, result);
  }
}
