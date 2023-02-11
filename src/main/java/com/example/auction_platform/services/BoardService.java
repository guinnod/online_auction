package com.example.auction_platform.services;

import com.example.auction_platform.models.Bulletin;
import com.example.auction_platform.repositories.BulletinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abzal Slamkozha
 */

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BulletinRepository bulletinRepository;

    public List<Bulletin> getAllByIsActive(String isActive) {
        return bulletinRepository.findAllByIsActive(isActive.equals("true"));
    }

    public List<Bulletin> getAll() {
        return bulletinRepository.findAll();
    }

    public List<Bulletin> getAllBySort(String sortBy, String order) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equals("desc")) {
            direction = Sort.Direction.DESC;
        }
        return bulletinRepository.findAll(Sort.by(direction, sortBy));
    }

    public Bulletin get(String name) {
        return bulletinRepository.findByName(name);
    }
}
