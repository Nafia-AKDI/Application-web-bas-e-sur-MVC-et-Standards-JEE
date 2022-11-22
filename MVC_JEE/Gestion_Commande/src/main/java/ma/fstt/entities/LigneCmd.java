package ma.fstt.entities;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

//@Entity
public class LigneCmd implements Serializable{
	public int getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}
	
	public int getQteCmd() {
		return qteCmd;
	}
	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}
	public int getCodArt() {
		return codArt;
	}
	public void setCodArt(int codArt) {
		this.codArt = codArt;
	}
	public int getNumCmd() {
		return numCmd;
	}
	public void setNumCmd(int numCmd) {
		this.numCmd = numCmd;
	}
	public LigneCmd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCmd(int numLigne, int qteCmd, int codArt, int numCmd) {
		super();
		this.numLigne = numLigne;
		this.codArt= codArt;
		this.qteCmd = qteCmd;
		this.numCmd= numCmd;
	}
	@Override
	public String toString() {
		return "LigneCmd [numLigne=" + numLigne + ", codArt=" + codArt + ", numCmd=" + numCmd + ", qteCmd=" + qteCmd
				+ "]";
	}
	public LigneCmd(int qteCmd, int codArt, int numCmd) {
		super();
		this.codArt= codArt;
		this.qteCmd = qteCmd;
		this.numCmd= numCmd;
	}
	public LigneCmd(int numLigne) {
		super();
		this.numLigne = numLigne;

	}
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	@Column(nullable = false, updatable =false)
	private int numLigne;
//	@ManyToOne
//	@JoinColumn(name="cod_Art") 
	private int codArt;
//	@ManyToOne
//	@JoinColumn(name="num_Cmd") 
	private int numCmd;
	private int qteCmd;


}
