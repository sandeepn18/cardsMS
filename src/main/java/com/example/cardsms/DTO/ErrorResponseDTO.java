package com.example.cardsms.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {

    private String apiPath;
    private String message;
    private HttpStatus errorCode;
    private LocalDateTime localDateTime;

}
