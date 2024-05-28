import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class ContainsE implements StringChecker {
  public boolean checkString(String s) {
    return s.contains("e");
  }
}


class LongWordChecker implements StringChecker{
  public boolean checkString(String s){
  return s.length() >= 5;
  }
}



public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(right, left);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> input = Arrays.asList("bat", "battery", "charter", "professor", "drunk");
    List<String> expected = Arrays.asList("battery", "charter", "professor");
    assertEquals(expected, ListExamples.filter(input, new ContainsE()));
  }

  @Test(timeout = 500)
  public void testMergeEmpty() {
    List<String> input1 = Arrays.asList(" ");
    List<String> input2 = Arrays.asList(" ");
    List<String> merged = ListExamples.merge(input1, input2);
    List<String> expected = Arrays.asList(" ");
    assertEquals(expected, merged);



  }

}
