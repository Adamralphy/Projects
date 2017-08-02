/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adomo.DVDLibrary.controller;

import adomo.DVDLibrary.data.DVDDao;
import adomo.DVDLibrary.data.DVDDaoFileImpl;
import adomo.DVDLibrary.domain.DVD;
import adomo.DVDLibrary.ui.UserIO;
import adomo.DVDLibrary.ui.UserIOFileImpl;
import adomo.DVDLibrary.ui.View;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Controller {

    View view = new View();
    UserIO io = new UserIOFileImpl();
    DVDDao dao = new DVDDaoFileImpl();
    

    public void run() {

        boolean keepGoing = true;

        while (keepGoing) {

            int menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listAllDVDs();
                    break;
                case 5:
                    searchDVDs();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GoodBye!");

    }

    public int getMenuSelection() {
        return view.displayMenuAndGetSelection();
    }

    private void createDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displaySuccessCreateDVDBanner();

    }

    private void removeDVD() {
        view.displayRemoveDVD();
        String dvdTitle = view.getDVDTitleChoice();
        dao.removeDVD(dvdTitle);
        view.displayRemoveDVDSuccess();

    }
    
    private void listAllDVDs() {
        view.displayListAllDVDs();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    private void searchDVDs() {
        view.displaySearchDVDs();
        String dvdTitle = view.getDVDTitleRemoveChoice();
        DVD dvd = dao.searchDVD(dvdTitle);
        view.displayDVD(dvdTitle, dvd);
    }

        private void editDVD() {
            view.displayEditDVDBanner();
            String dvdTitle = view.getEditDVDTitleChoice();
            DVD dvd = dao.searchDVD(dvdTitle);
            view.displayEditDVD(dvd);
            //dao.editedDvd(choice, );
            
        }
}
