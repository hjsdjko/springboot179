package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ToudijianliEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ToudijianliView;


/**
 * 投递简历
 *
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface ToudijianliService extends IService<ToudijianliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ToudijianliView> selectListView(Wrapper<ToudijianliEntity> wrapper);
   	
   	ToudijianliView selectView(@Param("ew") Wrapper<ToudijianliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ToudijianliEntity> wrapper);
   	

}

