package Keyla;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Facturas {

	private int codfactura;
	private String nombrecli;
	private float importe;
	private LocalDate fechafactura;
	
	public Facturas() {
		this.codfactura=0;
		this.nombrecli="Sin definir";
		this.importe= 0.0f;
		this.fechafactura=null;
	}
		
	public Facturas(int codfactura, String nombrecli, float importe, LocalDate fechafactura) {
		this.codfactura=codfactura;
		this.nombrecli=nombrecli;
		this.importe= importe;
		this.fechafactura=fechafactura;
	}

	public int getCodfactura() {
		return codfactura;
	}

	public void setCodfactura(int codfactura) {
		this.codfactura = codfactura;
	}

	public String getNombrecli() {
		return nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) throws Exception {
		if(importe<=0) {
			throw new Exception("Importe no válido");
		}
		this.importe = importe;
	}

	public LocalDate getFechafactura() {
		return fechafactura;
	}

	public void setFechafactura(LocalDate fechafactura) {
		this.fechafactura = fechafactura;
	}

	public LocalDate getfechaCobro() {
		DateTimeFormatter df= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaCobro=null;
		
		if(this.getImporte()<10000) {
			fechaCobro=this.fechafactura.plusDays(30);
		}
		else if(this.getImporte()>=10000 && this.getImporte()<50000) {
			fechaCobro=this.fechafactura.plusDays(60);
		}
		else {
			fechaCobro=this.fechafactura.plusDays(90);
		}
		if(fechaCobro.getDayOfWeek()==DayOfWeek.SATURDAY) {
			fechaCobro=fechaCobro.plusDays(2);
		}else if(fechaCobro.getDayOfWeek()==DayOfWeek.SUNDAY) {
			fechaCobro=fechaCobro.plusDays(2);
		}
		return fechaCobro;
	}
	public String toString() {
		return "Código de factura: " + getCodfactura()+"\tNombre cliente: " + getNombrecli()+
				"\nFecha factura:" + getFechafactura() + "\tFecha de cobro: " + getfechaCobro()+
				"\nImporte: "+ getImporte();
	}
	
}
