# mainclass-and-jxf-problems-demo
This is a demo that reproduces two problems:

Problem 1: main class not found. Reproduce with:  
- `gradle clean build && java -Xdebug -jar build/libs/shadowjarcxfproblem.jar`

Problem 2: `org.apache.cxf.service.factory.ServiceConstructionException: Could not resolve a binding for null` when doing soap-calls. Reproduce with:  
- `gradle clean shadowJar && java -Xdebug -jar build/libs/shadowjarcxfproblem-all.jar`  
- Go to http://localhost:4242/endpoint/ and see the error
