package com.example.auction_platform.controllers;

import com.example.auction_platform.models.Bulletin;
import com.example.auction_platform.services.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoardControllerTests {

    @Mock
    private BoardService boardService;

    @InjectMocks
    private BoardController boardController;

    @Test
    void getAll_ReturnsListOfBulletins() {
        List<Bulletin> bulletins = Arrays.asList(
                new Bulletin("bulletin 1", "", 0, 0, "", new byte[0]),
                new Bulletin("bulletin 2", "", 0, 0, "", new byte[0])
        );

        when(boardService.getAll()).thenReturn(bulletins);

        List<Bulletin> result = boardController.getAll();

        assertEquals(bulletins, result);
        verify(boardService).getAll();
    }

    @Test
    void getAllBySort_ReturnsListOfBulletinsSortedByNameAscending() {
        List<Bulletin> bulletins = Arrays.asList(
                new Bulletin("bulletin 1", "", 0, 0, "", new byte[0]),
                new Bulletin("bulletin 2", "", 0, 0, "", new byte[0])
        );

        when(boardService.getAllBySort("name", "asc")).thenReturn(bulletins);

        List<Bulletin> result = boardController.getAllProducts("name", "asc");

        assertEquals(bulletins, result);
        verify(boardService).getAllBySort("name", "asc");
    }

    @Test
    void getAllActive_ReturnsListOfActiveBulletins() {
        List<Bulletin> bulletins = Arrays.asList(
                new Bulletin("bulletin 1", "", 0, 0, "", new byte[0]),
                new Bulletin("bulletin 2", "", 0, 0, "", new byte[0])
        );

        when(boardService.getAllByIsActive("true")).thenReturn(bulletins);

        List<Bulletin> result = boardController.getAllActive("true");

        assertEquals(bulletins, result);
        verify(boardService).getAllByIsActive("true");
    }

    @Test
    void get_ReturnsBulletin() {
        Bulletin bulletin = new Bulletin("bulletin 1", "", 0, 0, "", new byte[0]);
        when(boardService.get("bulletin 1")).thenReturn(bulletin);
        Bulletin result = boardController.getProduct("bulletin 1");

        assertEquals(bulletin, result);
        verify(boardService).get("bulletin 1");
    }

}
