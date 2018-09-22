package cn.itcast.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.quartz.service.HelloService;

public class HelloJob implements Job {

	@Autowired
	private HelloService helloService;

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		helloService.sayHello();
	}

}
