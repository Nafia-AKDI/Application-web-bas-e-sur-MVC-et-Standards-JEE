package ma.fstt.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//@Entity
@ApplicationScoped
public class Client{
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	@Column(nullable = false, updatable =false)
	protected int codCli;
	
	protected String nomCli;
	protected String preCli;
	protected String adrCli;
//	@Column(nullable = false, updatable =false)
	protected String telCli;
	protected String villeCli;
	
//	@OneToMany(mappedBy="client",fetch=FetchType.LAZY) 
	private Collection<Commande> commandes;
	public int getCodCli() {
		return codCli;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPreCli() {
		return preCli;
	}

	public void setPreCli(String preCli) {
		this.preCli = preCli;
	}

	public String getAdrCli() {
		return adrCli;
	}

	public void setAdrCli(String adrCli) {
		this.adrCli = adrCli;
	}

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}

	public String getVilleCli() {
		return villeCli;
	}

	public void setVilleCli(String villeCli) {
		this.villeCli = villeCli;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}

	public Client(int codCli, String nomCli, String preCli, String adrCli, String telCli, String villeCli
			) {
		super();
		this.codCli = codCli;
		this.nomCli = nomCli;
		this.preCli = preCli;
		this.adrCli = adrCli;
		this.telCli = telCli;
		this.villeCli = villeCli;
	
	}
	public Client(String nomCli, String preCli, String adrCli, String telCli, String villeCli
			) {
		super();
		
		this.nomCli = nomCli;
		this.preCli = preCli;
		this.adrCli = adrCli;
		this.telCli = telCli;
		this.villeCli = villeCli;
	
	}
	public Client(int id) {
		this.codCli = id;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	} 
	@Override
	public String toString() {
		return "Client [codCli=" + codCli + ", nomCli=" + nomCli + ", preCli=" + preCli + ", adrCli=" + adrCli
				+ ", telCli=" + telCli + ", villeCli=" + villeCli + ", commandes=" + commandes + "]";
	}
	

}
