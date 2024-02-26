function enviarProducto() {
	var maxCantidadEnStock = document.getElementById('cantidadEnStock').max;
	var maxUmbralMinimo = document.getElementById('umbralMinimo').max;
	var maxPrecio = document.getElementById('precio').max;
	var productoId = document.querySelector('#productoId').value;
	var metodoHttp = productoId ? 'PUT' : 'POST';
	var url = 'http://localhost:8080/productos' + (productoId ? '/' + productoId : '');

	var producto = {
		nombre: document.querySelector('#nombre'),
		cantidadEnStock: document.querySelector('#cantidadEnStock'),
		umbralMinimo: document.querySelector('#umbralMinimo'),
		precio: document.querySelector('#precio'),
		proveedor: document.querySelector('#proveedor'),
		tipo: document.querySelector('#tipo')
	};

	var errores = [];

	// Reiniciar estilos de error
	for (var key in producto) {
		producto[key].style.borderColor = '';
	}

	// Validaciones
	if (producto.nombre.value.trim() === '') {
		errores.push("El nombre del producto no puede estar vacío.");
		producto.nombre.style.borderColor = 'red';
	}
	if (producto.proveedor.value.trim() === '') {
		errores.push("El proveedor del producto no puede estar vacío.");
		producto.proveedor.style.borderColor = 'red';
	}
	if (!producto.cantidadEnStock.value || isNaN(producto.cantidadEnStock.value) || parseInt(producto.cantidadEnStock.value) < 0 || parseInt(producto.cantidadEnStock.value) > maxCantidadEnStock) {
		errores.push("La cantidad en stock debe ser un número válido entre 0 y " + maxCantidadEnStock + ".");
		producto.cantidadEnStock.style.borderColor = 'red';
	}

	// Validación para umbral mínimo
	if (!producto.umbralMinimo.value || isNaN(producto.umbralMinimo.value) || parseInt(producto.umbralMinimo.value) < 0 || parseInt(producto.umbralMinimo.value) > maxUmbralMinimo) {
		errores.push("El umbral mínimo debe ser un número válido entre 0 y " + maxUmbralMinimo + ".");
		producto.umbralMinimo.style.borderColor = 'red';
	}

	// Validación para precio
	if (!producto.precio.value || isNaN(producto.precio.value) || parseFloat(producto.precio.value) <= 0 || parseFloat(producto.precio.value) > maxPrecio) {
		errores.push("El precio debe ser un número mayor que 0 y no más de " + maxPrecio + ".");
		producto.precio.style.borderColor = 'red';
	}


	if (errores.length > 0) {
		document.getElementById('errores').innerHTML = errores.join("<br>");
		return;
	}

	fetch(url, {
		method: metodoHttp,
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			nombre: producto.nombre.value.trim(),
			cantidadEnStock: producto.cantidadEnStock.value,
			umbralMinimo: producto.umbralMinimo.value,
			precio: producto.precio.value,
			proveedor: producto.proveedor.value.trim(),
			tipo: producto.tipo.value
		})
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Error en la solicitud: ' + response.statusText);
			}
			return response.json();
		})
		.then(data => {
			
			document.querySelector('#mensajeExito').textContent = productoId ? 'Producto actualizado con éxito' : 'Producto registrado con éxito';
			document.querySelector('#mensajeExito').style.display = 'block';
			document.getElementById('errores').innerHTML = ''; 
		})
		.catch(error => {
			console.error('Error:', error);
			document.getElementById('errores').innerHTML = 'Error al procesar la solicitud: ' + error.message;
		});
}






