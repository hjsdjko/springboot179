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


import com.cl.dao.QiyeDao;
import com.cl.entity.QiyeEntity;
import com.cl.service.QiyeService;
import com.cl.entity.view.QiyeView;

@Service("qiyeService")
public class QiyeServiceImpl extends ServiceImpl<QiyeDao, QiyeEntity> implements QiyeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiyeEntity> page = this.selectPage(
                new Query<QiyeEntity>(params).getPage(),
                new EntityWrapper<QiyeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiyeEntity> wrapper) {
		  Page<QiyeView> page =new Query<QiyeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QiyeView> selectListView(Wrapper<QiyeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiyeView selectView(Wrapper<QiyeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
