package com.example.demo.schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Schedule;
import com.example.demo.entity.ScheduleId;

public interface SchedulerRepository extends JpaRepository<Schedule, ScheduleId>{

}
