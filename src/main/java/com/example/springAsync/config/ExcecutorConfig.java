package com.example.springAsync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class ExcecutorConfig extends AsyncConfigurerSupport {

    public static final String EXECUTOR_ASYNC_PROCESS = "asyncProcess";
    private final Integer asyncCorePoolSize=2;
    private final Integer asyncMaxPoolSize=10;

    @Bean(name = EXECUTOR_ASYNC_PROCESS)
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(asyncCorePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(asyncMaxPoolSize);
        threadPoolTaskExecutor.setThreadNamePrefix("executorAsync");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
