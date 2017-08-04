package com.camhelp.repository;

import com.camhelp.dataobject.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jupiter
 * @description
 * @create 2017-08-04-11:30
 */
public interface GoodsRepository extends JpaRepository<Goods,Integer>{
}
