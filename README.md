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

Donde Method serìa sustituido por alguna de estos mensajes:
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
El método GET añade los datos codificados a la URI (uniform resorce identifier), mientras que el método POST añade los datos al cuerpo y no a la URI. Además, se  el método GET es usado para recuperar los datos, mientras que el método POST se utiliza para almacenar o actualizar los datos.  
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

5. Abrimos el navegador, y escribimos la siguiente URL, poniendo de host a localhost, como puerto el que se indica en el pom: 8080, y como path el que tambien se definió en el pom:/lab.
<img src="/img/15a.png" width="80%" height="80%"/>

En la ruta src/main/java/edu/eci/cvds/servlet, copiamos la clase SampleServlet.java dada en el laboratorio.

En el browser, escribiendo la url que se verá a continuación, se obtiene lo siguiente:
<img src="/img/16a.png" width="80%" height="80%"/>

6. Ahora, con la misma URL, pero enviándole de parámetro name=Juan gracia al signo "?":
<img src="/img/17.png" width="80%" height="80%"/>

7. Buscamos en el repositorio central de mvn el artefacto gson y agregamos la dependencia:

<img src="/img/18.png" width="80%" height="80%"/>
