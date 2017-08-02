/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adomo.DVDLibrary.ui;

import adomo.DVDLibrary.domain.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class View {

    UserIO io = new UserIOFileImpl();

    public int displayMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List DVDs");
        io.print("5. Search DVDs");
        io.print("6. EXIT");

        return io.readInt("Select from one of the above choices");

    }

    //Prompt the user for the next DVD, then store them into DVD setters
    public DVD getNewDVDInfo() {
        String dvdTitle = io.readString("Please enter the DVD Title.");
        String releaseDate = io.readString("Please enter the release date.");
        String mpaaRating = io.readString("Please enter the MPAA rating.");
        String directorName = io.readString("Please enter the Directors name");
        String studio = io.readString("Please enter the studio.");
        String userRating = io.readString("Please enter the user rating.");
        DVD currentDVD = new DVD(dvdTitle);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("===Create DVD===");
    }

    public String displaySuccessCreateDVDBanner() {
        return io.readString("Successfully created DVD, please press enter to continue.");
    }

    public void displayRemoveDVD() {
        io.print("===REMOVE A DVD===");
    }

    public String getDVDTitleChoice() {
        return io.readString("Select the DVD you would like to remove.");
    }
    
    public String getDVDTitleRemoveChoice() {
        return io.readString("Please type the name of the dvd you would like to view.");
    }

    public void displayRemoveDVDSuccess() {
        io.print("DVD successfully removed.  Please hit enter to continue.");
    }

    public void displayListAllDVDs() {
        io.print("===LIST ALL DVDs===");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle());

        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDVD(String dvdTitle, DVD dvd) {
        if (dvdTitle != null) {
            io.print("Title: " + dvd.getTitle()
                    + "\nRelease Date: " + dvd.getReleaseDate()
                    + "\nMPAA Rating: " + dvd.getMPAARating()
                    + "\nDirector: " + dvd.getDirectorName()
                    + "\nStudio: " + dvd.getStudio()
                    + "\nUser Rating: " + dvd.getUserRating());
        } else {
            io.print("DVD doesn't exist.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displaySearchDVDs() {
        io.print("===SEARCH DVDS===");
    }

    public String getEditDVDTitleChoice() {
        return io.readString("Select the DVD that you would like to edit.");
    }

    public void displayEditDVDBanner() {
        io.print("===EDIT DVD===");
    }

    public void displayEditDVD(DVD dvd) {

        String releaseDate = io.readString("Release Date: ");
        String mpaaRating = io.readString("MPAA Rating: ");
        String directorName = io.readString("Director Name: ");
        String studio = io.readString("Studio: ");
        String userRating = io.readString("User Rating: ");

        //DVD currentDVD = searchDVD(dvdTitle);
        //DVD currentDVD = DVD(dvdTitle);
        //DVD currentDVD.DVD(dvdTitle);
        
        if (releaseDate.trim() != null) {
            dvd.setReleaseDate(releaseDate);
        }
        if (mpaaRating.trim() != null) {
            dvd.setMPAARating(mpaaRating);
        }
        if (directorName.trim() != null) {
            dvd.setDirectorName(directorName);
        }
        if (studio.trim() != null) {
            dvd.setStudio(studio);
        }
        if (userRating.trim() != null) {
            dvd.setUserRating(userRating);
        }

    }

}
