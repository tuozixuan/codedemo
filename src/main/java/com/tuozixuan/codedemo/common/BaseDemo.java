/*
 * 描述： Demo基类
 * 修改人： Alex
 * 修改时间： 2020年5月19日
 * 项目： codedemo
 */
package com.tuozixuan.codedemo.common;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Demo基类<br>
 * 
 * @author Alex
 * @version [版本号, 2020年5月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BaseDemo {
	
	public static void logTitle(String title) {
		System.out.println();
		System.out.println("【" + title + "】");
	}

	public static void log(String label, String...strings) {
		System.out.println(label + ": " + Arrays.stream(strings).collect(Collectors.joining(" ")));
	}
	
	public static void log(String label, Object...strings) {
		System.out.println(label + ": " + Arrays.stream(strings).map(Object::toString).collect(Collectors.joining(" ")));
	}
}
