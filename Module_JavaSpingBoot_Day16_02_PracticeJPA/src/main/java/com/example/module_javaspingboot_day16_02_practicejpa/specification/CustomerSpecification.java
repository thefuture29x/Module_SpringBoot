package com.example.module_javaspingboot_day16_02_practicejpa.specification;

import com.example.module_javaspingboot_day16_02_practicejpa.entities.CustomerEntity;
import com.example.module_javaspingboot_day16_02_practicejpa.entities.CustomerEntity_;
import org.springframework.data.jpa.domain.Specification;

public final class CustomerSpecification {

    public static Specification<CustomerEntity> hasId(Long userId) {
        return (root, query, cb) -> cb.equal(root.get(CustomerEntity_.ID), userId);
    }

    public static Specification<CustomerEntity> hasNameLike(String name) {
        return (root, query, cb) -> cb.like(root.get(CustomerEntity_.NAME), "%"+name+"%");
    }

    public static Specification<CustomerEntity> hasNameEqual(String name) {
        return (root, query, cb) -> cb.equal(root.get(CustomerEntity_.NAME), name);
    }


}
