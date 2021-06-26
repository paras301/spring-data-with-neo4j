package com.company.neo4j.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.company.neo4j.vo.Customer;
import com.company.neo4j.vo.Order;

public interface OrderRepository extends Neo4jRepository<Order, Long> {
	@Query("MATCH (c:Customer {name: $cname })-[:PLACED]->(o:Order {oid: $oid }) RETURN o")
	Order findOrderById(@Param("cname") String cname, @Param("oid") String oid);
}