package com.web.stock.modelo;

public class Producto {


    private Long id; 
    private String nombre;
    private Integer cantidadEnStock;
    private Integer umbralMinimo;
    private Double precio;
    private String proveedor;
    private TipoProducto tipo;

    public enum TipoProducto {
        ELECTRONICO,
        ROPA,
        ALIMENTO,
        HOGAR,
        JUGUETE
    }
    

	public Producto() {
		
	}
	
	

	public Producto(String nombre, Integer cantidadEnStock, Integer umbralMinimo, Double precio, String proveedor,
			TipoProducto tipo) {

		this.nombre = nombre;
		this.cantidadEnStock = cantidadEnStock;
		this.umbralMinimo = umbralMinimo;
		this.precio = precio;
		this.proveedor = proveedor;
		this.tipo = tipo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public Integer getUmbralMinimo() {
		return umbralMinimo;
	}

	public void setUmbralMinimo(Integer umbralMinimo) {
		this.umbralMinimo = umbralMinimo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
    
    
    
}


