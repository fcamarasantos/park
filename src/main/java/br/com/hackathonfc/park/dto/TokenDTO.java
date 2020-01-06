package br.com.hackathonfc.park.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenDTO {

    private String token;

    private String type;
}
