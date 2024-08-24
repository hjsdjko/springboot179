package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QiyeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyeView;


/**
 * 企业
 *
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface QiyeService extends IService<QiyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiyeView> selectListView(Wrapper<QiyeEntity> wrapper);
   	
   	QiyeView selectView(@Param("ew") Wrapper<QiyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiyeEntity> wrapper);
   	

}

