package com.kpsec.common;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kpsec.repository.AccountRepository;

@Component
@Aspect
public class LoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private AccountRepository accountRepository;

	@Pointcut("execution(* com.kpsec..*Controller.*(..))")
	public void loggerPointCut() {
	}

	@Around("loggerPointCut()")
	public Object methodLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		try {
			Object result = proceedingJoinPoint.proceed();

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			String controllerName = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
			String methodName = proceedingJoinPoint.getSignature().getName();

			Map<String, Object> params = new HashMap<>();

			try {
				params.put("controller", controllerName);
				params.put("method", methodName);
				params.put("params", getParams(request));
				params.put("log_time", new Date());
				params.put("request_uri", request.getRequestURI());
				params.put("http_method", request.getMethod());
			} catch (Exception e) {
				logger.error("LoggerAspect error", e);
			}
			logger.info("params : {}", params);
			
			return result;

		} catch (Throwable throwable) {
			throw throwable;
		}
	}
	
	
	private static JSONObject getParams(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			String replaceParam = param.replaceAll("\\.", "-");
			jsonObject.put(replaceParam, request.getParameter(param));
		}
		return jsonObject;
	}
}