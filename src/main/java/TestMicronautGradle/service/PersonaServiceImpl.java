package TestMicronautGradle.service;

import TestMicronautGradle.model.Persona;
import TestMicronautGradle.model.Response;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.ScanResultPage;
import com.google.gson.Gson;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class PersonaServiceImpl implements PersonaService{
    private AmazonDynamoDB setUpDynamoDB;

    public PersonaServiceImpl(AmazonDynamoDB setUpDynamoDB) {
        this.setUpDynamoDB = setUpDynamoDB;
    }

    @Override
    public String save(Persona persona) {
        DynamoDBMapper dbMapper = new DynamoDBMapper(setUpDynamoDB);
        dbMapper.save(persona);
        Gson response = new Gson();
        return response.toJson(new Response("ok"));
    }

    @Override
    public String getPerson(Integer id) {
        DynamoDBMapper dbMapper = new DynamoDBMapper(setUpDynamoDB);
        Gson response = new Gson();
        return response.toJson(dbMapper.load(Persona.class,id));
    }

    @Override
    public String delete(Persona persona) {
        DynamoDBMapper dbMapper = new DynamoDBMapper(setUpDynamoDB);
        Persona persona1 = dbMapper.load(Persona.class,persona.getId());
        dbMapper.delete(persona1);
        Gson response = new Gson();
        return response.toJson(new Response("ok"));
    }

    @Override
    public String getALl() {
        DynamoDBMapper dbMapper = new DynamoDBMapper(setUpDynamoDB);
        DynamoDBScanExpression expression = new DynamoDBScanExpression();
        Gson response = new Gson();
        ScanResultPage<Persona> resultPage = dbMapper.scanPage(Persona.class,expression);
        return response.toJson(resultPage.getResults());
    }


}
