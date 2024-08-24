package com.cl.dao;

import com.cl.entity.MianshijieguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MianshijieguoView;


/**
 * 面试结果
 * 
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface MianshijieguoDao extends BaseMapper<MianshijieguoEntity> {
	
	List<MianshijieguoView> selectListView(@Param("ew") Wrapper<MianshijieguoEntity> wrapper);

	List<MianshijieguoView> selectListView(Pagination page,@Param("ew") Wrapper<MianshijieguoEntity> wrapper);
	
	MianshijieguoView selectView(@Param("ew") Wrapper<MianshijieguoEntity> wrapper);
	

}
