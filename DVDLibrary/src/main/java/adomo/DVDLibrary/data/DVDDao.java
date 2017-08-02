/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adomo.DVDLibrary.data;

import adomo.DVDLibrary.domain.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDDao {
    
    DVD addDVD(String dvdTitle, DVD dvd);
    
    DVD removeDVD(String dvdTitle);
    
    DVD editDVD(String dvdTitle, DVD dvd);
    
    List<DVD> getAllDVDs();
    
    DVD searchDVD(String dvdTitle);
    
    
}
