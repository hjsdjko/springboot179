package com.cl.dao;

import com.cl.entity.MianshitongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MianshitongzhiView;


/**
 * 面试通知
 * 
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface MianshitongzhiDao extends BaseMapper<MianshitongzhiEntity> {
	
	List<MianshitongzhiView> selectListView(@Param("ew") Wrapper<MianshitongzhiEntity> wrapper);

	List<MianshitongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<MianshitongzhiEntity> wrapper);
	
	MianshitongzhiView selectView(@Param("ew") Wrapper<MianshitongzhiEntity> wrapper);
	

}
