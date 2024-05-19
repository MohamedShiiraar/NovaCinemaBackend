package za.ac.cput.novacinemaapp.service;
/*ITheatreService.java
Interface for Theatre Service
Author: Daanyaal Isaacs (220094934)
Date: 19 May
 */
import za.ac.cput.novacinemaapp.domain.Theatre;

import java.util.Set;

public interface ITheatreService extends IService<Theatre, String>{
    Set<Theatre> getAll();
}
