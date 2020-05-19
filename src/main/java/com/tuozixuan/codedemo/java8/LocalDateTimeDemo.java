/*
 * 描述： jdk 8中日期时间类使用示例
 * 修改人： Alex
 * 修改时间： 2020年5月19日
 * 项目： codedemo
 */
package com.tuozixuan.codedemo.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import com.tuozixuan.codedemo.common.BaseDemo;

/**
 * jdk 8中日期时间类使用示例<br>
 * 
 * @author Alex
 * @version [版本号, 2020年5月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LocalDateTimeDemo extends BaseDemo {
	
	public static void main(String[] args) {
		
		String dateTimePatternStr = "yyyy-MM-dd HH:mm:ss";
		String datePatternStr = "yyyy-MM-dd";
		
		// 创建日期时间模式
		DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern(dateTimePatternStr);
		// 创建日期模式
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern(datePatternStr);
		
		// 获取当前日期
		LocalDate nowDate = LocalDate.now();
		log("获取当前日期", nowDate.format(datePattern));
		
		// 获取指定年月日的日期
		log("获取指定年月日的日期", LocalDate.of(2020, 6, 20).format(datePattern));
		log("获取指定年及一年中天数的日期", LocalDate.ofYearDay(2020, 300).format(datePattern));
		
		// 获取当前日期时间
		LocalDateTime nowDateTime = LocalDateTime.now();
		log("获取当前日期时间", nowDateTime.format(dateTimePattern));
		// 获取指定年月日时分秒的日期时间
		log("获取指定年月日时分秒的日期时间", LocalDateTime.of(2020, 05, 20, 12, 25, 33).format(dateTimePattern));
		
		// 获取天数、月数、年等信息
		logTitle("获取天数、月数、年等信息");
		log("获取天数", nowDate.getDayOfMonth());
		log("获取一周中的天数", nowDate.getDayOfWeek().getValue());
		log("获取一年中的天数", nowDate.getDayOfYear());
		log("获取月", nowDate.getMonthValue());
		log("获取月", nowDate.getMonth().getValue());
		log("获取年", nowDate.getYear());
		
		// 对日期进行增加天数、月数、周数、年数操作
		logTitle("对日期进行增加天数、月数、周数、年数操作");
		log("对日期进行增加天数", nowDate.plusDays(1).format(datePattern));
		log("对日期进行增加月数", nowDate.plusMonths(1).format(datePattern));
		log("对日期进行增加周数", nowDate.plusWeeks(1).format(datePattern));
		log("对日期进行增加年数", nowDate.plusYears(1).format(datePattern));
		
		// 对日期进行减少天数、月数、周数、年数操作
		logTitle("对日期进行减少天数、月数、周数、年数操作");
		log("对日期进行减少天数", nowDate.minusDays(1).format(datePattern));
		log("对日期进行减少月数", nowDate.minusMonths(1).format(datePattern));
		log("对日期进行减少周数", nowDate.minusWeeks(1).format(datePattern));
		log("对日期进行减少年数", nowDate.minusYears(1).format(datePattern));
		
		// 在现有日期上指定天数、月数、年数获取一个新的日期
		logTitle("在现有日期上指定天数、月数、年数获取一个新的日期");
		log("在现有日期上指定天数获取一个新的日期", nowDate.withDayOfMonth(20).format(datePattern));
		log("在现有日期上指定月数获取一个新的日期", nowDate.withMonth(6).format(datePattern));
		log("在现有日期上指定年数获取一个新的日期", nowDate.withYear(2025).format(datePattern));
		
		log("把LocalDate转成LocalDateTime，时分秒使用00:00:00", nowDate.atStartOfDay().format(dateTimePattern));
		
		log("当月第一天的日期", nowDate.with(TemporalAdjusters.firstDayOfMonth()).format(datePattern));
		log("当月最后一天的日期", nowDate.with(TemporalAdjusters.lastDayOfMonth()).format(datePattern));
		log("下个月第一天的日期", nowDate.with(TemporalAdjusters.firstDayOfNextMonth()).format(datePattern));
		
		// 日期所在月的总的天数
		log("日期所在月的总的天数", nowDate.lengthOfMonth());
		// 日期所在年的总的天数
		log("日期所在年的总的天数", nowDate.lengthOfYear());
		
	}

}
