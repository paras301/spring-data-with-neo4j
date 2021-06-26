package com.company.neo4j.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.company.neo4j.vo.Customer;
import com.company.neo4j.vo.Order;

public interface CustomerRepository extends Neo4jRepository<Customer, Long> {
	@Query("MATCH (c:Customer {name: $cname }) RETURN c")
	Customer findCustomerByName(@Param("cname") String cname);
}