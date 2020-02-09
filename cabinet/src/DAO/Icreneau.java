package DAO;

import java.util.List;

public interface Icreneau {
    
    void addcreneau(creneau n);
    void updatecreneau(creneau n);
    creneau getcreneau(int idn);
    List<creneau> getcreneaux();
}
