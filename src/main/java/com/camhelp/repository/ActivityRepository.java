package com.camhelp.repository;

import com.camhelp.dataobject.Activity;
import com.camhelp.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jupiter on 2017/8/2.
 */
public  interface ActivityRepository extends JpaRepository<Activity,Integer>{

}
