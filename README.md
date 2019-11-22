# Network-Programming

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

### More information

  Developing RESTful Web services that seamlessly support exposing your data in a variety of representation media types and abstract away the low-level details of the client-server communication is not an easy task without a good toolkit. In order to simplify development of RESTful Web services and their clients in Java, a standard and portable JAX-RS API has been designed. Jersey RESTful Web Services framework is open source, production quality, framework for developing RESTful Web Services in Java that provides support for JAX-RS APIs and serves as a JAX-RS (JSR 311 & JSR 339) Reference Implementation.

<br/><br/>
Here you can find a very interesting example of this restful service. <br/>
`GET request to https://{host}:{port}/sayHello`<br/>

```
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.core.Application;

@Path("/")
public class WolfPackController extends Application{
		
        /**
         * Test request
         * @return string 
         */
        @GET
        @Path("/sayHello")
        public String getHelloMsg() throws Exception{
          return "Hello there!";
        }
}
```
<br/><br/>

  Jersey framework is more than the JAX-RS Reference Implementation. Jersey provides it’s own API that extend the JAX-RS toolkit with additional features and utilities to further simplify RESTful service and client development. Jersey also exposes numerous extension SPIs so that developers may extend Jersey to best suit their needs.

<br/> <br/>


### Resources
* [Jersey](https://eclipse-ee4j.github.io/jersey/)
* [What are long polling websockets?](https://stackoverflow.com/questions/11077857/what-are-long-polling-websockets-server-sent-events-sse-and-comet/12855533#12855533)
* [Flukeout](http://flukeout.github.io/)
* [REGEXR](https://regexr.com/) 
* [ApacheTomcat](https://tomcat.apache.org/download-80.cgi)
* [Javax.ws.rs.jar](https://jar-download.com/artifacts/javax.ws.rs)
* [JsonSimple.jar](http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm)


![alt text](https://wallpapercave.com/wp/wp4048620.png)
