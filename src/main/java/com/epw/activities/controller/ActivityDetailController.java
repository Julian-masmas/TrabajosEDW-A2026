package com.epw.activities.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.epw.activities.dto.ActivityDetailResponse;
import com.epw.activities.dto.CreateActivityDetailRequest;
import com.epw.activities.entity.Activity;
import com.epw.activities.entity.ActivityDetail;
import com.epw.activities.exception.ResourceNotFoundException;
import com.epw.activities.repository.ActivityDetailRepository;
import com.epw.activities.repository.ActivityRepository;

@RestController
@RequestMapping("/api/activities/{activityId}/detail")
public class ActivityDetailController {
    private final ActivityRepository activityRepository;
    private final ActivityDetailRepository detailRepository;

    public ActivityDetailController(ActivityRepository activityRepository,
            ActivityDetailRepository detailRepository) {
        this.activityRepository = activityRepository;
        this.detailRepository = detailRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityDetailResponse create(@PathVariable Long activityId,
            @RequestBody CreateActivityDetailRequest request) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity " + activityId + " not found"));
        ActivityDetail detail = new ActivityDetail();
        detail.setPlace(request.getPlace());
        detail.setEstimatedMinutes(request.getEstimatedMinutes());
        detail.setPrivateNotes(request.getPrivateNotes());
        detail.setActivity(activity);
        ActivityDetail saved = detailRepository.save(detail);
        ActivityDetailResponse response = new ActivityDetailResponse();
        response.setId(saved.getId());
        response.setPlace(saved.getPlace());
        response.setEstimatedMinutes(saved.getEstimatedMinutes());
        response.setPrivateNotes(saved.getPrivateNotes());
        response.setActivityId(saved.getActivity().getId());
        return response;
    }
}