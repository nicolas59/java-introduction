public interface AutoRoute {

    /**
     * retourne la categorie afin de calculer le prix du péage
     *
     * @return
     */
    int getCategorie();

    /**
     * calcule le prix du péage.
     *
     * @return prix du péage
     */
    default double calulerPrixPeage(){
        return getCategorie() * 15;
    }
}
