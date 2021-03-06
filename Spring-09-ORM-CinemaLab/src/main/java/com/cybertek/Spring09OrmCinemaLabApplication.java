package com.cybertek;

import com.cybertek.repository.AccountRepository;
import com.cybertek.repository.CinemaRepository;
import com.cybertek.repository.MovieCinemaRepository;
import com.cybertek.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
public class Spring09OrmCinemaLabApplication {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieCinemaRepository movieCinemaRepository;
    @Autowired
    TicketRepository ticketRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmCinemaLabApplication.class, args);
    }

    @EventListener
    public void testAccount(ApplicationStartedEvent event){
//        System.out.println(accountRepository.fetchAdminUsers());
        System.out.println(cinemaRepository.distinctBySponsoredName());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
//        System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.fetchAllTicketsByUserJPQL(4l));
        System.out.println(ticketRepository.fetchAllTicketsWithRangeDates(LocalDateTime.now().minusDays(800), LocalDateTime.now()));
        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
    }
}
