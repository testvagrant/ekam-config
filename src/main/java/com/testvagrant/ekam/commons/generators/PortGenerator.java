package com.testvagrant.ekam.commons.generators;

import java.io.IOException;
import java.net.ServerSocket;

public class PortGenerator {

  public static Integer randomOpenPortOnAllLocalInterfaces() {
    try (ServerSocket socket = new ServerSocket(0); ) {
      return socket.getLocalPort();
    } catch (IOException e) {
      throw new RuntimeException("no open ports found for bootstrap");
    }
  }
}
