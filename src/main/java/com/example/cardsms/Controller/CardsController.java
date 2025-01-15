package com.example.cardsms.Controller;

import com.example.cardsms.DTO.CardsDTO;
import com.example.cardsms.DTO.CardsInfoDto;
import com.example.cardsms.DTO.ResponseDTO;
import com.example.cardsms.Service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CardsController {
    @Autowired
    private CardsService cardsService;
    @Value("${build.version}")
    private String buildInfo;

    @Autowired
    private CardsInfoDto cardsInfoDto;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCard(@RequestParam String mobileNumber) {
        cardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO("201", "Card created successfully"));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDTO> fetchCard(@RequestParam String mobileNumber) {
        CardsDTO cardsDto = cardsService.fetchCard(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardsDto);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCard(@RequestBody CardsDTO cardsDTO) {
        cardsService.updateCard(cardsDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Card updated successfully");

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCard(String mobileNumber)  {
        cardsService.deleteCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.GONE)
                .body("Card deleted successfully");

    }

    @GetMapping("/build-info")
    public ResponseEntity<String> buildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildInfo);
    }

    @GetMapping("/contact-info")
    public ResponseEntity<CardsInfoDto> getContactDetails(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardsInfoDto);
    }


}
