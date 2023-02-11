package com.example.auction_platform;

import com.example.auction_platform.models.Bulletin;
import com.example.auction_platform.models.Sell;
import com.example.auction_platform.repositories.BulletinRepository;
import com.example.auction_platform.repositories.SellRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

@RequiredArgsConstructor
public class Checker extends TimerTask {
    private final BulletinRepository bulletinRepository;
    private final SellRepository sellRepository;
    Logger logger = LoggerFactory.getLogger(Checker.class);

    @Override
    public void run() {
        List<Bulletin> bulletins = bulletinRepository.findAllByIsActive(true);
        for (Bulletin bulletin: bulletins) {
            if (System.currentTimeMillis() < bulletin.getEndTime()) {
                Optional<Sell> sell = sellRepository.findById("");
                logger.warn(sell.get().getEmail() + " bought " + sell.get().getProductName() + "!");
                bulletin.setActive(false);
            }
        }
    }
}
