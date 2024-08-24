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


import com.cl.dao.ChayuejianliDao;
import com.cl.entity.ChayuejianliEntity;
import com.cl.service.ChayuejianliService;
import com.cl.entity.view.ChayuejianliView;

@Service("chayuejianliService")
public class ChayuejianliServiceImpl extends ServiceImpl<ChayuejianliDao, ChayuejianliEntity> implements ChayuejianliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChayuejianliEntity> page = this.selectPage(
                new Query<ChayuejianliEntity>(params).getPage(),
                new EntityWrapper<ChayuejianliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChayuejianliEntity> wrapper) {
		  Page<ChayuejianliView> page =new Query<ChayuejianliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChayuejianliView> selectListView(Wrapper<ChayuejianliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChayuejianliView selectView(Wrapper<ChayuejianliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
