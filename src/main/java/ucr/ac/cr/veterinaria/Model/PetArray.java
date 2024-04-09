/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.veterinaria.Model;

import java.util.ArrayList;

/**
 *
 * @author Stephanie
 */
public class PetArray {

    private ArrayList<Pet> listPet;
    private ArrayList<Pet> listPetSelected;

    public PetArray() {
        listPet = new ArrayList<>();
        listPetSelected = new ArrayList<>();
    }

    public Pet search(int idPet) {
        for (Pet pet : this.listPet) {
            if (pet.getID() == idPet) {
                return pet;
            }
        }
        return null;
    }

    public String add(Pet pet) {
        if (pet != null) {
            if (this.search(pet.getID()) == null) {
                this.listPet.add(pet);
                return "Pet added succesfully!";
            } else {
                return "The pet is already registred";
            }
        }
        return "Error adding pet";
    }//fin metodo

    public String delete(int idPet) {
        if (this.listPet.remove(this.search(idPet))) {
            return "Pet succesfully eliminated";
        }
        return "Error when deleting pet";
    }

    public String edit(Pet petEdit) {
        for (int i = 0; i < this.listPet.size(); i++) {
            if (this.listPet.get(i).getID() == petEdit.getID()) {
                this.listPet.set(i, petEdit);
                return "Pet succesfully modified";
            }
        }
        return "Error while modified pet";
    }

    public String toString() {
        String out = "List pets: \n";
        for (Pet pet : this.listPet) {
            out += pet + "\n";
        }
        return out;
    }

    public int getLabel() {
        int id = 0;
        if (this.listPet.size() > 0) {
            return this.listPet.get(this.listPet.size() - 1).getID() + 1;
        }
        return 1;
    }

    //ojo*************************************************************************************************
    public String[] getIDCombo() {
        String[] idsList = new String[this.listPet.size()];
        for (int i = 0; i < this.listPet.size(); i++) {
            idsList[i] = this.listPet.get(i).getID() + "-" + this.listPet.get(i).getName();
        }
        return idsList;
    }

    public String[][] getMatrixPets() {
        String[][] matrixPets = new String[this.listPet.size()][Pet.TB_LABELS.length];
        for (int f = 0; f < matrixPets.length; f++) {
            for (int c = 0; c < matrixPets[0].length; c++) {
                matrixPets[f][c] = listPet.get(f).getData(c);
            }
        }
        return matrixPets;
    }

    public void addPetSelected(Pet pet) {
        listPetSelected.add(pet);
    }

    //
    //    public void addSongSelected(Song song){
    //        this.listSongsSelected.add(song);
    //    }
    //    
    //    public String[][] getMatrixDataSongsSelected() {
    //        String[][] matrixDataSongs = new String[this.listSongsSelected.size()][Song.TBL_LABELS.length];
    //        for (int f = 0; f < matrixDataSongs.length; f++) {
    //            for (int c = 0; c < matrixDataSongs[0].length; c++) {
    //                matrixDataSongs[f][c] = this.listSongsSelected.get(f).getData(c);
    //            }
    //
    //        }
    //        return matrixDataSongs;
    //    }
}
