/*
*
* Auteur:   Samuel Ferron - 1843659
*           William La Bereg - 1852751
* Date:     24 octobre 2017
*
* TP4
*
 */

import java.util.ArrayList;

// Implémentation de l'interface IBibliotheque
// à l'aide d'un arbre de recherche binaire.
public class BibliothequeBst implements IBibliotheque
{
    private BST<String> livres = new AvlTree<String>();

    // Complexité: O(log(n))
    // Explication:
    public void ajouterLivre(String livre)
    {
        livres.insert(livre);
    }

    // Complexité: O(log(n))
    // Explication:
    public boolean contientLivre(String livre) {
        return livres.contains(livre);
    }

    // Complexité: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre/ascendant.
    public String afficherLivresAlpha()
    {
        ArrayList<String> list = livres.traverseInOrder();
        String string = "";
        for(String e : list)
            string+=e+"\n";

        return string;
    }

    // Complexité: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre inverse/descendant.
    public String afficherLivresAlphaInverse()
    {
        ArrayList<String> list = livres.traverseReverseOrder();
        String string = "";
        for(String e : list)
            string+=e+"\n";

        return string;
    }
}