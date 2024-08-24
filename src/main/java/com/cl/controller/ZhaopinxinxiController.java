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

import com.cl.entity.ZhaopinxinxiEntity;
import com.cl.entity.view.ZhaopinxinxiView;

import com.cl.service.ZhaopinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 招聘信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
@RestController
@RequestMapping("/zhaopinxinxi")
public class ZhaopinxinxiController {
    @Autowired
    private ZhaopinxinxiService zhaopinxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			zhaopinxinxi.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();

		PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();

		PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhaopinxinxiEntity zhaopinxinxi){
       	EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhaopinxinxi, "zhaopinxinxi")); 
        return R.ok().put("data", zhaopinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaopinxinxiEntity zhaopinxinxi){
        EntityWrapper< ZhaopinxinxiEntity> ew = new EntityWrapper< ZhaopinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhaopinxinxi, "zhaopinxinxi")); 
		ZhaopinxinxiView zhaopinxinxiView =  zhaopinxinxiService.selectView(ew);
		return R.ok("查询招聘信息成功").put("data", zhaopinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhaopinxinxiEntity zhaopinxinxi = zhaopinxinxiService.selectById(id);
		zhaopinxinxi.setClicknum(zhaopinxinxi.getClicknum()+1);
		zhaopinxinxi.setClicktime(new Date());
		zhaopinxinxiService.updateById(zhaopinxinxi);
		zhaopinxinxi = zhaopinxinxiService.selectView(new EntityWrapper<ZhaopinxinxiEntity>().eq("id", id));
        return R.ok().put("data", zhaopinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhaopinxinxiEntity zhaopinxinxi = zhaopinxinxiService.selectById(id);
		zhaopinxinxi.setClicknum(zhaopinxinxi.getClicknum()+1);
		zhaopinxinxi.setClicktime(new Date());
		zhaopinxinxiService.updateById(zhaopinxinxi);
		zhaopinxinxi = zhaopinxinxiService.selectView(new EntityWrapper<ZhaopinxinxiEntity>().eq("id", id));
        return R.ok().put("data", zhaopinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
    	zhaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.insert(zhaopinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
    	zhaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.insert(zhaopinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.updateById(zhaopinxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhaopinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "gangweileixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "zhaopinxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ZhaopinxinxiEntity> zhaopinxinxiList = new ArrayList<ZhaopinxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                zhaopinxinxiList.addAll(zhaopinxinxiService.selectList(new EntityWrapper<ZhaopinxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));
        List<ZhaopinxinxiEntity> pageList = (List<ZhaopinxinxiEntity>)page.getList();
        if(zhaopinxinxiList.size()<limit) {
            int toAddNum = (limit-zhaopinxinxiList.size())<=pageList.size()?(limit-zhaopinxinxiList.size()):pageList.size();
            for(ZhaopinxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(ZhaopinxinxiEntity o2 : zhaopinxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    zhaopinxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(zhaopinxinxiList.size()>limit) {
            zhaopinxinxiList = zhaopinxinxiList.subList(0, limit);
        }
        page.setList(zhaopinxinxiList);
        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = zhaopinxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhaopinxinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhaopinxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhaopinxinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhaopinxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            zhaopinxinxi.setQiyezhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        int count = zhaopinxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));
        return R.ok().put("data", count);
    }


}
