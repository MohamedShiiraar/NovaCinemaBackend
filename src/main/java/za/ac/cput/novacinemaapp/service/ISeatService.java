package za.ac.cput.novacinemaapp.service;
/*ISeatService.java
Entity for ISeatService
Author: Daanyaal Isaacs (220094934)
Date: 19 May
 */
import za.ac.cput.novacinemaapp.domain.Seat;

import java.util.Set;


public interface ISeatService extends IService<Seat, String>{
    Set<Seat> getAll();
}
