
/**
 * un programme qui permet servant à modéliser un contact personnel. 
 * De plus, la classe Contact pourrait éventuellement servir dans une
 * application de gestion d'un carnet de contacts personnels où l'on 
 * pourrait ajouter/supprimer/modifier des contacts.
 * 
 * @author (Vahid Foruzanmehr)
 * @code permanant FORV26018703
 * @version (decembre 2022)
 */
public class Contact {
    //--------------
    //CONSTANTES
    //--------------
    
    //Valeurs par defaut pour les attributs
    public final static String NOM_DEFAUT = "Nom";
    public final static String PRENOM_DEFAUT = "Prenom";
    
    //--------------------
    //ATTRIBUTS D'INSTANCE
    //--------------------
    private String nom;
    private String prenom;
    private Telephone [] telephones = {};
    private Adresse adresse;
    private String [] courriels = {};
    private boolean favori;
    private static int nbrContactsFavoris = 0;
    
    
    /**
     * Ce constructeur construit un objet contact en initialisant ses 
     * attributs avec les valeurs passées en paramètre.
     *
     * @param nom le nom du contact. Si le paramètre nom est null ou vide,
     *  l'attribut nom de ce contact doit être initialisé à NOM_DEFAUT.
     * @param prenom le prenom du contact. Si le paramètre prenom est 
     *  null ou vide, l'attribut prenom de ce contact doit être initialisé 
     *  à PRENOM_DEFAUT.
     * @param tel le telephone du contatct. Si null, n’est pas ajouté
     * @param adresse l'adresse du contact. peut être null.
     * @param courriel le premier courriel à ajouter au tableau courriels
     *  de ce contact. Si null ou vide, n’est pas ajouté.
     * @param favori de contact , soit true pour etre favori ou false.
     */
    public Contact(String nom, String prenom,Telephone tel, Adresse adresse,  
                    String courriel, boolean favori) {
        if (nom != null && nom.length() != 0){  
            this.nom = nom;
        } else {
            this.nom = NOM_DEFAUT;
        }
        
        if (prenom !=null && !prenom.isEmpty()){  
            this.prenom = prenom;
        } else {
            this.prenom = PRENOM_DEFAUT;
        }
        
        this.adresse = adresse;
        
        // Si le paramètre tel est null, aucun téléphone n'est ajouté 
        // à ce contact (le tableau telephones demeure de longueur 0).
        // Sinon, le tel donné est ajouté au tableau telephones de ce 
        // contact (et le tableau devient de longueur 1).
        if (tel != null ) {
            ajouterTelephone(tel);
            
        }
        // Si le paramètre courriel est null ou vide, aucun courriel 
        // n'est ajouté à ce contact (le tableau courriels demeure de
        // longueur 0). Sinon, le courriel donné est ajouté au tableau 
        // courriels de ce contact (et le tableau devient de longueur 1).
        if (courriel != null && !courriel.isEmpty() ) {
            ajouterCourriel(courriel);
        }
        
        this.favori = favori;
        // true si ce contact est un favori, false sinon. 
        if (favori){
            this.nbrContactsFavoris++;
        }  
    }
    
    /**
     * 2eme Ce constructeur construit un objet contact en 
     * initialisant ses attributs avec les valeurs passées en paramètre.
     *
     * @param nom le nom du contact. Si le paramètre nom est null ou vide,
     *  l'attribut nom de ce contact doit être initialisé à NOM_DEFAUT.
     * @param prenom le prenom du contact. Si le paramètre prenom est 
     *  null ou vide, l'attribut prenom de ce contact doit être initialisé 
     *  à PRENOM_DEFAUT.
     * @param adresse l'adresse du contact. peut être null.
     * @param favori de contact va etre false.
     */
    public Contact(String nom, String prenom, Adresse adresse ) {
        this(nom, prenom, null, adresse, null , false);
            
    }
    
    /**
     * Permet d'obtenir le nom de contact.
     * @return le nom de contact.
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * Permet d'obtenir le prenom de contact.
     * @return le prenom de contact.
     */
    public String getPrenom(){
        return prenom;
    }
    
    /**
     * Permet d'obtenir l'adresse de contact.
     * @return l'adresse de contact.
     */
    public Adresse getAdresse(){
        return adresse;
    }
    
    /**
     * Permet d'obtenir d'etre favori ou pas pour le contact.
     * @return le favori de contact.
     */
    public boolean isFavori(){
        return favori;
    }
    
    /**
     * Permet de modifier le nom de ce contact.
     * @param nom le nouveau nom.
     */
    public void setNom(String nom){
        // Si le paramètre est null ou vide, la modification n’est pas effectuée
        if(nom != null && nom.length() != 0){
            this.nom = nom;
        }
    }
    
    /**
     * Permet de modifier le prenom de ce contact.
     * @param prenom le nouveau prenom.
     */
    public void setPrenom(String prenom){
        // Si le paramètre est null ou vide, la modification n’est pas effectuée
        if(prenom != null && prenom.length() != 0){
            this.prenom = prenom;
        }
    }
    
    /**
     * Permet de modifier l'adresse de ce contact.
     * @param adresse le nouveau adresse.
     */
    public void setAdresse (Adresse adresse){
        this.adresse = adresse;
    }
    
    /**
     * Permet de modifier le favori de ce contact.
     * @param favori le nouveau situation de favori.
     */
    public void setFavori (boolean favori){
        // ajuster l’attribut de classe nbrContactsFavoris 
        // Si favori etait true et maintenant il est false, on diminue 
        //    un nbrContactsFavoris
        if (this.favori && !favori){
                nbrContactsFavoris--;
        } else if (!this.favori && favori){
                nbrContactsFavoris++;
        }
        this.favori = favori;
    }
    
    /**
     * Permet d’obtenir la valeur de l’attribut de classe 
     * nbrContactsFavoris.
     * 
     * @return nbrContactsFavoris qui est int.
     */
    public static int obtenirNbrContactsFavoris(){
        return nbrContactsFavoris;
    }
    
    /**
     * Permet de retourner le nombre de courriels associés à ce contact 
     * (le nombre de courriels dans le tableau courriels)
     * 
     * @return length de courriel qui nous donne le nombre de courriels 
     * associés à ce contact
     */
    public int nbrCourriels(){
        return courriels.length;
    }
    
    /**
     * Permet de retourner le nombre de téléphones associés à ce contact 
     * (le nombre de téléphones dans le tableau telephones) 
     * 
     * @return length de telephone qui est nombre de téléphones associés à ce contact
     */
    public int nbrTelephones(){
        return telephones.length ;
    }
    
    /**
     * Permet d’ajouter le tel donné en paramètre au tableau telephones
     * de ce contact. Pour ce faire, vous devez agrandir le tableau 
     * telephones d'une case, et ajouter le tel donné à la fin du tableau
     * (à la suite des autres téléphones). 
     * 
     * @param tel c est le téléphone à ajouter au tableau de téléphones 
     * de ce contact.
     */
    
    public void ajouterTelephone (Telephone tel){
        Telephone [] tmp = new Telephone [telephones.length + 1];
        // Si le tel donné est null, le téléphone n’est pas ajouté.
        if (tel != null ){
            for (int i = 0; i < telephones.length; i++){
                tmp[i] = telephones[i];
            }
            tmp[ tmp.length - 1] = tel;
            telephones = tmp;
        }
    }
    
    /**
     * Permet d’ajouter le courriel donné en paramètre au tableau
     * courriels de ce contact. Pour ce faire, vous devez agrandir
     * le tableau courriels d'une case, et ajouter le courriel 
     * donné à la fin du tableau (à la suite des autres courriels).
     * 
     * @param courriel Le courriel à ajouter au tableau de courriels
     * de ce contact.
     */
    public void ajouterCourriel (String courriel){
        String [] tmp = new String [courriels.length + 1];
        // Si le courriel donné est null ou vide, le courriel n’est pas ajouté.
        if ( courriel != null && courriel.length() != 0){
            for (int i = 0; i < courriels.length ; i++){
                tmp[i] = courriels[i];
            }
            tmp[ tmp.length - 1] = courriel;
            courriels = tmp;
        }
    }
    
    /**
     * Permet de supprimer le téléphone se trouvant à la position
     * donnée du tableau de téléphones de ce contact. Si la position
     * donnée ne correspond pas à un indice valide dans le tableau 
     * telephones, la suppression n'a pas lieu.
     * 
     * @param position : Spécifie la position dans le tableau telephones 
     *  de ce contact.
     * @return le téléphone qui a été supprimé du tableau telephones, 
     *      sinon, la méthode retourne null.
     */
    public Telephone supprimerTelephone(int position){
        Telephone result = null;
        Telephone [] tmp= new Telephone [telephones.length -1];
        // Si la suppression a lieu, la méthode retourne le téléphone qui a 
        // été supprimé du tableau telephones, sinon, la méthode retourne null.
        if (position < telephones.length && position >= 0){
            result = telephones[position];
            // La suppression à la position, que l'utilisateur rentre, dans le tableau initial. 
            // on met tous les elements qui sont plus petite que position comme avant.
            // on saut quand on arrive a element position et on met tous les elements qui
            // sont plus petite que position comme avant.
            for ( int i = 0; i < telephones.length -1; i++) {
                if ( i < position) {
                    tmp[i]= telephones[i];
                } else if (i > position ){
                    tmp [i] = telephones [i++];
                }
            }
            this.telephones = tmp;
        }
        return result;
    }
    
    /**
     * Permet de supprimer le courriel se trouvant à la position
     * donnée du tableau de courriels de ce contact. Si la position
     * donnée ne correspond pas à un indice valide dans le tableau 
     * courriels, la suppression n'a pas lieu.
     * 
     * @param position : Spécifie la position dans le tableau courriels 
     *  de ce contact.
     * @return le courriel qui a été supprimé du tableau courriels, 
     *      sinon, la méthode retourne null.
     */
    public String supprimerCourriel(int position){
        String result = null;
        String [] tmp = new String [courriels.length -1];
        if(position < courriels.length && position >= 0){
            result = courriels[position];
            // La suppression à la position, que l'utilisateur rentre, dans le tableau initial. 
            // on met tous les elements qui sont plus petite que position comme avant.
            // on saut quand on arrive a element position et on met tous les elements qui
            // sont plus petite que position comme avant.
            for ( int i = 0; i<courriels.length -1; i++) {
                if ( i < position) {
                    tmp[i]= courriels[i];
                } else if (i > position ){
                    tmp [i] = courriels [i++];
                }
            }
            this.courriels = tmp;
        } 
        return result;
    }
    
    /**
     * Permet d’obtenir le téléphone du tableau telephones
     * de ce contact qui se trouve à la position donnée. 
     * 
     * @param position : Spécifie la position dans le tableau telephones 
     *  de ce contact.
     * @return la telephone qu'on a besoin.
     */
    public Telephone obtenirTelephone(int position){
        Telephone tmp = null;
        // Si la position donnée ne correspond pas à un indice valide dans
        // le tableau telephones, la méthode retourne null.
        if ( position < telephones.length && position >= 0 ){
             tmp = telephones[position];
        }
        return tmp;
    }
    
    /**
     * Permet d’obtenir le courriel du tableau courriels de ce contact
     * qui se trouve à la position donnée. Si la position donnée
     * ne correspond pas à un indice valide dans le tableau courriels,
     * la méthode retourne null.
     *
     * @param position : Spécifie la position dans le tableau courriels 
     *  de ce contact.
     * @return la courriel qu'on a besoin.
     */
    public String obtenirCourriel (int position){
        String tmp = null;
        // Si la position donnée ne correspond pas à un indice valide dans
        // le tableau telephones, la méthode retourne null.
        if ( position < courriels.length && position >= 0 ){
            tmp = courriels[position];
        }
        return tmp;
    }
    
    /**
     * Permet de modifier les attributs du téléphone se trouvant à la position
     * donnée dans le tableau telephones de ce contact. 
     * Si la position donnée ne correspond pas à un indice valide dans le 
     * tableau telephones, aucune modification n'a lieu.
     * 
     * @param position : Spécifie la position dans le tableau telephones 
     *  de ce contact.
     * @param indReg l'indicatif regional de ce telephone
     * @param numero le numero de ce telephone.    
     * @param poste le poste telephonique de ce telephone.
     * @param type le type de ce telephone (portable, domicile, bureau...).
     */
    public void modifierTelephone (int position, String indReg, String numero 
                                    ,String poste, String type){
        if (indReg != null){
            telephones[position].setIndReg(indReg); 
        } 
        if (numero != null){
            telephones[position].setNumero(numero);
        } 
        if (poste != null){
            telephones[position].setPoste(poste);
        } 
        if (type != null){
            telephones[position].setType(type);
        }    
    }
    
    /**
     * Permet de remplacer le courriel se trouvant à la position donnée
     * dans le tableau courriels de ce contact par celui passé en paramètre.
     * Si la position donnée ne correspond pas à un indice valide dans 
     * le tableau courriels ou si le courriel donné est null ou vide, 
     * aucune modification n'a lieu.
     *
     * @param position : Spécifie la position dans le tableau courriels 
     *  de ce contact.
     * @param courriel : la nouvelle valeur pour le courriel à modifier.
     */
    public void modifierCourriel(int position, String courriel){
        // Si la position donnée ne correspond pas à un indice valide dans le tableau
        // courriels ou si le courriel donné est null ou vide, aucune modification 
        // n'a lieu.
        if(position < courriels.length && position >= 0 &&
            courriel != null && courriel.length() !=0){
            courriels[position] = courriel;
        }
    }
    
    /**
     * Permet d'obtenir une representation sous forme de chaine de caracteres de 
     * ce contact.
     * 
     * @return une representation sous forme de chaine de caracteres de 
     *  ce contact.
     */
    public String toString (){
        String all;
        // le nom (en majuscule), le prénom, et si le contact est un favori, 
        // on ajoute le mot favori entre crochets
        if (favori){
            all = nom.toUpperCase() + ", " + prenom + " [FAVORI]" + "\n\n" ;
        } else {
            all = nom.toUpperCase() + ", " + prenom + "\n\n" ;
        }  
        all = all + "TELEPHONE(S) :\n" ;
        
        if (telephones != null){
            for (int i=0; i < telephones.length; i++){
                all = all  + telephones[i] + "\n";
            }
        }
        
        if (adresse != null){
            all = all + "\n" + "ADRESSE : \n" + adresse + "\n";
        } else {
            all = all + "\n" + "ADRESSE :" + "\n";
        }
        all = all + "\n" + "COURRIEL(S) :" ;
        
        if (courriels != null ){
            for (int i=0; i < courriels.length; i++){
                all = all  + "\n" + courriels[i] ;
            }
        }        
        return all;
    }
}
