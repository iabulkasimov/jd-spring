package com.cybertek.repository;

import com.cybertek.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket>findAllByUserEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime date1, LocalDateTime date2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.user.id = ?1")
    List<Ticket> fetchAllTicketsByUserJPQL(Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> fetchAllTicketsWithRangeDates(LocalDateTime start, LocalDateTime end);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "select(*)from ticket where user_account_id=?1",nativeQuery = true)
    Integer countTicketByUser(Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select count(*)from ticket where user_account_id = ?1 and date_time between ?2 and ?3",nativeQuery = true)
    Integer countTicketByUserInDateRanges(Long userId, LocalDateTime start, LocalDateTime end);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "select distinct (m.name) from ticket JOIN movie_cinema mc on mc.id=ticket.movie_cinema_id join movie m on mc.movie_id=m.id",nativeQuery = true)
    List<String>retrieveAllDistinctMovieNames();

    //Write a native query to find all tickets by user email
    @Query(value = "select *from ticket join user_account ua on ticket.user_account_id=ua.email=?1",nativeQuery = true)
    List<Ticket>retrieveAllByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value="select * from ticket",nativeQuery = true)
    List<Ticket>retrieveAll();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT * FROM ticket JOIN user_account ua ON ticket.user_account_id=ua.id " +
            " JOIN account_details ad ON ad.id=ua.account_details_id " +
            " JOIN movie_cinema mc ON ticket.movie_cinema_id=mc.id " +
            " JOIN movie m ON mc.movie_id = m.id " +
            " WHERE ua.username ILIKE concat('%',?1,'%') OR ad.name ILIKE concat('%',?1,'%') or m.name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String searchCriteria);

}
