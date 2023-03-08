# LABORATORIO 5 - MVC PRIMEFACES INTRODUCTION
## INTRODUCCIÓNA PROYECTOS WEB

### Integrantes

* Santiago Arévalo Rojas
* Juan Felipe Sánchez Pérez

## PARTE I. - JUGANDO A SER UN CLIENTE HTTP
2. Al abrir la terminal, se realiza una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:
<img src="/img/1.png" width="80%" height="80%"/>

3. Buscando en el link especificado en el enunciado, la sintaxis pare realizar una petición es la siguiente:  
` Request-Line   = Method SP Request-URI SP HTTP-Version CRLF `  

Donde Method sería sustituido por alguna de estos mensajes:
* OPTIONS
* GET
* HEAD
* POST
* PUT
* DELETE
* TRACE
* CONNECT  
En Request-URI, la sintaxis sería `http://servidor.dominio:puerto/path`, y finalmente se pone la versión de HTTP.  
Un ejemplo sería así: `GET http://www.w3.org/pub/WWW/TheProject.html HTTP/1.1`  
ò   
```
GET /pub/WWW/TheProject.html HTTP/1.1  
Host: www.w3.org
```

Para el caso del laboratorio, sería de la siguiente forma:
<img src="/img/2.png" width="80%" height="80%"/>
  
* ¿Qué código de error sale?  
No sale un còdigo de error, pero se indica que la conexiòn fue cerrada por un host externo.
* ¿Qué otros códigos de error existen y en qué casos se manejan?  
Existen los siguientes tipos de códigos de error:
    1. Errores de los clientes (400–499).  
        Dentro de estos errores, encontramos con más frecuencia los siguientes:
        * 400 Bad request: Servidor no pudo interpretar la solicitud pos una sintaxis inválida.
        * 401 Unauthorized: Debe autenticarse para obtener el recurso.
        * 402 Payment required: 
        * 403 Forbidden: Cliente no tiene los permisos necesarios.
        * 404 Not Found: Servidor no pudo encontrar el recurso solicitado.  
    2. Errores de los servidores (500–599).  
        Dentro de estos errores, encontramos con más frecuencia los siguientes:
        * 500 Internal Server Error: Servidor encontró una falla que no sabe cómo resolverla.
        * 501 Not Implemented: El mètodo solicitado no està soportado por el servidor.
        * 502 Bad Gateway
        * 503 Service Unavailable
4. Al realizar la nueva conexión con telnet, se obtiene lo siguiente:
<img src="/img/3.png" width="80%" height="80%"/>

5. Se copió del portapapeles a un archivo de texto, y se hizo desde la terminal el comando wc -c contenido.rtf, para contar
la cantidad de caracteres de este:
<img src="/img/4.png" width="80%" height="80%"/>
<img src="/img/5.png" width="80%" height="80%"/>

¿Cuál es la diferencia entre los verbos GET y POST?¿Qué otros tipos de peticiones existen?  
El método GET añade los datos codificados a la URI (uniform resorce identifier), mientras que el método POST añade los datos al cuerpo y no a la URI. Además, el método GET es usado para recuperar los datos, mientras que el método POST se utiliza para almacenar o actualizar los datos.  
Existen otros tipos de peticiones como las mencionadas anteriormente en el punto 3.

6. Sin importar que comando se usó, el contenido html era el mismo:
<img src="/img/6.png" width="80%" height="80%"/>

La principal diferencia se encuentra en al inicio del resultado:  
* Con parámetro -i:
<img src="/img/7.png" width="80%" height="80%"/>
* Con parámetro -v, se indica el exito de la conexión:
<img src="/img/8.png" width="80%" height="80%"/>

## PARTE II. -HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.
Se crea un proyecto Maven usando el arquetipo de Aplicación web:
<img src="/img/9.png" width="100%" height="100%"/>

2. Agregamos la dependencia especificada, y la sección build al archivo pom.xml:
<img src="/img/10a.png" width="80%" height="80%"/>

3. Revisando el archivo pom.xml, se observa que el servidor embebido de Tomcat está configurado pra el puerto 8080:
<img src="/img/12.png" width="80%" height="80%"/>

4. Compilamos con mvn package:
<img src="/img/13.png" width="80%" height="80%"/>

Usamos el comando mvn tomcat7:run para desplegar la app web:
<img src="/img/14.png" width="80%" height="80%"/>

5. Abrimos el navegador, y escribimos la siguiente URL, poniendo de host a localhost, como puerto el que se indica en el pom: 8080, y como path el que tambien se definió en el pom:/ .
<img src="/img/15a.png" width="80%" height="80%"/>

En la ruta src/main/java/edu/eci/cvds/servlet, copiamos la clase SampleServlet.java dada en el laboratorio.

En el browser, escribiendo la url que se verá a continuación, se obtiene lo siguiente:
<img src="/img/16a.png" width="80%" height="80%"/>

6. Ahora, con la misma URL, pero enviándole de parámetro name=Juan gracia al signo "?":
<img src="/img/17.png" width="80%" height="80%"/>

7. Buscamos en el repositorio central de mvn el artefacto gson y agregamos la dependencia:

<img src="/img/18.png" width="80%" height="80%"/>

8. Al ir a la dirección `https://jsonplaceholder.typicode.com/todos/1`, se observa lo siguiente:  
<img src="/img/19.png" width="80%" height="80%"/>

Si modificamos el último número de la URL, por 10, de la siguiente forma `https://jsonplaceholder.typicode.com/todos/10` se obtiene lo siguiente:  
<img src="/img/20.png" width="80%" height="80%"/>

9. La clase Todo está en el proyecto.

10. Agregamos la clase que nos indican en el proyecto.

11. Se creó la clase OurFirtsServlet, y se añadió al proyecto.

12. Se agregó la notación:
```
@WebServlet(
        urlPatterns = "/OpenTheWindow"
)
```  
Para indicar en qué URL el servlet interceptará las peticiones GET.

13. Implementamos el método doGet en OurFirstServlet, con los requerimientos especificados en el laboratorio.  
Realizando las pruebas correspondientes, obtenemos lo siguiente:
* Cuando se consulta un id de To-do que si existe:
<img src="/img/21.png" width="80%" height="80%"/>

* Cuando se consulta un id de To-do que no existe:
<img src="/img/22.png" width="80%" height="80%"/>

## PARTE III

16. Se sobreescribió el método doPost en OurFirstServlet con la misma implementación del método doGet.

17. Se creó el archivo index.html en la ruta indicada.

18. Se creó el formulario indicado con el método post, y como acción, la ruta relativa al servlet que creamos (OurFirstServlet).
```
<!DOCTYPE html>
<html>
  <head>
    <title>Start Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <h1>Hello World!</h1>
    <h2>Form</h2>
    <form action="/OpenTheWindow" method="post">
      <label for="id">Ingrese un número:</label>
      <input type="text" id="id" name="id"><br><br>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
```
19. Se agrega la validación de formularios con javascript.
```
<!DOCTYPE html>
<html>
  <head>
    <title>Start Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <h1>Hello World!</h1>
    <h2>Form</h2>
    <form name="idForm" action="/OpenTheWindow" method="post" onsubmit="return validateForm()">
      <label for="id">Ingrese un número:</label>
      <input type="text" id="id" name="id"><br><br>
      <input type="submit" value="Submit">
    </form>
    <script>
	function validateForm() {
  		let x = document.forms["idForm"]["id"].value;
  		if (isNaN(x)) {
    		alert("Id is not a number");
    		return false;
  		}
	}	
	</script>
  </body>
</html>
```

20. Luego de recompilar e ingrear a la página web, aún teniendo el method como post.
<img src="/img/23.png" width="80%" height="80%"/>

Al seleccionar submit:
<img src="/img/24.png" width="80%" height="80%"/>

Una vez realizada la modificación del methos a get, se evidencia que no hubo cambios.

```
<form name="idForm" action="/OpenTheWindow" method="post" onsubmit="return validateForm()">
```

21. Para que esto funciona, la clase Service tiene un método para consumir el servicio de obtención de tareas según id que se llama getTodo, el cual es invocado por la clase servlet que creamos (OurFirstServlet), allí simplemente lo llama según el id que se envie por medio del request para proceder a mostrarlo en la página por medio del response, obteniendo el Writer y por medio del método write se muestra en pantalla. Ya para unir el formulario que realizamos en el index.html, como se especifica que el action va al Servlet que creamos, entonces al realizar submit le envía el id y muestra la fila del id esperado.
## PARTE IV. - FRAMEWORKS WEB MVC – JAVA SERVER FACES PRIME FACES
1. Entrando al Maven Repository Central, se tienen las siguientes dependcias:
* Para javax.javaee-api:
```
<!-- https://mvnrepository.com/artifact/org.glassfish/javax.javaee -->
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>javax.javaee</artifactId>
    <version>10.0-b28</version>
</dependency>
```

* Para com.sun.faces.jsf-api:
```
<!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-api -->
<dependency>
    <groupId>com.sun.faces</groupId>  
    <artifactId>jsf-api</artifactId> 
    <version>2.2.20</version>
</dependency>
```

* Para com.sun.faces.jsf-impl:
```
<!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-impl -->
<dependency>    
    <groupId>com.sun.faces</groupId>    
    <artifactId>jsf-impl</artifactId>    
    <version>2.2.20</version>
</dependency>
```

* Para javax.servlet.jstl:
```
<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
<dependency>    
    <groupId>javax.servlet</groupId>    
    <artifactId>jstl</artifactId>    
    <version>1.2</version>
</dependency>
```

* Para Primefaces:
```
<!-- https://mvnrepository.com/artifact/org.primefaces/primefaces -->
<dependency>    
    <groupId>org.primefaces</groupId>    
    <artifactId>primefaces</artifactId>    
    <version>12.0.0</version>
</dependency>
```
2. Se encuentra agregado en el web.xml.
3. Funciones de cada una de las etiquetas:
* welcome-file-list: Muestra que páigna se mostrará por defecto al arrancar la aplicación.
* servlet: El elemento <servlet> declara el servlet, lo que incluye un nombre que otros elementos del archivo usan en el archivo (<servlet-name>), la clase que se usará para el servlet (<servlet-class>), los parámetros de inicialización y finalmente indica el orden de carga de los servlets de forma ascendente (<load-on-startup>).
* servlet-mapping: Especifica un patrón de URL (<url-pattern>) y el nombre de un servlet (<servlet-name>) declarado para usar en solicitudes cuyas URL coincidan con el patrón.
