package com.epw.activities.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epw.activities.dto.ActivityTagResponse;
import com.epw.activities.service.ActivityTagService;

@RestController
@RequestMapping("/api/activities/{activityId}/tags")
public class ActivityTagController {
    private final ActivityTagService activityTagService;

    public ActivityTagController(ActivityTagService activityTagService) {
        this.activityTagService = activityTagService;
    }

    @PostMapping("/{tagId}")
    public ActivityTagResponse assignTag(@PathVariable Long activityId, @PathVariable Long tagId) {
        return activityTagService.assignTag(activityId, tagId);
    }

    @DeleteMapping("/{tagId}")
    public ActivityTagResponse removeTag(@PathVariable Long activityId, @PathVariable Long tagId) {
        return activityTagService.removeTag(activityId, tagId);
    }
}