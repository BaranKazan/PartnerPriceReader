# Questions
### How could a partner with a potentially slow REST interface be integrated?

There are several approaches that can be taken, such as:

**Asynchronous Processing:** There are patterns such as asynchronous communication that could be used to 
prevent a slow service that a partner provides from blocking our application processes. When using the Spring Boot, 
there is an @Async annotation that could be used and CompletableFuture class in java.util.concurrent 
package for handling REST calls.

**Caching:** There is Caching as well that could be implemented. This will store responses from slow service 
that will reduce the number of times a request needs to be called, which will minimize latency. 
When using the Spring, Cache Abstraction could be used to implement the solution.

**Timeouts:** This is important as well to prevent prolonged waiting time when doing multiple API calls 
towards a partner. It is important to implement retry calls with exponential backoff to handle exceptions 
effectively without having to overwhelm the partner service.

**Load Balancing:** The last solution that I could suggest is to distribute requests in multiple instances. 
This will prevent a partner having huge requests to handle that would take some time for a response.

### How could your solution scale for multiple thousand requests per second?

**Horizontal Scaling:** This is a solution commonly used when handling a heavy load of requests. 
It will create multiple instances of the application and divide requests to the instances. 
This can be managed using container orchestration tools such as Kubernetes or the cloud provider. 

**Load Balancing**: Load Balancer: This solution can be used to evenly distribute requests to multiple instances. 
Preventing a single instance from being bottlenecked, improving response time and availability.

**Asynchronous Processing:** It is recommended to use asynchronous processes for tasks that do 
not require immediate completion.

**Caching:** This method could be used to reduce the load of the RESTful API. 
By using the in-memory data storage such as the Redis and Memcached to cache frequently used data. 
This will increase response time, decrease latency and efficiently use resources by avoiding repeated calls.

**Queuing or Streaming:** Using services such as RabbitMQ or Kafka is recommended as well to manage the requests. 
Ensuring that the data are processing consistency across different instances.  

