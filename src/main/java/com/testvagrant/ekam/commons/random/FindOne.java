package com.testvagrant.ekam.commons.random;

import java.util.List;
import java.util.Random;

public class FindOne {

  public static String inList(List<String> strings) {
    return strings.get(new Random().nextInt(strings.size()));
  }
}
