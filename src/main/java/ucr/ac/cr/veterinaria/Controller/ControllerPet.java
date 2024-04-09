/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.veterinaria.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.veterinaria.Model.Pet;
import ucr.ac.cr.veterinaria.Model.PetArray;
import ucr.ac.cr.veterinaria.View.DataPanelButtons;
import ucr.ac.cr.veterinaria.View.DataPanelPet;
import ucr.ac.cr.veterinaria.View.GUIPet;
import ucr.ac.cr.veterinaria.View.GUIReport;

/**
 *
 * @author Stephanie
 */
public class ControllerPet implements ActionListener, MouseListener {

    private GUIPet guiPet;
    private DataPanelPet dataPanelPet;
    private DataPanelButtons dataPanelButtons;
    private PetArray petArray;
    private GUIReport guiReport;
    private Pet pet;

    public ControllerPet(PetArray petArray) {
        GUIPet guiPet = new GUIPet();
        guiReport = new GUIReport();

        this.petArray = petArray;

        this.dataPanelButtons = guiPet.getDataPanelButtons();
        this.dataPanelButtons.listen(this);

        this.dataPanelPet = guiPet.getDataPanelPet();
        this.dataPanelPet.setCbRaza();
        this.dataPanelPet.setCbService();
        this.dataPanelPet.listenCbID(this);
        this.dataPanelPet.setLbID(petArray.getLabel());
        this.dataPanelPet.setCbID(petArray.getIDCombo());
        

        guiPet.setVisible(true);

    }

    public boolean validate(Pet petValidate) {
        if (petValidate.getName().isBlank()) {
            GUIPet.setMessage("The name is empty");
            return false;

        } else if (petValidate.getRaza().equalsIgnoreCase("Selected Option")) {
            GUIPet.setMessage("The raza is empty");
            return false;

        } else if (petValidate.getService().equalsIgnoreCase("Selected Option")) {
            GUIPet.setMessage("The service is empty");
            return false;

        } else if (petValidate.getDuration() == 0) {
            GUIPet.setMessage("The duration is empty");
            return false;

        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":

                Pet petAux = this.dataPanelPet.getPet();
                if (petAux != null) {
                    if (this.validate(petAux)) {
                        GUIPet.setMessage(this.petArray.add(petAux));
                        this.dataPanelPet.setCbID(petArray.getIDCombo());
                        this.dataPanelPet.setLbID(petArray.getLabel());
                        this.dataPanelPet.clean();
                    }
                }
                break;
            case "Edit":
                GUIPet.setMessage(this.petArray.edit(this.dataPanelPet.getPet()));
                this.dataPanelPet.setCbID(petArray.getIDCombo());
                this.dataPanelPet.clean();
                break;
            case "Report":

                guiReport.setTblPets(petArray.getMatrixPets(), Pet.TB_LABELS);
                guiReport.listenMouse(this);
                guiReport.setVisible(true);

                break;
            case "Delete":
                GUIPet.setMessage(this.petArray.delete(this.dataPanelPet.getPet().getID()));
                this.dataPanelPet.setCbID(petArray.getIDCombo());
                this.dataPanelPet.clean();
                break;

            case "cbID":
                String id = this.dataPanelPet.getCbID();
                if (!id.equalsIgnoreCase("Selected Option")) {
                    pet = petArray.search(Integer.parseInt(id.substring(0, id.indexOf("-"))));
                    this.dataPanelPet.setPet(pet);
                }
                break;

            case "Exit":
                guiPet.dispose();
                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        this.dataPanelPet.setPet(new Pet(guiReport.getDataRaw()[0],
                Integer.parseInt(guiReport.getDataRaw()[1]),
                guiReport.getDataRaw()[2],
                guiReport.getDataRaw()[3],
                Double.parseDouble(guiReport.getDataRaw()[4])));
        this.guiReport.dispose();

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
