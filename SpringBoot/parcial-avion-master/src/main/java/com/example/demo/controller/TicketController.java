package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.repository.ITicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final ITicketRepository ticketRepository;

    @GetMapping
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }
}
