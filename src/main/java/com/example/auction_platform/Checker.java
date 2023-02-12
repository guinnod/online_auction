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

import java.util.List;

@Component
@RequiredArgsConstructor
public class Checker {
    private final BulletinRepository bulletinRepository;
    private final SellRepository sellRepository;
    Logger sendToEmail = LoggerFactory.getLogger(Checker.class);

    @Scheduled(fixedDelay = 5000, initialDelay = 1000)
    public void runEverySecond() {
        List<Bulletin> bulletins = bulletinRepository.findAllByIsActive(true);
        for (Bulletin bulletin: bulletins) {
            if (System.currentTimeMillis() > bulletin.getEndTime()) {
                try {
                    Sell sell = sellRepository.findByProductName(bulletin.getName());
                    sendToEmail.info("To: " + bulletin.getAuthor() + " Text: User " + sell.getEmail() + " has bought " + bulletin.getName() + ".");
                    sendToEmail.info("To: " + sell.getEmail() + " Text: Congratulations! You have bought " + bulletin.getName() + ".");
                    bulletin.setActive(false);
                    bulletinRepository.save(bulletin);
                } catch (Exception ignored) {

                } finally {
                    bulletin.setActive(false);
                    bulletinRepository.save(bulletin);
                }
            }
        }
    }
}
