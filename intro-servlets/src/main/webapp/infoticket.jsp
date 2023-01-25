<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ver Ticket</title>
    
</head>
<body>
    <section>
        <h1>Ticket</h1>
        <p>ID Ticket: ${t.getId()}</p>
        <p>Nombre: ${t.getNombre()}</p>
        <p>Apellido: ${t.getApellido()}</p>
        <p>Correo: ${t.getCorreo()}</p>
        <p>Cantidad: ${t.getCantidad()}</p>
        <p>Categoria: ${t.getCategoria()}</p>

        <a href="index.html">Volver</a>
    </section>
</body>
</html>