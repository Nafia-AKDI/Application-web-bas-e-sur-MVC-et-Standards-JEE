package ma.fstt.services;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.LigneCmd;

public interface LigneCmdRepository {
	public boolean insertLigneCmd(LigneCmd ligneCmd) throws SQLException;
	public boolean deleteLigneCmd(LigneCmd ligneCmd) throws SQLException;
	public List<LigneCmd> listAllLigneCmds() throws SQLException;
	public boolean updateLigneCmd(LigneCmd ligneCmd) throws SQLException;
	LigneCmd getLigneCmd(int id) throws SQLException;
}