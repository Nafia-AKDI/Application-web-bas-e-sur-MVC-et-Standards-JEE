package ma.fstt.entities;

import java.io.Serializable;


import java.util.Collection;
import java.sql.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;



//@Entity
public class Commande implements Serializable{
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	@Column(nullable = false, updatable =false)
	private int numCmd;
	private Date dateCmd; 
	/*@ManyToOne
@JoinColumn(name="CODE_CLI")
private Client client;*/
//	@ManyToOne
//	@JoinColumn(name="COD_CLI") 
	private int codCli;
	public int getNumCmd() {
		return numCmd;
	}
	public void setNumCmd(int numCmd) {
		this.numCmd = numCmd;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	public int getCodCli() {
		return codCli;
	}
	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}
	@Override
	public String toString() {
		return "Commande [numCmd=" + numCmd + ", dateCmd=" + dateCmd + ", codCli=" + codCli + "]";
	}
	public Commande(int numCmd, Date dateCmd, int codCli) {
		super();
		this.numCmd = numCmd;
		this.dateCmd = dateCmd;
		this.codCli = codCli;
	}
	public Commande(int numCmd) {
		super();
		this.numCmd = numCmd;
		
	}
	public Commande(Date dateCmd, int codCli) {
		super();
		
		this.dateCmd = dateCmd;
		this.codCli = codCli;
	}
	
	

}
