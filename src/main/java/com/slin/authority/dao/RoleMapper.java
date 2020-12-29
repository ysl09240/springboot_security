package com.slin.authority.dao;

import com.slin.authority.model.MenuBean;
import com.slin.authority.model.RoleBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 */
@Mapper
@Component(value ="roleMapper")
public interface RoleMapper {
    List<RoleBean> getRoleByMenuId(@Param(value="menuId")Long menuId);
}
