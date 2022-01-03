package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAnimal {

    //////////////////////////////////////
    //        Test Constructeur     	//
    //////////////////////////////////////

    @Test
    public void test_controleur1() {
        String expected_nom = "Tamagotchi";
        String expected_type = "Animal";
        String expected_race = "Chat";

        Piece localisation = new Piece("Salon");
        Animal testAnimal = new Animal("Tamagotchi", "Chat", localisation);

        assertNotNull(testAnimal);
        assertEquals(expected_race, testAnimal.getType());
        assertEquals(expected_nom, testAnimal.getNom());
        assertEquals(expected_type, testAnimal.getTypeGeneral());
    } 
    
    //////////////////////////////////
    //        Test Getters      	//
    //////////////////////////////////

    @Test
    public void test_getNom(){
        String expected_nom = "Tamagotchi";

        Piece localisation = new Piece("Salon");
        Animal testAnimal = new Animal("Tamagotchi", "Chat", localisation);

        // Cas sans erreur

        assertEquals(expected_nom,testAnimal.getNom());

        // Cas avec erreur

        String notExpected_nom = "Victor";
        assertNotEquals(notExpected_nom,testAnimal.getNom());
    }

    @Test
    public void test_getTypeGeneral(){
        String expected_type = "Animal";

        Piece localisation = new Piece("Salon");
        Animal testAnimal = new Animal("Tamagotchi", "Chat", localisation);

        // Cas sans erreur

        assertEquals(expected_type,testAnimal.getTypeGeneral());

        // Cas avec erreur

        String notExpected_type = "Robot";
        assertNotEquals(notExpected_type,testAnimal.getTypeGeneral());
    }

    @Test
    public void test_getType(){
        String expected_race = "Chat";

        Piece localisation = new Piece("Salon");
        Animal testAnimal = new Animal("Tamagotchi", "Chat", localisation);

        // Cas sans erreur

        assertEquals(expected_race,testAnimal.getType());

        // Cas avec erreur

        String notExpected_race = "Lapin";
        assertNotEquals(notExpected_race,testAnimal.getType());
    }

}
