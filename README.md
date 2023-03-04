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
En Request-URI, la sintaxis serìa http://servidor.dominio:puerto/path, y finalmente se pone la versión de HTTP.  
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
