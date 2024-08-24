package com.cl.dao;

import com.cl.entity.ToudijianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ToudijianliView;


/**
 * 投递简历
 * 
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface ToudijianliDao extends BaseMapper<ToudijianliEntity> {
	
	List<ToudijianliView> selectListView(@Param("ew") Wrapper<ToudijianliEntity> wrapper);

	List<ToudijianliView> selectListView(Pagination page,@Param("ew") Wrapper<ToudijianliEntity> wrapper);
	
	ToudijianliView selectView(@Param("ew") Wrapper<ToudijianliEntity> wrapper);
	

}
