/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.veterinaria.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.veterinaria.Model.PetArray;
import ucr.ac.cr.veterinaria.View.GUIMain;

/**
 *
 * @author Stephanie
 */
public class ControllerMain implements ActionListener{
    private ControllerPet controllerPet;
    private PetArray petArray;
    private GUIMain guiMain;

    public ControllerMain() {
        this.guiMain = new GUIMain();
        this.guiMain.listen(this);
        this.petArray = new PetArray();
        this.guiMain.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Pet":
                controllerPet = new ControllerPet(petArray);
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }
    
    
    
    
    
}
