package com.example.demo.repository;

import com.example.demo.model.TicketFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketFlightRepository extends JpaRepository<TicketFlight, Long> {
}
