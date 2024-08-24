package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MianshijieguoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MianshijieguoView;


/**
 * 面试结果
 *
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface MianshijieguoService extends IService<MianshijieguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshijieguoView> selectListView(Wrapper<MianshijieguoEntity> wrapper);
   	
   	MianshijieguoView selectView(@Param("ew") Wrapper<MianshijieguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshijieguoEntity> wrapper);
   	

}

