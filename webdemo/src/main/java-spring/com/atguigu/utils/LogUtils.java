package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogUtils {
	/**
	 * 告诉SPRING每个方法都什么时候运行
	 */
	/**
	 * 在目标方法运行之前运行，前置通知。
	 * 还要写切入点表达式
	 * execution(访问权限符 返回值类型 方法签名)
	 */
//	@Before("execution(public int com.atguigu.aop.MyMathCalculator.add(int,int))")   这个是指定方法名，打星号可以表示所有方法
	@Before("execution(public int com.atguigu.aop.MyMathCalculator.*(int,int))")
	public static void logStart(JoinPoint joinPoint){
		//获取到目标方法运行时使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到方法签名
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("["+name+"]方法开始执行，用的参数列表["+ Arrays.asList(args)+"]");
	}
	
	/**
	 *在目标方法正常返回之后运行，返回通知
	 */
	@AfterReturning(value="execution(public int com.atguigu.aop.MyMathCalculator.*(int,int))",returning = "result")
	public static void logReturn(JoinPoint joinPoint,Object result){
		
		System.out.println("["+joinPoint.getSignature().getName()+"]方法正常执行完成，计算结果是["+result+"]");
	}
	
	/**
	 * 在目标方法抛出异常之后运行，异常通知
	 */
	@AfterThrowing(value="execution(public * com.atguigu.aop.MyMathCalculator.*(int,int))",throwing = "exception")
	public static void logException(JoinPoint joinPoint,Exception exception){
		System.out.println("["+joinPoint.getSignature().getName()+"]方法执行出现了异常，异常信息是["+exception+"]");
	}
	
	/**
	 * 在目标方法结束之后运行，后置通知
	 */
	@After("execution(public int com.atguigu.aop.MyMathCalculator.*(int,int))")
	public static void logEnd(){
		System.out.println("[xxx]方法最终结束了");
	}
}
