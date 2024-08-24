package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.MianshitongzhiDao;
import com.cl.entity.MianshitongzhiEntity;
import com.cl.service.MianshitongzhiService;
import com.cl.entity.view.MianshitongzhiView;

@Service("mianshitongzhiService")
public class MianshitongzhiServiceImpl extends ServiceImpl<MianshitongzhiDao, MianshitongzhiEntity> implements MianshitongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshitongzhiEntity> page = this.selectPage(
                new Query<MianshitongzhiEntity>(params).getPage(),
                new EntityWrapper<MianshitongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshitongzhiEntity> wrapper) {
		  Page<MianshitongzhiView> page =new Query<MianshitongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MianshitongzhiView> selectListView(Wrapper<MianshitongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshitongzhiView selectView(Wrapper<MianshitongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
