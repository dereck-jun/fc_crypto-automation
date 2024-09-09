package com.fc_cryptoautomation.batch;

import com.fc_cryptoautomation.service.UpBitSlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class TickerSlackJobConfig {

    private final UpBitSlackService upBitSlackService;

    @Bean
    public Job tickerSlackJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("tickerSlackJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, Tasklet tasklet, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();
    }

    @Bean
    public Tasklet tasklet() {
        return ((contribution, chunkContext) -> {
            Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();
            String market = String.valueOf(jobParameters.get("market").toString());

            upBitSlackService.execute(market);

            return RepeatStatus.FINISHED;
        });
    }
}
