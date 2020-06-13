/*
 * 描述： jdk 8 Stream 使用示例
 * 修改人：Alex
 * 修改时间： 2020年5月19日
 * 项目： codedemo
 */
package com.tuozixuan.codedemo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tuozixuan.codedemo.common.BaseDemo;

/**
 * jdk 8 Stream 使用示例<br>
 * 
 * @author Alex
 * @version [版本号, 2020年5月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StreamDemo extends BaseDemo {

	public static void main(String[] args) {
		
		// 数组转为Stream
		String[] items = new String[] {"one", "two", "three"};
		Stream stream1 = Arrays.stream(items);
		Stream stream2 = Stream.of(items);
		Stream stream3 = Stream.of("one", "two", "three");
		
		// Stream转为数组
		Stream.of("one", "two", "three").toArray();
		
		// 根据条件过滤
		List<String> itemList = Arrays.asList("one", "two", "three");
		itemList.stream().filter(item -> "one".equals(item)).collect(Collectors.toList());
		
		log("是否至少存在一个元素匹配指定的条件",  itemList.stream().anyMatch(item -> "one".equals(item)));
		log("是否所有元素都满足指定的条件", itemList.stream().allMatch(item -> item.length() < 10));
		log("是否所有元素都不匹配指定的条件", itemList.stream().noneMatch(item -> "one1".equals(item)));
		log("计数", itemList.stream().count());
		log("从中获取任何一个元素", itemList.stream().findAny().orElse(""));
		log("从中获取第一个元素", itemList.stream().findFirst().orElse(""));
		log("限制元素的个数", itemList.stream().limit(2));
		
		logTitle("reduce操作");
		log("字符串连接", Stream.of("one", "two", "three").reduce("", String::concat));
		log("求最小值", Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min));
		log("求最大值", Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MIN_VALUE, Double::max));
		log("求和", Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));
		log("求和", Stream.of(1, 2, 3, 4).reduce(Integer::sum).get());
		
	}
}
