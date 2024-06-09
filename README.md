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

