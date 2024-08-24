package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.MianshijieguoEntity;
import com.cl.entity.view.MianshijieguoView;

import com.cl.service.MianshijieguoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 面试结果
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
@RestController
@RequestMapping("/mianshijieguo")
public class MianshijieguoController {
    @Autowired
    private MianshijieguoService mianshijieguoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MianshijieguoEntity mianshijieguo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			mianshijieguo.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			mianshijieguo.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MianshijieguoEntity> ew = new EntityWrapper<MianshijieguoEntity>();

		PageUtils page = mianshijieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshijieguo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MianshijieguoEntity mianshijieguo, 
		HttpServletRequest request){
        EntityWrapper<MianshijieguoEntity> ew = new EntityWrapper<MianshijieguoEntity>();

		PageUtils page = mianshijieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshijieguo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MianshijieguoEntity mianshijieguo){
       	EntityWrapper<MianshijieguoEntity> ew = new EntityWrapper<MianshijieguoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mianshijieguo, "mianshijieguo")); 
        return R.ok().put("data", mianshijieguoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MianshijieguoEntity mianshijieguo){
        EntityWrapper< MianshijieguoEntity> ew = new EntityWrapper< MianshijieguoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mianshijieguo, "mianshijieguo")); 
		MianshijieguoView mianshijieguoView =  mianshijieguoService.selectView(ew);
		return R.ok("查询面试结果成功").put("data", mianshijieguoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MianshijieguoEntity mianshijieguo = mianshijieguoService.selectById(id);
		mianshijieguo = mianshijieguoService.selectView(new EntityWrapper<MianshijieguoEntity>().eq("id", id));
        return R.ok().put("data", mianshijieguo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MianshijieguoEntity mianshijieguo = mianshijieguoService.selectById(id);
		mianshijieguo = mianshijieguoService.selectView(new EntityWrapper<MianshijieguoEntity>().eq("id", id));
        return R.ok().put("data", mianshijieguo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MianshijieguoEntity mianshijieguo, HttpServletRequest request){
    	mianshijieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mianshijieguo);
        mianshijieguoService.insert(mianshijieguo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MianshijieguoEntity mianshijieguo, HttpServletRequest request){
    	mianshijieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mianshijieguo);
        mianshijieguoService.insert(mianshijieguo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MianshijieguoEntity mianshijieguo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshijieguo);
        mianshijieguoService.updateById(mianshijieguo);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mianshijieguoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
