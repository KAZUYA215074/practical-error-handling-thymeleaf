package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logtest")
public class LogController {

	private static final Logger logger = LoggerFactory.getLogger(LogController.class);

	@RequestMapping("/log")
	public String log() {
		{
			logger.info("log開始");

			try {
				String strAge = "2aa";
				int age = Integer.parseInt(strAge);
				logger.info("あなたは" + age + "歳です");				
			}catch(NumberFormatException ex) {
				logger.error("年齢が不正です");				
			}

			logger.info("log終了");

			return "finished-output-logs";
		}
	}
}
