package com.godisultimate.lms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class CommonMethod {
	/*
	 * @Autowired private PropertiesService propertiesService;
	 * 
	 * private static String[] unitsMap = { "Zero", "One", "Two", "Three", "Four",
	 * "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
	 * "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
	 * "Nineteen" }; private static String[] tensMap = { "Zero", "Ten", "Twenty",
	 * "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	 * 
	 * public static ArrayList<RecurringOrder>
	 * getListRecurringOrderFromObject(Object object) { ObjectMapper mapper = new
	 * ObjectMapper(); return mapper.convertValue(object, new
	 * TypeReference<List<RecurringOrder>>() { }); }
	 * 
	 * public static ArrayList<TrackingOfCanReceivedPojo>
	 * getListRecurringOrderFromObject1(Object object) { ObjectMapper mapper = new
	 * ObjectMapper(); return mapper.convertValue(object, new
	 * TypeReference<List<TrackingOfCanReceivedPojo>>() { }); }
	 * 
	 * @SuppressWarnings({ "unchecked", "rawtypes" }) public static Object
	 * getEntiryFromObject(Class classObject, Object object) { ObjectMapper mapper =
	 * new ObjectMapper(); System.out.println("Piyush Check object.getClass() " +
	 * classObject); return mapper.convertValue(object, classObject); }
	 * 
	 * @SuppressWarnings("unchecked") public static Map<String, Object>
	 * getMapFromObject(Object object) { ObjectMapper oMapper = new ObjectMapper();
	 * return oMapper.convertValue(object, Map.class); }
	 * 
	 * public static List<Map<String, Object>> getArrayListFromObject(Object object)
	 * { ObjectMapper mapper = new ObjectMapper(); return
	 * mapper.convertValue(object, new TypeReference<List<Map<String, Object>>>() {
	 * }); }
	 * 
	 * public static List<Long> getArrayListOfIdsFromObject(Object object) {
	 * ObjectMapper mapper = new ObjectMapper(); return mapper.convertValue(object,
	 * new TypeReference<List<Long>>() { }); }
	 * 
	 * public static List<HashMap<String, Object>> getListOfHashMapfromObject(Object
	 * object) { ObjectMapper mapper = new ObjectMapper(); return
	 * mapper.convertValue(object, new TypeReference<List<HashMap<String,
	 * Object>>>() { }); }
	 * 
	 * public static ArrayList<AddressEntity> getListAddressEntityFromObject(Object
	 * object) { ObjectMapper mapper = new ObjectMapper(); return
	 * mapper.convertValue(object, new TypeReference<List<AddressEntity>>() { }); }
	 * 
	 * public static String getCurrentTimeUsingCalendar() { Calendar cal =
	 * Calendar.getInstance(); Date date = cal.getTime(); DateFormat dateFormat =
	 * new SimpleDateFormat(ApplicationConstant.date_formate_yyyy_MM_dd_HH_mm_ss);
	 * dateFormat.setTimeZone(TimeZone.getTimeZone("IST")); String formattedDate =
	 * dateFormat.format(date); return formattedDate; }
	 * 
	 * public static Date getCurrentDateAndTimeUsingCalendar() throws ParseException
	 * { Calendar cal = Calendar.getInstance(); Date date = cal.getTime();
	 * DateFormat dateFormat = new
	 * SimpleDateFormat(ApplicationConstant.date_formate_yyyy_MM_dd_HH_mm_ss);
	 * dateFormat.setTimeZone(TimeZone.getTimeZone("IST")); String formattedDate =
	 * dateFormat.format(date); return dateFormat.parse(formattedDate); // return
	 * Calendar.getInstance().getTime(); }
	 * 
	 * public static Date parseIntoDateFormate_yyyy_MM_dd(String dateString) {
	 * DateFormat dateFormat = new
	 * SimpleDateFormat(ApplicationConstant.date_formate_yyyy_MM_dd); try { return
	 * dateFormat.parse(dateString); } catch (ParseException e) {
	 * e.printStackTrace(); return null; } }
	 * 
	 * public static LocalDate parseIntoLocalDateFormate_yyyy_MM_dd(String
	 * dateString) throws ApplicationExceptions { DateTimeFormatter
	 * dateTimeFormatter =
	 * DateTimeFormatter.ofPattern(ApplicationConstant.date_formate_yyyy_MM_dd); try
	 * { return LocalDate.parse(dateString, dateTimeFormatter); } catch (Exception
	 * e) { e.printStackTrace(); throw new
	 * ApplicationExceptions("Please Check appropriate Date formate"); } }
	 * 
	 *//**
		 * 
		 * @param dateString : any format 08-12-2019,08-Dec-2019,08-12-19
		 * @param formatter  : any format dd-MM-yyyy,dd-MMM-yyyy,dd-MM-yy etc
		 * @return localDate : 2019-12-08
		 * @throws ApplicationExceptions
		 */
	/*
	 * public static LocalDate parseIntoLocalDate(String dateString, String
	 * formatter) throws DateTimeParseException { DateTimeFormatter date_formatter =
	 * DateTimeFormatter.ofPattern(formatter); LocalDate localDate =
	 * LocalDate.parse(dateString, date_formatter); return localDate; }
	 * 
	 * public static LocalDateTime getCurrentLocalDateAndTimeUsingCalendar() throws
	 * ParseException { DateTimeFormatter dateFormat = DateTimeFormatter
	 * .ofPattern(ApplicationConstant.date_formate_yyyy_MM_dd_HH_mm_ss); return
	 * LocalDateTime.parse(getCurrentTimeUsingCalendar(), dateFormat); }
	 * 
	 * public static ArrayList<TrackDelivery> getListTrackDeliveryFromObject(Object
	 * object) { ObjectMapper mapper = new ObjectMapper(); return
	 * mapper.convertValue(object, new TypeReference<List<TrackDelivery>>() { });
	 * 
	 * }
	 * 
	 * public static BillPrintConfigModel setprintData(String Name, int align, int
	 * seqNo, int startPoint, int width, int newLine, int sector, int spacing, int
	 * label, String printName) { BillPrintConfigModel billPrintModel = new
	 * BillPrintConfigModel();
	 * 
	 * billPrintModel.setFieldName(Name); billPrintModel.setAlign(align);
	 * billPrintModel.setSeqNo(seqNo); billPrintModel.setStrtPnt(startPoint);
	 * billPrintModel.setWidth(width); billPrintModel.setNewLine(newLine);
	 * billPrintModel.setSector(sector); billPrintModel.setSpacing(spacing);
	 * billPrintModel.setLabel(label); billPrintModel.setPrintName(printName);
	 * 
	 * return billPrintModel; }
	 * 
	 * 
	 * Return -1 : date1<date2 +0 : date1=date2 +1 : date1>date2
	 * 
	 * public static int compareDate(LocalDate date1, LocalDate date2) { if (date1
	 * == null || date2 == null) return 0;
	 * System.err.println("Date Compare: from date-" + date2 + "  to date-" +
	 * date1); System.err.println("Comparison o/p : " + date1.compareTo(date2));
	 * return date1.compareTo(date2); }
	 * 
	 * 
	 * Return -1 : (betweenDate>=date1) +0 : date1=date2 +1 : date1<date2
	 * 
	 * public static boolean checkDateBetweenTwoDates(LocalDate date1, LocalDate
	 * date2, LocalDate betweenDate) { boolean datePresent = false;
	 * 
	 * int ret1 = compareDate(date1, betweenDate); if (ret1 == 0) return true; int
	 * ret2 = compareDate(date2, betweenDate); if (ret2 == 0) return true; if (ret1
	 * == -1 && ret2 == 1) return true;
	 * 
	 * return datePresent; }
	 * 
	 * 
	 * Create Directory
	 * 
	 * public static String createDirectory(String path) {
	 * 
	 * System.out.println("Path : " + path); File file = new File(path); if
	 * (!file.exists()) { try { if (file.mkdirs()) {
	 * System.out.println("Directory is created!"); } else {
	 * System.out.println("Failed to create directory!"); } } catch (Exception e) {
	 * e.printStackTrace(); } } System.out.println("Path : " + path); return path; }
	 * 
	 * public static boolean checkFileExists(String path) { File file = new
	 * File(path); if (!file.exists()) { return false; } else { return true; } }
	 * 
	 * public static boolean copyFile(String fromPath, String toPath) { try {
	 * FileUtils.copyFile(new File(fromPath), new File(toPath)); } catch
	 * (FileNotFoundException e) {
	 * System.out.println("FileNotFoundException Exception Handle : " +
	 * e.getCause()); return false; } catch (Exception e) { e.printStackTrace();
	 * return false; } return true; }
	 * 
	 * public static String getImageDirectoryPath(long shop_details_id) {
	 * 
	 * String filePath = ApplicationConstant.SHOP_DATA_DIR + File.separator +
	 * shop_details_id + File.separator + "images" + File.separator;
	 * 
	 * createDirectory(filePath); if (checkFileExists(filePath)) return filePath;
	 * else return ""; }
	 * 
	 * public static boolean validateEmail(String emailid) { Boolean valid = false;
	 * if (emailid == null || emailid.trim().isEmpty()) { valid = true; } else {
	 * String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	 * valid = emailid.matches(EMAIL_REGEX); } System.err.println("Email id valid: "
	 * + emailid + " status: " + valid); return valid; }
	 * 
	 * public static String getBillDirectoryPath(long shop_details_id) { String
	 * filePath = ApplicationConstant.SHOP_DATA_DIR + File.separator +
	 * shop_details_id + File.separator + "bills" + File.separator;
	 * 
	 * createDirectory(filePath); if (checkFileExists(filePath)) return filePath;
	 * else return ""; }
	 * 
	 *//**
		 * @param localDateString
		 * @return
		 * @throws Exception Method used to get day of week used in db when we pass
		 *                   local date parameter to method
		 */
	/*
	 * public static String getHolidayString(LocalDate localDateString) throws
	 * Exception { DayOfWeek dayOfWeek = localDateString.getDayOfWeek(); //
	 * S,M,T,W,Th,F,Sa switch (dayOfWeek) { case SUNDAY: return "S";
	 * 
	 * case MONDAY: return "M";
	 * 
	 * case TUESDAY: return "T";
	 * 
	 * case WEDNESDAY: return "W";
	 * 
	 * case THURSDAY: return "Th";
	 * 
	 * case FRIDAY: return "F";
	 * 
	 * case SATURDAY: return "Sa";
	 * 
	 * default: return ""; } }
	 * 
	 *//**
		 * Format a double value
		 * 
		 * @param value
		 * @param decimal_places
		 * @return
		 */
	/*
	 * public static Double formatDoubleValue(double value, int decimal_places) {
	 * Double formated_decimal_value = Double.parseDouble(String.format("%." +
	 * decimal_places + "f", value)); return formated_decimal_value; }
	 * 
	 * public static String convertLocalDateToStringFormat(LocalDate date, String
	 * format) { DateTimeFormatter formatter_1 =
	 * DateTimeFormatter.ofPattern(format); String formated_date =
	 * (date).format(formatter_1); return formated_date; }
	 * 
	 * public static String convertLocalDateTimeToStringFormat(LocalDateTime
	 * dateTime, String format) { DateTimeFormatter formatter_1 =
	 * DateTimeFormatter.ofPattern(format); String formated_date =
	 * (dateTime).format(formatter_1); return formated_date; }
	 * 
	 * public static boolean isNoOfDaysInAMonthIs31(int month) { return month == 1
	 * || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 ||
	 * month == 12; }
	 * 
	 * public static String getLocalTimeInAmPmFormat() { LocalTime localTime =
	 * LocalTime.now(); DateTimeFormatter dateTimeFormatter =
	 * DateTimeFormatter.ofPattern("hh:mm a");
	 * System.out.println(localTime.format(dateTimeFormatter)); return
	 * localTime.format(dateTimeFormatter) + ""; }
	 * 
	 * public static LocalDate convertStringDateIntoLocalDate(String requestedDate)
	 * { // TODO Auto-generated method stub
	 * 
	 * DateTimeFormatter dateTimeFormatter =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd"); LocalDate localDate =
	 * LocalDate.parse(requestedDate, dateTimeFormatter);
	 * 
	 * return localDate; }
	 * 
	 * int num = 0;
	 * 
	 * public static String numberToWords(long number) { if (number == 0) return
	 * "zero";
	 * 
	 * if (number < 0) return "minus " + numberToWords(number);
	 * 
	 * String words = ""; if ((number / 10000000) > 0) { words +=
	 * numberToWords(number / 10000000) + " Crore "; number %= 10000000; } if
	 * ((number / 100000) > 0) { words += numberToWords(number / 100000) + " Lakh ";
	 * number %= 100000; } if ((number / 1000) > 0) { words += numberToWords(number
	 * / 1000) + " Thousand "; number %= 1000; } if ((number / 100) > 0) { words +=
	 * numberToWords(number / 100) + " Hundred "; number %= 100; } if (number > 0) {
	 * if (number < 20) words += unitsMap[(int) number]; else { words +=
	 * tensMap[(int) (number / 10)]; if ((number % 10) > 0) words += "-" +
	 * unitsMap[(int) (number % 10)]; } } return words; }
	 * 
	 * public static byte[] getBytesFromPdfPath(String absolutePath) { File file =
	 * new File(absolutePath); InputStream is;
	 * 
	 * try { is = new FileInputStream(file); return IOUtils.toByteArray(is);
	 * 
	 * } catch (FileNotFoundException e1) { e1.printStackTrace(); return null; }
	 * catch (IOException e) { e.printStackTrace(); return null; } }
	 * 
	 * public static LocalTime parseIntoLocalTimeFormateHHmmss(String time) throws
	 * ApplicationExceptions {
	 * 
	 * // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm.ss"); try
	 * { return LocalTime.parse(time); } catch (Exception e) { e.printStackTrace();
	 * throw new ApplicationExceptions("Please Check appropriate time formate"); } }
	 * 
	 *//**
		 * @author Asha 28/05/2020
		 * @param long minutes
		 * @used convet mintues to hours
		 **/
	/*
	 * public static long convertMinutsToHours(long minutes) throws
	 * ApplicationExceptions { try { return TimeUnit.MINUTES.toHours(minutes); }
	 * catch (Exception e) { e.printStackTrace(); throw new
	 * ApplicationExceptions("Please Check appropriate minutes "); } }//
	 * convertMinutsToHours method end here......
	 * 
	 *//**
		 * @author vickey
		 * @param value
		 * @param decimalPlaceRate
		 * @return fix precision value
		 * @Used round decimal value
		 */
	/*
	 * 
	 * public static double getValueWithDecimalPlaceRate(double value, int
	 * decimalPlaceRate) { double roundOffValue = 0.0; if (decimalPlaceRate <= 0)
	 * decimalPlaceRate = 2; BigDecimal bd = new BigDecimal(Double.toString(value));
	 * bd = bd.setScale(decimalPlaceRate, RoundingMode.HALF_UP); roundOffValue =
	 * bd.doubleValue(); return roundOffValue; }
	 * 
	 *//**
		 * 
		 * @param currentDate
		 * @return weekOfMonth
		 */
	/*
	 * public static long getWeekOfGivenDate(LocalDate currentDate) { LocalDate
	 * firstDayOfMonth = currentDate.minusDays(currentDate.getDayOfMonth() - 1);
	 * LocalDate firstWeekend = firstDayOfMonth.plusDays(Math.abs(7 -
	 * firstDayOfMonth.getDayOfWeek().getValue())); LocalDate lastDayOfMonth =
	 * currentDate.plusDays(currentDate.lengthOfMonth() -
	 * currentDate.getDayOfMonth()); // day month and 1st week range int weekOfDate
	 * = currentDate.getDayOfMonth() <= firstWeekend.getDayOfMonth() ? 1 :
	 * (currentDate.getDayOfMonth() <= (firstWeekend.getDayOfMonth() + 7)) ? 2 :
	 * (currentDate.getDayOfMonth() <= (firstWeekend.getDayOfMonth() + 14)) ? 3 :
	 * (currentDate.getDayOfMonth() <= (firstWeekend.getDayOfMonth() + 21)) &&
	 * (lastDayOfMonth.isBefore(currentDate)) ? 4 : 5; return weekOfDate; }
	 * 
	 *//**
		 * 
		 * @param currentDate
		 * @return weekOfMonth
		 */
	/*
	 * public static long getWeekOfGivenDateForSun1ToSat7(LocalDate currentDate) {
	 * LocalDate firstDayOfMonth = currentDate.minusDays(currentDate.getDayOfMonth()
	 * - 1); int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
	 * firstDayOfWeek = firstDayOfWeek + 1 == 8 ? 1 : firstDayOfWeek; LocalDate
	 * firstWeekend = firstDayOfMonth.plusDays(Math.abs(7 - firstDayOfWeek));
	 * LocalDate lastDayOfMonth = currentDate.plusDays(currentDate.lengthOfMonth() -
	 * currentDate.getDayOfMonth()); // day month and 1st week range int weekOfDate
	 * = currentDate.getDayOfMonth() <= firstWeekend.getDayOfMonth() ? 1 :
	 * (currentDate.getDayOfMonth() <= (firstWeekend.getDayOfMonth() + 7)) ? 2 :
	 * (currentDate.getDayOfMonth() <= (firstWeekend.getDayOfMonth() + 14)) ? 3 :
	 * (currentDate.getDayOfMonth() <= (firstWeekend.getDayOfMonth() + 21)) &&
	 * (lastDayOfMonth.isBefore(currentDate)) ? 4 : 5; return weekOfDate; }
	 * 
	 *//**
		 * @author Manish Akkale
		 * @param String
		 * @return shortedHolidays
		 * @Used to short week days
		 */
	/*
	 * public static String shortedWeekDays(String weekDays) { String days[] = {
	 * "S", "M", "T", "W", "TH", "F", "SA" }; StringBuffer shortedHolidays = new
	 * StringBuffer(""); if (!weekDays.trim().isEmpty()) { String holidays[] =
	 * weekDays.split(","); for (String day : days) { for (String holiday :
	 * holidays) { if (day.equalsIgnoreCase(holiday)) {
	 * shortedHolidays.append(holiday + ","); continue; } } }
	 * 
	 * // last ',' delete shortedHolidays.deleteCharAt(shortedHolidays.length() -
	 * 1); }
	 * 
	 * return shortedHolidays + ""; }
	 * 
	 * // Issue_00574 start public static String getShortFromOfWeekDay(String
	 * weekDay) { switch (weekDay) { case "SUNDAY": return "S"; case "MONDAY":
	 * return "M"; case "TUESDAY": return "T"; case "WEDNESDAY": return "W"; case
	 * "THURSDAY": return "TH"; case "FRIDAY": return "F"; case "SATURDAY": return
	 * "SA"; default: return "Not"; } }// Issue_00574
	 * 
	 *//**
		 * @author Manish Akkale
		 * @param LocalDate
		 * @return used to convert LocalDate formatte to dd_MMM_YYYY (22-Oct-2020)
		 */
	/*
	 * public static String convertLocalDateToddMMMYYYY(LocalDate date) { return
	 * date.format(DateTimeFormatter.ofPattern(ApplicationConstant.
	 * date_formate_dd_MMM_YYYY)); }
	 * 
	 *//**
		 * @author Manish akkale
		 * @param currentDate
		 * @return week day number
		 * @throws ApplicationExceptions
		 */
	/*
	 * //week1: SUNDAY=1, MONDAY=2, TUESDAY=3, WEDNESDAY=4, THURSDAY=5, FRIDAY=6,
	 * SATURDAY=7 //week2: SUNDAY=8, MONDAY=9,
	 * TUESDAY=10,WEDNESDAY=11,THURSDAY=12,FRIDAY=13, SATURDAY=14 //week3:
	 * SUNDAY=15,MONDAY=16,TUESDAY=17,WEDNESDAY=18,THURSDAY=19,FRIDAY=20,
	 * SATURDAY=21 //week4:
	 * SUNDAY=22,MONDAY=23,TUESDAY=24,WEDNESDAY=25,THURSDAY=26,FRIDAY=27,
	 * SATURDAY=28 //week5:
	 * SUNDAY=29,MONDAY=30,TUESDAY=31,WEDNESDAY=32,THURSDAY=33,FRIDAY=34,
	 * SATURDAY=35
	 * 
	 * //get first week sunday in december is 2020-12-06 //return 1
	 * 
	 * public static int getWeekOfDayNumber(LocalDate currentDate) throws
	 * ApplicationExceptions {
	 * 
	 * // SUNDAY = 2020-12-06.getDayOfWeek().toString() String dayOfweek =
	 * currentDate.getDayOfWeek().toString();
	 * 
	 * // 1 = 2020-12-06.get(ChronoField.ALIGNED_WEEK_OF_MONTH) int weekOfMonth =
	 * currentDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
	 * 
	 * // set hard code week day number according to data
	 * base(monthly_holidays_days) // week1:
	 * SUNDAY=1,MONDAY=2,TUESDAY=3,WEDNESDAY=4,THURSDAY=5,FRIDAY=6,SATURDAY=7 //
	 * week1: dayOFWeekIncrease = 0 int dayOFWeekIncrease =
	 * weekOfMonthIncreaseDays(weekOfMonth);
	 * 
	 * int weekOfDay = 0; switch (dayOfweek) { case "SUNDAY": { weekOfDay =
	 * dayOFWeekIncrease + 1; break; } case "MONDAY": { weekOfDay =
	 * dayOFWeekIncrease + 2; break; } case "TUESDAY": { weekOfDay =
	 * dayOFWeekIncrease + 3; break; } case "WEDNESDAY": { weekOfDay =
	 * dayOFWeekIncrease + 4; break; } case "THURSDAY": { weekOfDay =
	 * dayOFWeekIncrease + 5; break; } case "FRIDAY": { weekOfDay =
	 * dayOFWeekIncrease + 6; break; } case "SATURDAY": { weekOfDay =
	 * dayOFWeekIncrease + 7; break; } default: { throw new
	 * ApplicationExceptions("Invalid Week day"); } }
	 * 
	 * // 1 return weekOfDay;
	 * 
	 * }
	 * 
	 *//**
		 * @author Manish akkale
		 * @param currentDate
		 * @return week day number
		 * @throws ApplicationExceptions
		 */
	/*
	 * public static int weekOfMonthIncreaseDays(int weekOfMonth) throws
	 * ApplicationExceptions {
	 * 
	 * int[] weekOfMonthIncreaseDays = { 0, 7, 14, 21, 28 }; if (weekOfMonth <= 5 &&
	 * weekOfMonth >= 1) { return weekOfMonthIncreaseDays[weekOfMonth - 1]; } else {
	 * throw new ApplicationExceptions("Invalid week Of month"); }
	 * 
	 * }
	 * 
	 *//**
		 * @author Manish Akkale
		 * @param monthlyHolidaysDays comma separated
		 * @return shortedmonthlyHolidaysDays
		 * @Used to short monthlyHolidaysDays
		 */
	/*
	 * public static String shortedMonthlyHolidaysDays(String monthlyHolidaysDays) {
	 * 
	 * if (monthlyHolidaysDays != null && monthlyHolidaysDays.trim().length() > 0) {
	 * 
	 * // convert to int array int[] monthlyHolidaysDaysArray =
	 * Stream.of(monthlyHolidaysDays.trim().split(","))
	 * .mapToInt(Integer::parseInt).toArray();
	 * 
	 * // shorting Arrays.sort(monthlyHolidaysDaysArray);
	 * 
	 * StringBuffer shortedHolidays = new StringBuffer(""); for (int holiday :
	 * monthlyHolidaysDaysArray) { shortedHolidays.append(holiday + ","); }
	 * 
	 * shortedHolidays.deleteCharAt(shortedHolidays.length() - 1);
	 * 
	 * System.out.print(shortedHolidays.toString()); return
	 * shortedHolidays.toString(); } else { return ""; } }
	 * 
	 *//**
		 * @author Manish Akkale
		 * @param deepLinkId,deepLinkIdName
		 * @return DeepLink
		 * @Used to generate deepLink
		 */
	/*
	 * public static String generateDeepLink(long deepLinkId, String deepLinkIdName)
	 * { String link = "https://wiselap.page.link/?link=http://www.wiselap.com/" +
	 * deepLinkIdName + "=" + deepLinkId + "&apn=wisebill.wiselap_Developer" +
	 * "&ibi=com.wiselap.WiseLap&isi=1508324318&ius=https://apps.apple.com/us/app/id1508324318";
	 * return link; }
	 * 
	 * // bholesh public static LocalTime getLocaalTimeInAmPmFormat() { // LocalTime
	 * localTime = LocalTime.now(); DateTimeFormatter dateTimeFormatter =
	 * DateTimeFormatter.ofPattern("hh:mm a"); //
	 * System.out.println(localTime.format(dateTimeFormatter)); return
	 * LocalTime.parse(getLocalTimeInAmPmFormat(), dateTimeFormatter); }
	 * 
	 * public static LocalDate convertStringDateIntoLocaalDate(String requestDate) {
	 * // TODO Auto-generated method stub
	 * 
	 * DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM");
	 * LocalDate localDate = LocalDate.parse(requestDate, dateTimeFormatter);
	 * 
	 * return localDate; }
	 * 
	 *//**
		 * @author Manish Akkale
		 * @createDate :10-March-2021
		 * @param payableAmount,criteriaAmount,type
		 * @return calculate amount based on type
		 */
	/*
	 * public static long calculateAmountBasedOnType(double payableAmount, double
	 * criteriaAmount, String type) { long allotAmt = 0; double calculateAmt = 0; if
	 * (type.equalsIgnoreCase(ApplicationConstant.AMOUNT)) { calculateAmt = (long)
	 * criteriaAmount; } else if
	 * (type.equalsIgnoreCase(ApplicationConstant.PERCENT)) { calculateAmt =
	 * (payableAmount * criteriaAmount) / 100; } else if
	 * (type.equalsIgnoreCase(ApplicationConstant.AMOUNTCALCULATIONTYPE)) { //
	 * points type AMOUNTCALCULATIONTYPE for old date calculation double
	 * oneUnitCalculat = criteriaAmount; calculateAmt = payableAmount /
	 * oneUnitCalculat; } allotAmt = (long) (Math.round(calculateAmt)); return
	 * allotAmt; }
	 *//**
		 * @author Bholesh
		 * @createDate 15Mar2021
		 * @param
		 * @return path
		 */
	/*
	 * public String getPath() { String path = ""; String release =
	 * propertiesService.getPropertyValue("app.releasetype");
	 * System.out.println("release"+release); if (release != null) { if
	 * (release.equalsIgnoreCase("internal")) path =
	 * propertiesService.getPropertyValue("app.internal"); else if
	 * (release.equalsIgnoreCase("external")) path =
	 * propertiesService.getPropertyValue("app.external"); else if
	 * (release.equalsIgnoreCase("developer")) path =
	 * propertiesService.getPropertyValue("app.developer"); else path = ""; } else {
	 * path = ""; } System.out.println("path"+path); return path; }
	 * 
	 *//**
		 * @author Shubham Patkar
		 * @createDate 19Mar2021
		 * @param
		 * @return path
		 * @UseFor convert string to camel case
		 */
	/*
	 * public static String toCamelCase(String s){ String[] parts = s.split(" ");
	 * String camelCaseString = ""; for (String part : parts){ if(part!=null &&
	 * part.trim().length()>0) camelCaseString = camelCaseString +
	 * toProperCase(part); else camelCaseString=camelCaseString+part+" "; } return
	 * camelCaseString; }
	 * 
	 * 
	 *//**
		 * @author Shubham Patkar
		 * @createDate 19Mar2021
		 * @param
		 * @return path
		 * @UseFor convert string to Proper case
		 */
	/*
	 * public static String toProperCase(String s) { String temp=s.trim(); String
	 * spaces=""; if(temp.length()!=s.length()) { int
	 * startCharIndex=s.charAt(temp.indexOf(0));
	 * spaces=s.substring(0,startCharIndex); } temp=temp.substring(0,
	 * 1).toUpperCase() + spaces+temp.substring(1).toLowerCase()+" "; return temp;
	 * 
	 * }
	 *//**
		 * @author bholesh
		 * @param value
		 * @param decimalPlaceRate
		 * @return 0-->0.00,2.1-->2.10
		 *//*
			 * public static BigDecimal getValueWithDecimalPlaceRateV2(double value, int
			 * decimalPlaceRate) { if (decimalPlaceRate <= 0) decimalPlaceRate = 2;
			 * BigDecimal bd = new
			 * BigDecimal(Double.toString(value)).setScale(decimalPlaceRate,
			 * RoundingMode.FLOOR); return bd; }
			 */
}
