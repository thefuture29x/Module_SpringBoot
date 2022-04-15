package com.example.module_javaspringboot_day13.service;

import com.example.module_javaspringboot_day13.service.impl.ClassServiceIMPL;
import com.example.module_javaspringboot_day13.service.impl.StudentServiceIMPL;
import com.example.module_javaspringboot_day13.service.impl.TeacherServiceIMPL;
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
public class MainService {

    @Autowired
    ClassServiceIMPL classServiceIMPL;
    @Autowired
    StudentServiceIMPL studentServiceIMPL;
    @Autowired
    TeacherServiceIMPL teacherServiceIMPL;


    @Value("classpath:student.graphql")
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
                        .dataFetcher("allStudent", studentServiceIMPL::findAll)
                        .dataFetcher("saveOrUpdateStudent", studentServiceIMPL::saveOrUpdate)
                        .dataFetcher("deleteStudent", studentServiceIMPL::delete)
                        .dataFetcher("findStudent", studentServiceIMPL::find)
                        .dataFetcher("allClass",classServiceIMPL::findAll)
                        .dataFetcher("allClassWithPage",classServiceIMPL::findAllWithPage)
                        .dataFetcher("saveClass", classServiceIMPL::saveOrUpdate)
                        .dataFetcher("deleteClass",classServiceIMPL::delete)
                        .dataFetcher("findClass",classServiceIMPL::find)
                        .dataFetcher("allTeacher",teacherServiceIMPL::findAll)
                        .dataFetcher("saveOrUpdateTeacher",teacherServiceIMPL::saveOrUpdate)
                        .dataFetcher("deleteTeacher",teacherServiceIMPL::delete)
                        .dataFetcher("findTeacher",teacherServiceIMPL::find)
                )
                .build();
    }


    public GraphQL getGraphQL() {
        return graphQL;
    }
}
