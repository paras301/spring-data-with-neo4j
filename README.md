# spring-data-with-neo4j

The project takes an example of Customer order processing via REST calls.

The customer and orders with lineitems are created in Neo4j in a tree structure.

I am using cypher queries to process the data which is kind of old way, but this is faster as compared to OGM because internally Neo4j driver executes a lot of cyphers for each operation. Follow the documentation and story here: https://paras301.medium.com/neo4j-data-processing-with-springboot-ee6b771b5887
