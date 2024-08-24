package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhaopinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaopinxinxiView;


/**
 * 招聘信息
 *
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
public interface ZhaopinxinxiService extends IService<ZhaopinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaopinxinxiView> selectListView(Wrapper<ZhaopinxinxiEntity> wrapper);
   	
   	ZhaopinxinxiView selectView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaopinxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZhaopinxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZhaopinxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZhaopinxinxiEntity> wrapper);



}

