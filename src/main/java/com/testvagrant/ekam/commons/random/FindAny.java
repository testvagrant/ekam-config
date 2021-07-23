package com.testvagrant.ekam.commons.random;

import java.util.List;
import java.util.Random;

public class FindAny {
  public static <T> T inList(List<T> list) {
    return list.get(new Random().nextInt(list.size()));
  }
}
