package com.cl.entity.view;

import com.cl.entity.MianshijieguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 面试结果
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-25 20:51:01
 */
@TableName("mianshijieguo")
public class MianshijieguoView  extends MianshijieguoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MianshijieguoView(){
	}
 
 	public MianshijieguoView(MianshijieguoEntity mianshijieguoEntity){
 	try {
			BeanUtils.copyProperties(this, mianshijieguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
