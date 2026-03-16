package com.epw.activities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epw.activities.entity.ActivityDetail;

public interface ActivityDetailRepository extends JpaRepository<ActivityDetail, Long> {
}