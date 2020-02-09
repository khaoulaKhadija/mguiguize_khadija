package DAO;

import java.util.List;

public interface Iclient {
    void addclient(client n);
    void updateclient(client n);
    client getclient(int idn);
    List<client> getclients();
}

