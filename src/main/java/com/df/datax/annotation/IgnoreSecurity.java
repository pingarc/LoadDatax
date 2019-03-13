package com.df.datax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

  
/**        
 * Title:自定义注解     
 * Description: 标识是否忽略REST安全性检查
 * @author        
 * @created 2019年3月12
 */      
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME) 
@Documented
public @interface IgnoreSecurity {

}
