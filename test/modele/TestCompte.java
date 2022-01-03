package modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestCompte {
	
	//////////////////////////////////
	//		Test Constructeur		//
	//////////////////////////////////
	
	@Test
	void testConstrucreur1() {
		String expected_utilisateur = "user1";
		String expected_mdp = "mdp1";
		String expected_mail = "user1@mail";
		UUID expected_id = new UUID(101010, 100011);
		HashSet<UUID> expected_partiesId = new HashSet<UUID>();
		
		UUID idTest = new UUID(101010, 100011);
		HashSet<UUID> partiesIdTest = new HashSet<UUID>();
		Compte testCompte = new Compte("user1", "mdp1", "user1@mail", idTest, partiesIdTest);
		assertNotNull(testCompte);
		assertEquals(expected_utilisateur,testCompte.getUtilisateur());
		assertEquals(expected_mdp,testCompte.getMdp());
		assertEquals(expected_mail,testCompte.getMail());
		assertEquals(expected_id,testCompte.getId());
		assertEquals(expected_partiesId, testCompte.getPartiesId());
	}
	
	@Test
	void testConstructeur2() {
		String expected_utilisateur = "user1";
		String expected_mdp = "mdp1";
		String expected_mail = "user1@mail";
		HashSet<UUID> expected_partiesId = new HashSet<UUID>();

		Compte testCompte = new Compte("user1", "mdp1", "user1@mail");
		assertNotNull(testCompte);
		assertEquals(expected_utilisateur,testCompte.getUtilisateur());
		assertEquals(expected_mdp,testCompte.getMdp());
		assertEquals(expected_mail,testCompte.getMail());
		assertEquals(expected_partiesId, testCompte.getPartiesId());
	}
	
	//////////////////////////////
	//		Test Getters		//
	//////////////////////////////
	
	@Test
	public void testGetUtilisateur() {
		String expected_utilisateur = "user1";

        Compte testCompte = new Compte("user1", "mdp1", "user1@mail");

        // Cas sans erreur

        assertEquals(expected_utilisateur,testCompte.getUtilisateur());

        // Cas avec erreur

        String notExpected_utilisateur = "user2";
        assertNotEquals(notExpected_utilisateur,testCompte.getUtilisateur());
	}
	
	@Test
	public void testGetMdp() {
		String expected_mdp = "mdp1";

        Compte testCompte = new Compte("user1", "mdp1", "user1@mail");

        // Cas sans erreur

        assertEquals(expected_mdp,testCompte.getMdp());

        // Cas avec erreur

        String notExpected_mdp = "mdp2";
        assertNotEquals(notExpected_mdp,testCompte.getMdp());
	}
	
	@Test
	public void testGetMail() {
		String expected_mail = "user1@mail";

        Compte testCompte = new Compte("user1", "mdp1", "user1@mail");

        // Cas sans erreur

        assertEquals(expected_mail,testCompte.getMail());

        // Cas avec erreur

        String notExpected_mail = "mail@user1";
        assertNotEquals(notExpected_mail,testCompte.getMail());
	}
	
	@Test
	public void testGetId() {
		UUID expected_id = new UUID(101010, 100011);

		UUID idTest = new UUID(101010, 100011);
		HashSet<UUID> partiesIdTest = new HashSet<UUID>();
		Compte testCompte = new Compte("user1", "mdp1", "user1@mail", idTest, partiesIdTest);

        // Cas sans erreur

        assertEquals(expected_id,testCompte.getId());

        // Cas avec erreur

        UUID notExpected_id = new UUID(111111,000000);
        assertNotEquals(notExpected_id,testCompte.getId());
	}
	
	@Test
	public void testGetPartiesId() {
		UUID id = new UUID(101011, 100011);
		HashSet<UUID> expected_partiesId = new HashSet<UUID>();
		expected_partiesId.add(id);

		UUID idTest = new UUID(101010, 100011);
		HashSet<UUID> partiesIdTest = new HashSet<UUID>();
		partiesIdTest.add(id);
		Compte testCompte = new Compte("user1", "mdp1", "user1@mail", idTest, partiesIdTest);

        // Cas sans erreur

        assertEquals(expected_partiesId,testCompte.getPartiesId());

        // Cas avec erreur

        HashSet<UUID> notExpected_partiesId = new HashSet<UUID>();
        assertNotEquals(notExpected_partiesId,testCompte.getPartiesId());
	}
	
	//////////////////////////////
	//		Test Methodes		//
	//////////////////////////////
	
	@Test
	public void testSetMdp() {
		String expected_mdp = "mdp1";

        Compte testCompte = new Compte("user1", "mdp", "user1@mail");

        // Cas sans erreur
        
        testCompte.setMdp("mdp1");
        assertEquals(expected_mdp,testCompte.getMdp());
	}
	
	@Test
	public void testAddPartie() {
		UUID id1 = new UUID(101011, 100011);
		UUID id2 = new UUID(100001,011110);
		HashSet<UUID> expected_partiesId = new HashSet<UUID>();
		expected_partiesId.add(id1);
		expected_partiesId.add(id2);

		UUID idTest = new UUID(100000,000001);
		HashSet<UUID> partiesIdTest = new HashSet<UUID>();
		Compte testCompte = new Compte("user1", "mdp1", "user1@mail", idTest, partiesIdTest);
		testCompte.addPartie(id1);
		testCompte.addPartie(id2);
		
		assertEquals(expected_partiesId,testCompte.getPartiesId());
	}
	
	@Test
	public void testSupprPartieId() {
		UUID id1 = new UUID(101011, 100011);
		UUID id2 = new UUID(100001,011110);
		UUID id3 = new UUID(101001,011110);
		HashSet<UUID> expected_partiesId = new HashSet<UUID>();
		expected_partiesId.add(id1);
		expected_partiesId.add(id3);

		UUID idTest = new UUID(100000,000001);
		HashSet<UUID> partiesIdTest = new HashSet<UUID>(); 
		Compte testCompte = new Compte("user1", "mdp1", "user1@mail", idTest, partiesIdTest);
		testCompte.addPartie(id1);
		testCompte.addPartie(id2);
		testCompte.addPartie(id3); 
		
		testCompte.supprPartieId(id2);
		assertEquals(expected_partiesId,testCompte.getPartiesId());   
	}
}
