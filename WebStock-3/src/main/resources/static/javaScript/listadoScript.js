
window.addEventListener('DOMContentLoaded', (event) => {
    cargarProductos();
    
      
});

function cargarProductos() {
    fetch('http://localhost:8080/productos')
    .then(response => response.json())
    .then(data => mostrarProductos(data))
    .catch(error => console.error('Error al cargar productos:', error));
}

function buscarProductosPorTipo() {
    var tipo = document.getElementById('tipoBusqueda').value;
    fetch(`http://localhost:8080/productos/buscarPorTipo?tipo=${tipo}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta del servidor');
        }
        return response.json();
    })
    .then(data => mostrarProductos(data))
    .catch(error => {
        console.error('Error al buscar productos:', error);
        // Puedes mostrar un mensaje de error más amigable aquí
    });
}

function buscarProductosPorProveedor() {
    var proveedor = document.getElementById('proveedorBusqueda').value;
    fetch(`http://localhost:8080/productos/buscarPorProveedor?proveedor=${proveedor}`)
    .then(response => response.json())
    .then(data => mostrarProductos(data))
    .catch(error => {
        console.error('Error al buscar productos:', error);
        // Manejar el error
    });
}

function mostrarProductos(productos) {
    const tableBody = document.querySelector('#productosTable tbody');
    const stockAlertMessage = document.getElementById('stockAlertMessage');
    tableBody.innerHTML = '';
    stockAlertMessage.innerHTML = ''; 

    let alertMessages = [];
    
    const userRole = document.getElementById('userRole').value;

    productos.forEach(producto => {
        // Verificar si la cantidad en stock es igual o inferior al umbral mínimo
        if (parseInt(producto.cantidadEnStock) <= parseInt(producto.umbralMinimo)) {
            // Agregar mensaje de alerta para este producto
            alertMessages.push(`Alerta: El producto ${producto.nombre} (ID: ${producto.id}) tiene una cantidad en stock igual o inferior a su umbral mínimo.`);
        }
        
        const row = tableBody.insertRow();
        row.id = `producto-${producto.id}`;

        let accionesHTML = `
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.cantidadEnStock}</td>
            <td>${producto.umbralMinimo}</td>
            <td>${producto.precio.toFixed(2)} €</td>
            <td>${producto.proveedor}</td>
            <td>${producto.tipo}</td>
        `;

        if (userRole === 'ROLE_ADMIN') {
            accionesHTML += `
                <td>
                    <a href="/actualizar/${producto.id}" class="btn">Actualizar</a>
                    <button onclick="eliminarProducto(${producto.id})">Eliminar</button>
                </td>
            `;
        } else {
            accionesHTML += `<td></td>`; // Espacio vacío para usuarios no administradores
        }

        row.innerHTML = accionesHTML;
    });

    if (alertMessages.length > 0) {
        stockAlertMessage.innerHTML = alertMessages.join('<br>');
    }
}

function eliminarProducto(id) {
   

    fetch(`http://localhost:8080/productos/${id}`, { method: 'DELETE' })
        .then(response => {
            if (response.ok) {
                // Mostrar mensaje de éxito
                mostrarMensaje('Producto eliminado correctamente');
                // Eliminar la fila de la tabla
                document.getElementById(`producto-${id}`).remove();
                // Opcionalmente recargar la página tras un breve retardo
                setTimeout(() => window.location.reload(), 2000);
            } else {
                mostrarMensaje('Error al eliminar el producto');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            mostrarMensaje('Error al intentar eliminar el producto');
        });
}

function mostrarMensaje(mensaje) {
    const mensajeEliminacionDiv = document.getElementById('mensajeEliminacion');
    mensajeEliminacionDiv.innerText = mensaje;
   
}



