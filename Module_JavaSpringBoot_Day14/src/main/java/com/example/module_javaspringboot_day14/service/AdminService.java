package com.example.module_javaspringboot_day14.service;

import com.example.module_javaspringboot_day14.service.impl.ProductServiceIMPL;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class AdminService {
    @Autowired
    ProductServiceIMPL productServiceIMPL;

    @Value("classpath:application.graphql")
    Resource resource;

    private GraphQL graphQL;

    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("findProduct",productServiceIMPL::find)
                        .dataFetcher("findAllProduct",productServiceIMPL::findAll)
                        .dataFetcher("saveOrUpdateProduct",productServiceIMPL::saveOrUpdate)
                        .dataFetcher("deleteProduct",productServiceIMPL::delete)
                )
                .build();
    }


    public GraphQL getGraphQL() {
        return graphQL;
    }
}
