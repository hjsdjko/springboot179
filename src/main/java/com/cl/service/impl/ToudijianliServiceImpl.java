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


import com.cl.dao.ToudijianliDao;
import com.cl.entity.ToudijianliEntity;
import com.cl.service.ToudijianliService;
import com.cl.entity.view.ToudijianliView;

@Service("toudijianliService")
public class ToudijianliServiceImpl extends ServiceImpl<ToudijianliDao, ToudijianliEntity> implements ToudijianliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ToudijianliEntity> page = this.selectPage(
                new Query<ToudijianliEntity>(params).getPage(),
                new EntityWrapper<ToudijianliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ToudijianliEntity> wrapper) {
		  Page<ToudijianliView> page =new Query<ToudijianliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ToudijianliView> selectListView(Wrapper<ToudijianliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ToudijianliView selectView(Wrapper<ToudijianliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
