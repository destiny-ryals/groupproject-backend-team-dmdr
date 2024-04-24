package com.DMDR.workout.dao;

import com.DMDR.workout.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoalDao extends JpaRepository<Goal, UUID> {
}
