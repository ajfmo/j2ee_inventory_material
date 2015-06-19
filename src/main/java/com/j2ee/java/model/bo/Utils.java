/**
 * 
 */
package com.j2ee.java.model.bo;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
public class Utils {
	private static final SimpleDateFormat DATE_FORMATTER_WEB = new SimpleDateFormat(
			"YYYY/MM/DD");
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"YYYY-MM-DD");
}
