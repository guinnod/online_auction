package com.example.auction_platform;

import com.example.auction_platform.models.Bulletin;
import com.example.auction_platform.models.Sell;
import com.example.auction_platform.repositories.BulletinRepository;
import com.example.auction_platform.repositories.SellRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

@Component
@RequiredArgsConstructor
public class Checker {
    private final BulletinRepository bulletinRepository;
    private final SellRepository sellRepository;
    Logger logger = LoggerFactory.getLogger(Checker.class);

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void runEverySecond() {
        List<Bulletin> bulletins = bulletinRepository.findAllByIsActive(true);
        for (Bulletin bulletin: bulletins) {
            if (System.currentTimeMillis() > bulletin.getEndTime()) {
//                Optional<Sell> sell = sellRepository.findById("");
//                logger.warn(sell.get().getEmail() + " bought " + sell.get().getProductName() + "!");
                bulletin.setActive(false);
                bulletinRepository.save(bulletin);
            }
        }
    }
}