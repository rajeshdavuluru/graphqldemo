# graphqldemo


#1)	What is GraphQL?
	GraphQL is all about data communication. You have a client and a server and both of them need to talk with each other. The client needs to tell the server what data it needs, and the server needs to fulfill this client’s data requirement with actual data. GraphQL steps into the middle of this communication.

#2)	What are the REST API problems it will solve? 
	a.	Over-fetching:  In a REST API, clients do not have control over what data the server will return. The REST API service will always return all of the fields regardless of which ones the client actually needs. GraphQL’s term for this problem is over-fetching of information that’s not needed. It’s a waste of network and memory resources for both the client and server.

	b.	Versioning: If you need to support multiple versions, that usually means new endpoints. This leads to more problems while using and maintaining those endpoints and it might be the cause of code duplication on the server.

	c.	Development and maintenance: Sometimes we need to write multiple services like one service for full details and another service for subset of data. We need to develop and maintain  different methods. 

	d.	Stiching: Schema stitching is the idea that you can take two or more GraphQL schemas, and merge them into one endpoint that can pull data from all of them. 

	e.	Other Benefits : we don’t need to create model classes, pass the JSON string to GraphQL, it will work. This will be useful for our orchestration APIs. At present we are creating the JSON schema and generation model classes while building. 

#3)	How to implement? 
	a.	Add dependencies in POM files
		i.	graphql-spring-boot-starter  
		ii.	graphql-java-tools
		iii.	graphiql-spring-boot-starter (if you need UI to test APIs)

	b.	Create GraphQL schema
		i.	Query: To fetch the data(GET)
		ii.	Mutations: we can update the data on the server by using mutations(POST, PUT, DELETE).
	c.	QueryResolvers


#4)	What is GraphiQL?
	GraphiQL is proving UI to communicate with any GraphQL Server and execute queries and mutations against it.

    TODO: Query with attributes and stitching.


