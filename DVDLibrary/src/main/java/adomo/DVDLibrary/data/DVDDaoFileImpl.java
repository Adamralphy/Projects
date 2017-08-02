/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adomo.DVDLibrary.data;

import adomo.DVDLibrary.domain.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class DVDDaoFileImpl implements DVDDao {

    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> DVDs = new HashMap<>();

    @Override
    public DVD addDVD(String dvdTitle, DVD dvd) {
        DVD newDVD = DVDs.put(dvdTitle, dvd);
        writeDVDLibrary();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String dvdTitle) {
        DVD removedDVD = DVDs.remove(dvdTitle);
        writeDVDLibrary();
        return removedDVD;
    }

    /*@Override
    public DVD editDVD(String dvdTitle, DVD dvd) {
        
    }*/
    @Override
    public List<DVD> getAllDVDs() {
        loadDVDLibrary();
        return new ArrayList<DVD>(DVDs.values());
    }

    @Override
    public DVD editDVD(String dvdTitle, DVD dvd) {
        DVD editedDvd = DVDs.replace(dvdTitle, dvd);
        writeDVDLibrary();
        return editedDvd;
    }

    @Override
    public DVD searchDVD(String dvdTitle) {
        return DVDs.get(dvdTitle);
    }

    private void loadDVDLibrary() {
        try {
            Scanner scanner;

            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));

            String currentLine;

            String[] currentTokens;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                DVD currentDVD = new DVD(currentTokens[0]);
                currentDVD.setReleaseDate(currentTokens[1]);
                currentDVD.setMPAARating(currentTokens[2]);
                currentDVD.setDirectorName(currentTokens[3]);
                currentDVD.setStudio(currentTokens[4]);
                currentDVD.setUserRating(currentTokens[5]);

                DVDs.put(currentDVD.getTitle(), currentDVD);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DVDDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeDVDLibrary() {
        try {
            PrintWriter out;

            out = new PrintWriter(new FileWriter(DVD_FILE));

            List<DVD> dvdList = this.getAllDVDs();
            for (DVD currentDVD : dvdList) {
                out.println(currentDVD.getTitle() + DELIMITER
                        + currentDVD.getReleaseDate() + DELIMITER
                        + currentDVD.getMPAARating() + DELIMITER
                        + currentDVD.getDirectorName() + DELIMITER
                        + currentDVD.getStudio() + DELIMITER
                        + currentDVD.getUserRating() + DELIMITER);
                out.flush();
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(DVDDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
