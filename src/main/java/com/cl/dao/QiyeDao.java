package com.cl.dao;

import com.cl.entity.QiyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyeView;


/**
 * 企业
 * 
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface QiyeDao extends BaseMapper<QiyeEntity> {
	
	List<QiyeView> selectListView(@Param("ew") Wrapper<QiyeEntity> wrapper);

	List<QiyeView> selectListView(Pagination page,@Param("ew") Wrapper<QiyeEntity> wrapper);
	
	QiyeView selectView(@Param("ew") Wrapper<QiyeEntity> wrapper);
	

}
