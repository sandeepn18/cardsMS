package com.example.cardsms.Service;

import com.example.cardsms.DTO.CardsDTO;
import org.springframework.stereotype.Service;

@Service
public interface CardsService {

    String updateCard(CardsDTO cardsDTO);

    void createCard(String mobileNumber);

    CardsDTO fetchCard(String mobileNumber);

    void deleteCard(String mobileNumber);
}
