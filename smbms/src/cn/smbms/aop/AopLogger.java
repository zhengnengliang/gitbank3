package cn.smbms.aop;



import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AopLogger {
	private static final Logger logger = Logger.getLogger(AopLogger.class);
	
	@Around("execution(* cn.smbms.service..*.*(..))")
	public Object around(ProceedingJoinPoint jp)throws Throwable{
		logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()
				+"方法。方法入参："+Arrays.toString(jp.getArgs()));
		try{
			Object result = jp.proceed();
			logger.info("执行"+jp.getTarget()+"的"+jp.getSignature().getName()
				+"方法。方法返回值："+result);
			return result;
		}catch(Exception e){
			logger.error(jp.getTarget()+"的"+jp.getSignature().getName()
					+"方法发生异常："+e);
			throw e;
		}finally{
			logger.info(jp.getTarget()+"的"+jp.getSignature().getName()
					+"方法结束执行。");
		}
	}
}

