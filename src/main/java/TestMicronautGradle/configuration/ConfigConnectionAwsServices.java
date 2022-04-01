package TestMicronautGradle.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public class ConfigConnectionAwsServices {
    @Bean
    public AmazonDynamoDB setUpDynamoDB(){
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAWYB25OZEZOJHGFTL","HeoUpMxsndU78re8AZD6lLwUzaMndNvuEreE0sOZ");
        return AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.US_EAST_2).build();
    }
}
