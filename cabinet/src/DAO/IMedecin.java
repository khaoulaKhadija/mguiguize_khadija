package DAO;

import java.util.List;

public interface IMedecin {
    void addMedecin(Medecin n);
    void updateMedecin(Medecin n);
    Medecin getMedecin(int idn);
    List<Medecin> getMedecins();
}