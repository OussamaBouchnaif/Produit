package Services;

import Servlet.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitServiceTest {

    private ProduitService produitService;

    @BeforeEach
    void setUp() {
        // Initialisation avant chaque test
        produitService = new ProduitService();
    }

    @Test
    void testAjouterProduit() {
        Produit produit = new Produit(1L, "Ordinateur", 999.99, 5);
        produitService.ajouterProduit(produit);
        assertNotNull(produitService.obtenirProduitParId(1L));
    }

    @Test
    void testObtenirProduitParId() {
        Produit produit = new Produit(1L, "Téléphone", 599.99, 10);
        produitService.ajouterProduit(produit);
        assertEquals(produit, produitService.obtenirProduitParId(1L));
    }

    @Test
    void testMettreAJourProduit() {
        Produit produit = new Produit(1L, "Tablette", 299.99, 8);
        produitService.ajouterProduit(produit);

        Produit nouveauProduit = new Produit(1L, "Nouvelle Tablette", 349.99, 5);
        produitService.mettreAJourProduit(nouveauProduit);

        assertEquals("Nouvelle Tablette", produitService.obtenirProduitParId(1L).getNom());
        assertEquals(349.99, produitService.obtenirProduitParId(1L).getPrix());
        assertEquals(5, produitService.obtenirProduitParId(1L).getQuantite());
    }

    @Test
    void testSupprimerProduit() {
        Produit produit = new Produit(1L, "Laptop", 1299.99, 3);
        produitService.ajouterProduit(produit);
        produitService.supprimerProduit(1L);
        assertNull(produitService.obtenirProduitParId(1L));
    }
    @Test
    void testProduitExiste() {
        Produit produit = new Produit(1L, "Souris", 19.99, 50);
        produitService.ajouterProduit(produit);
        assertTrue(produitService.produitExiste(1L));
        assertFalse(produitService.produitExiste(2L));
    }

    @Test
    void testNomProduitExiste() {
        Produit produit = new Produit(1L, "Clavier", 29.99, 30);
        produitService.ajouterProduit(produit);
        assertTrue(produitService.nomProduitExiste("Clavier"));
        assertFalse(produitService.nomProduitExiste("Souris"));
    }

}