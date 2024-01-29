package repository;

import model.Company;
import model.ScheduledPickup;
import model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledPickupRepository extends JpaRepository<ScheduledPickup, Long>{
		
  ArrayList<ScheduledPickup> findByUser(User user);
  ArrayList<ScheduledPickup> findByCompany(Company company);
  ArrayList<ScheduledPickup> findByDate(LocalDate date);
  ArrayList<ScheduledPickup> findByScheduledTimeStart(LocalTime ScheduledTimeStart);
  ArrayList<ScheduledPickup> findByScheduledTimeEnd(LocalTime ScheduledTimeEnd);


}
