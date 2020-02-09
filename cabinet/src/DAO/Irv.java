package DAO;

import java.util.List;

public interface Irv {
    
    void addrv(rv n);
    void updaterv(rv n);
    rv getrv(int idn);
    List<rv> getrvs();
}
