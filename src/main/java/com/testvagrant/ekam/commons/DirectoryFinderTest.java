package com.testvagrant.ekam.commons;

import com.testvagrant.ekam.commons.io.DirectoryFinder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;


public class DirectoryFinderTest {

  @Test
  public void findDirectoryAnyWhere() {
    Optional<String> data_sets_main = new DirectoryFinder().find("data_sets_main");
    Assert.assertFalse(data_sets_main.isPresent());
    System.out.println(data_sets_main.get());
  }
}
