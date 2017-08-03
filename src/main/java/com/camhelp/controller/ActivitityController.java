package com.camhelp.controller;

import com.camhelp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jupiter on 2017/8/2.
 */
@RestController
@RequestMapping("/activity")
public class ActivitityController {

    @Autowired
    ActivityService activityService;

    @RequestMapping("publish")
    public void PubActivity(){

    }

}
