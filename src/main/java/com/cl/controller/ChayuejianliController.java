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

import com.cl.entity.ChayuejianliEntity;
import com.cl.entity.view.ChayuejianliView;

import com.cl.service.ChayuejianliService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 查阅简历
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
@RestController
@RequestMapping("/chayuejianli")
public class ChayuejianliController {
    @Autowired
    private ChayuejianliService chayuejianliService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChayuejianliEntity chayuejianli,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			chayuejianli.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			chayuejianli.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChayuejianliEntity> ew = new EntityWrapper<ChayuejianliEntity>();

		PageUtils page = chayuejianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chayuejianli), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChayuejianliEntity chayuejianli, 
		HttpServletRequest request){
        EntityWrapper<ChayuejianliEntity> ew = new EntityWrapper<ChayuejianliEntity>();

		PageUtils page = chayuejianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chayuejianli), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChayuejianliEntity chayuejianli){
       	EntityWrapper<ChayuejianliEntity> ew = new EntityWrapper<ChayuejianliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chayuejianli, "chayuejianli")); 
        return R.ok().put("data", chayuejianliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChayuejianliEntity chayuejianli){
        EntityWrapper< ChayuejianliEntity> ew = new EntityWrapper< ChayuejianliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chayuejianli, "chayuejianli")); 
		ChayuejianliView chayuejianliView =  chayuejianliService.selectView(ew);
		return R.ok("查询查阅简历成功").put("data", chayuejianliView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChayuejianliEntity chayuejianli = chayuejianliService.selectById(id);
		chayuejianli = chayuejianliService.selectView(new EntityWrapper<ChayuejianliEntity>().eq("id", id));
        return R.ok().put("data", chayuejianli);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChayuejianliEntity chayuejianli = chayuejianliService.selectById(id);
		chayuejianli = chayuejianliService.selectView(new EntityWrapper<ChayuejianliEntity>().eq("id", id));
        return R.ok().put("data", chayuejianli);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChayuejianliEntity chayuejianli, HttpServletRequest request){
    	chayuejianli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chayuejianli);
        chayuejianliService.insert(chayuejianli);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChayuejianliEntity chayuejianli, HttpServletRequest request){
    	chayuejianli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chayuejianli);
        chayuejianliService.insert(chayuejianli);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChayuejianliEntity chayuejianli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chayuejianli);
        chayuejianliService.updateById(chayuejianli);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chayuejianliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
