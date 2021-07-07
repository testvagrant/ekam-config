package com.testvagrant.ekam.commons.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RepetitiveStringGenerator {

  public List<String> generate(String... strings) {
    return generate(100, true, strings);
  }

  public List<String> generate(int copies, String... strings) {
    return generate(copies, true, strings);
  }

  public List<String> generate(int copies, boolean shuffle, String... strings) {
    LinkedList<String> randomStrings = new LinkedList<>();
    Arrays.stream(strings)
        .forEach(
            string -> {
              randomStrings.addAll(Collections.nCopies(copies, string));
            });
    if (shuffle) Collections.shuffle(randomStrings);
    return randomStrings;
  }
}
