package com.camhelp.service.impl;

import com.camhelp.dataobject.Activity;
import com.camhelp.repository.ActivityRepository;
import com.camhelp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Jupiter on 2017/8/2.
 */

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    @Transactional
    @Override
    public void addActivity(Activity activity) {
        activityRepository.save(activity);
    }
}
