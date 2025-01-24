package com.example.cardsms.Service.impl;

import com.example.cardsms.Constants.CardsConstants;
import com.example.cardsms.DTO.CardsDTO;
import com.example.cardsms.Entity.Cards;
import com.example.cardsms.Exception.CardAlreadyExistsException;
import com.example.cardsms.Exception.ResponseNotFoundException;
import com.example.cardsms.Mapper.CardsMapper;
import com.example.cardsms.Service.CardsService;
import com.example.cardsms.repo.CardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.smartcardio.CardNotPresentException;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardsService {

    @Autowired
    private CardsRepo cardsRepo;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> cards = cardsRepo.findByMobileNumber(mobileNumber);
        if (cards.isPresent()) {
            throw new CardAlreadyExistsException("card already exits");
        }
        cardsRepo.save(createNewCard(mobileNumber));

    }

    @Override
    public CardsDTO fetchCard(String mobileNumber) {
        Cards fetchedCard = cardsRepo.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResponseNotFoundException("Card", "Mobile Number", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(fetchedCard, new CardsDTO());
    }

    @Override
    public void deleteCard(String mobileNumber) {
        Cards fetchedCard = cardsRepo.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResponseNotFoundException("Card", "MobileNumber", mobileNumber)
        );

        cardsRepo.delete(fetchedCard);

    }

    private Cards createNewCard(String mobileNumber) {
        Cards cards = new Cards();
        long randomValue = 1000000000L + (long) (Math.random() * 9000000000L);
        cards.setCardNumber(String.valueOf(randomValue));
        cards.setMobileNumber(mobileNumber);
        cards.setCardType(CardsConstants.CREDIT_CARD);
        cards.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        cards.setAmountUsed(0);
        cards.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return cards;
    }
    @Override
    public String updateCard(CardsDTO cardsDTO) {
        Cards cards = cardsRepo.findByMobileNumber(cardsDTO.getMobileNumber()).orElseThrow(
                ()-> new ResponseNotFoundException("Card", "Mobile Number", cardsDTO.getMobileNumber())
        );
        CardsMapper.mapToCards(cardsDTO, cards);
        cardsRepo.save(cards);
        return "updated";
    }



}
