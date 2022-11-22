package ma.fstt.entities;

import java.io.Serializable;

import java.util.Collection;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;


public class Article  implements Serializable{

	private int codArt;
	private String nomArt;
	private int pu;
	private int qteStock;
	
	
//	@OneToMany(mappedBy="article",fetch=FetchType.LAZY) 
	private Collection<LigneCmd> ligneCmds;
//	@OneToMany(mappedBy="article",fetch=FetchType.LAZY) 
//	private Collection<LigneLiv> ligneLivs;
	public Collection<LigneCmd> getLigneCmds() {
		return ligneCmds;
	}
	public void setLigneCmds(Collection<LigneCmd> ligneCmds) {
		this.ligneCmds = ligneCmds;
	}
	public int getCodArt() {
		return codArt;
	}
	@Override
	public String toString() {
		return "Article [codArt=" + codArt + ", nomArt=" + nomArt + ", pu=" + pu + ", qteStock=" + qteStock + "]";
	}
	public void setCodArt(int codArt) {
		this.codArt = codArt;
	}
	public String getNomArt() {
		return nomArt;
	}
	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}
	public int getPu() {
		return pu;
	}
	public void setPu(int pu) {
		this.pu = pu;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Collection<LigneLiv> getLigneLivs() {
//		return ligneLivs;
//	}
//	public void setLigneLivs(Collection<LigneLiv> ligneLivs) {
//		this.ligneLivs = ligneLivs;
//	}
	
	public Article( String nomArt, int pu, int qteStock) {
		super();
	//	this.codArt = codArt;
		this.nomArt = nomArt;
		this.pu = pu;
		this.qteStock = qteStock;
	}
	public Article(int codArt, String nomArt, int pu, int qteStock) {
		super();
		this.codArt = codArt;
		this.nomArt = nomArt;
		this.pu = pu;
		this.qteStock = qteStock;
	}
	public Article(int codArt) {
		super();
		this.codArt = codArt;
		
	}
}
