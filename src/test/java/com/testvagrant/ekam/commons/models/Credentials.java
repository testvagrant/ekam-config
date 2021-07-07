package com.testvagrant.ekam.commons.models;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
  private String password;
  private String username;
}
