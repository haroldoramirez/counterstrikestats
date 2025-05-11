package br.com.haroldo.counterstrikestats.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroPadrao {
    private int code;
    private String message;
}
