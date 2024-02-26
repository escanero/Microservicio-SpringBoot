function enviarProducto() {
    var productoId = document.querySelector('#id').value;
    var metodoHttp = productoId ? 'PUT' : 'POST';
    var url = 'http://localhost:8080/productos' + (productoId ? '/' + productoId : '');

       var producto = {
        nombre: document.querySelector('#nombre').value.trim(),
        cantidadEnStock: document.querySelector('#cantidadEnStock').value,
        umbralMinimo: document.querySelector('#umbralMinimo').value,
        precio: document.querySelector('#precio').value,
        proveedor: document.querySelector('#proveedor').value.trim(),
        tipo: document.querySelector('#tipo').value
    };

    var errores = [];

    if (producto.nombre === '') {
        errores.push("El nombre del producto no puede estar vacío.");
    }
    if (!producto.cantidadEnStock || isNaN(producto.cantidadEnStock) || parseInt(producto.cantidadEnStock) < 0) {
        errores.push("La cantidad en stock debe ser un número válido y mayor o igual a 0.");
    }
    if (!producto.umbralMinimo || isNaN(producto.umbralMinimo) || parseInt(producto.umbralMinimo) < 0) {
        errores.push("El umbral mínimo debe ser un número válido y mayor o igual a 0.");
    }
    if (!producto.precio || isNaN(producto.precio) || parseFloat(producto.precio) <= 0) {
        errores.push("El precio debe ser un número mayor que 0.");
    }
    if (producto.proveedor === '') {
        errores.push("El proveedor no puede estar vacío.");
    }
    if (producto.tipo === '') {
        errores.push("Debe seleccionar un tipo de producto.");
    }

    if (errores.length > 0) {
        alert("Por favor corrige los siguientes errores:\n" + errores.join("\n"));
        return;
    }


    if (errores.length > 0) {
        alert("Por favor corrige los siguientes errores:\n" + errores.join("\n"));
        return;
    }

    fetch(url, {
        method: metodoHttp,
        headers: {
            'Content-Type': 'application/json',
            // Aquí puedes añadir más cabeceras si es necesario
        },
        body: JSON.stringify(producto)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la solicitud: ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        // Aquí manejas la respuesta exitosa
        document.querySelector('#mensajeExito').textContent = productoId ? 'Producto actualizado con éxito' : 'Producto registrado con éxito';
        document.querySelector('#mensajeExito').style.display = 'block';
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al procesar la solicitud: ' + error.message);
    });
}
