package com.slin.authority.dao;

import com.slin.authority.model.MenuBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 */
@Mapper
@Component(value ="menuMapper")
public interface MenuMapper {
    List<MenuBean> getAllMenu();
}
