# Network-Programming

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

### More information

  Developing **RESTful Web services** that seamlessly support exposing your data in a variety of representation media types and abstract away the low-level details of the client-server communication is not an easy task without a good toolkit. In order to simplify development of RESTful Web services and their clients in Java, a standard and portable JAX-RS API has been designed. Jersey RESTful Web Services framework is open source, production quality, framework for developing RESTful Web Services in Java that provides support for **JAX-RS APIs** and serves as a JAX-RS (JSR 311 & JSR 339) Reference Implementation.
  <br/>
  **Jersey framework** is more than the JAX-RS Reference Implementation. Jersey provides it’s own API that extend the JAX-RS toolkit with additional features and utilities to further simplify **RESTful service** and client development. 
Jersey also exposes numerous extension SPIs so that developers may extend Jersey to best suit their needs.

<br/><br/>
### HTTP Methods

The **PUT**, **GET**, **POST** and **DELETE** methods are typical used in REST based architectures. The following table gives an explanation of these operations.<br/><br/>

- **GET** defines a reading access of the resource without side-effects. The resource is never changed via a GET request, e.g., the request has no side effects (idempotent).<br/><br/>

- **PUT** creates a new resource. It must also be idempotent.<br/><br/>

- **DELETE** removes the resources. The operations are idempotent. They can get repeated without leading to different results.<br/><br/>

- **POST** updates an existing resource or creates a new resource.<br/><br/>

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
### What is REST?


**REST** is an architectural style which is based on web-standards and the **HTTP** protocol. This style was initially described by Roy Fielding in 2000. In a REST based architecture everything is a resource. A resource is accessed via a common interface based on the HTTP standard methods. In a REST based architecture you have a REST server which provides access to the resources. A REST client can access and modify the REST resources.<br/>
Every resource should support the HTTP common operations. Resources are identified by global IDs (which are typically URIs).
<br/>
**REST** allows that resources have different representations, e.g., text, **XML**, **JSON** etc. The REST client can ask for a specific representation via the HTTP protocol (content negotiation).
<br/>

```
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }

}

```


This class register itself as a get resource via the **@GET** annotation. Via the **@Produces** annotation it defines that it delivers the text and the HTML MIME types. It also defines via the **@Path** annotation that its service is available under the hello URL.
<br/>
The browser will always request the HTML MIME type. To see the text version, you can use tool like curl.
<br/>
<br/>

### Define Jersey Servlet dispatcher

You need to register Jersey as the servlet dispatcher for REST requests.
<br/>
Open the file **web.xml** and modify it to the following.<br/>


```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>com.vogella.jersey.first</display-name>
 <servlet>
    <servlet-name>Jersey REST Service</servlet-name>
    <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
     <!-- Register resources and providers under com.vogella.jersey.first package. -->
    <init-param>
        <param-name>jersey.config.server.provider.packages</param-name>
        <param-value>com.vogella.jersey.first</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>Jersey REST Service</servlet-name>
    <url-pattern>/rest/*</url-pattern>
  </servlet-mapping>
</web-app>
```

The parameter `jersey.config.server.provider.packages` defines in which package Jersey will look for the web service classes. This property must point to your resources classes. The URL pattern defines the part of the base URL your application will be placed.

<br/>

### Resources
* [Jersey](https://eclipse-ee4j.github.io/jersey/)
* [ApacheTomcat](https://tomcat.apache.org/download-80.cgi)
* [Javax.ws.rs.jar](https://jar-download.com/artifacts/javax.ws.rs)
* [JsonSimple.jar](http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm)


![alt text](https://wallpapercave.com/wp/wp4048620.png)
