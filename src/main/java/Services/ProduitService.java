package Services;

import Servlet.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }


    public void ajouterProduit(Produit produit) {

        if (!produitExiste(produit.getId()) && !nomProduitExiste(produit.getNom())) {
            produits.add(produit);
        } else {

            System.out.println("Un produit avec le même ID ou nom existe déjà.");
        }
    }


    public Produit obtenirProduitParId(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }

        System.out.println("Produit non trouvé pour l'ID : " + id);
        return null;
    }

    public void mettreAJourProduit(Produit produit) {

        if (produitExiste(produit.getId())) {

            for (Produit p : produits) {
                if (p.getId().equals(produit.getId())) {
                    p.setNom(produit.getNom());
                    p.setPrix(produit.getPrix());
                    p.setQuantite(produit.getQuantite());
                    break;
                }
            }
        } else {

            System.out.println("Produit non trouvé pour la mise à jour. ID : " + produit.getId());
        }
    }


    public void supprimerProduit(Long id) {

        if (produitExiste(id)) {
            Produit produitASupprimer = null;
            for (Produit produit : produits) {
                if (produit.getId().equals(id)) {
                    produitASupprimer = produit;
                    break;
                }
            }
            produits.remove(produitASupprimer);
        } else {

            System.out.println("Produit non trouvé pour la suppression. ID : " + id);
        }
    }


    public boolean produitExiste(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    public boolean nomProduitExiste(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }
}

