package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tutorials")
public class Tutorial {
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "batch")
	private String batch;
	
	@Column(name = "stock")
	private long stock;
	
	@Column(name = "deal")
	private long deal;
	
	@Column(name = "free")
	private long free;
	
	@Column(name = "mrp")
	private double mrp;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "exp")
	private String exp;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "supplier")
	private String supplier;
	
	public Tutorial() {
		
	}
	
	public Tutorial(String code, String name, String batch, long stock, long deal, long free, double mrp, double rate, String exp, String company, String supplier) {
		this.code = code;
		this.name = name;
		this.batch = batch;
		this.stock = stock;
		this.deal = deal;
		this.free = free;
		this.mrp = mrp;
		this.rate = rate;
		this.exp = exp;
		this.company = company;
		this.supplier = supplier;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public long getDeal() {
		return deal;
	}

	public void setDeal(long deal) {
		this.deal = deal;
	}

	public long getFree() {
		return free;
	}

	public void setFree(long free) {
		this.free = free;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@Override
	public String toString() {
		return "Tutorial [code=" + code + ", name=" + name + ", batch" + batch + ", stock" + stock + ", deal" + deal + ", free=" + free + ", mrp=" + mrp + ", rate=" + rate + ", exp=" + exp + ", company=" + company + ", supplier" + supplier +"]";
	}
	
}
