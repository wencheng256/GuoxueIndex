package com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
	
	private static boolean status=false;
	
	private MyLogger()
	{
		
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyymmdd");
			String time=format.format(new Date());
			Handler handler=new FileHandler("%h/guoxue/"+time+"indexlog.log");
			handler.setLevel(Level.ALL);
			Logger.getLogger("log").setLevel(Level.ALL);
			Logger.getLogger("log").addHandler(handler);
			System.out.println("前台日志启动");
			Logger.getLogger("log").info("日志启动");
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void start()
	{
		if(!status)
		{
			new MyLogger();
			status=true;
		}
	}

}
