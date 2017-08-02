/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adomo.DVDLibrary.domain;

/**
 *
 * @author apprentice
 */
public class DVD {
    
    private String dvdTitle;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String studio;
    private String userRating;
    
    public DVD(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public String getTitle() {
        return dvdTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
