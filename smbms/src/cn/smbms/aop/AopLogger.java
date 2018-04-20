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
		logger.info("����"+jp.getTarget()+"��"+jp.getSignature().getName()
				+"������������Σ�"+Arrays.toString(jp.getArgs()));
		try{
			Object result = jp.proceed();
			logger.info("ִ��"+jp.getTarget()+"��"+jp.getSignature().getName()
				+"��������������ֵ��"+result);
			return result;
		}catch(Exception e){
			logger.error(jp.getTarget()+"��"+jp.getSignature().getName()
					+"���������쳣��"+e);
			throw e;
		}finally{
			logger.info(jp.getTarget()+"��"+jp.getSignature().getName()
					+"��������ִ�С�");
		}
	}
}

