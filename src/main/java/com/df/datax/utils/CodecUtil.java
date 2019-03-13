package com.df.datax.utils;

import java.util.UUID;

  
/**        
 * Title: 生成UUID    
 * @author liangdf
 * @created 2019年3月12 下午5:13:16
 */      
public class CodecUtil {
	
	public static String createUUID(){
		return UUID.randomUUID().toString();
	}
}
