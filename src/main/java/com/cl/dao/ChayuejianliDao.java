package com.cl.dao;

import com.cl.entity.ChayuejianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChayuejianliView;


/**
 * 查阅简历
 * 
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface ChayuejianliDao extends BaseMapper<ChayuejianliEntity> {
	
	List<ChayuejianliView> selectListView(@Param("ew") Wrapper<ChayuejianliEntity> wrapper);

	List<ChayuejianliView> selectListView(Pagination page,@Param("ew") Wrapper<ChayuejianliEntity> wrapper);
	
	ChayuejianliView selectView(@Param("ew") Wrapper<ChayuejianliEntity> wrapper);
	

}
