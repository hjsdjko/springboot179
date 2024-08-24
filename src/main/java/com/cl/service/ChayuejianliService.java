package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChayuejianliEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChayuejianliView;


/**
 * 查阅简历
 *
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface ChayuejianliService extends IService<ChayuejianliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChayuejianliView> selectListView(Wrapper<ChayuejianliEntity> wrapper);
   	
   	ChayuejianliView selectView(@Param("ew") Wrapper<ChayuejianliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChayuejianliEntity> wrapper);
   	

}

