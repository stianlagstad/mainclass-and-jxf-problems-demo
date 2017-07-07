# jxf-problems-demo
This is a demo that reproduces a problem with cxf:

Problem: `org.apache.cxf.service.factory.ServiceConstructionException: Could not resolve a binding for null` when doing soap-calls. Reproduce with:  
- `gradle clean build && java -Xdebug -jar build/libs/mainclass-and-jxf-problems-demo.jar`  
- Go to http://localhost:4242/endpoint/ and see the error
