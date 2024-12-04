public class Lampadina {
    private String nome;
    private final float potenza;
    private int intensita;
    private String colore;
    private boolean accesa;

    /**
     * Costruttore : Inizializza una lampadina data una potenza
     * @param potenza
     */
    public Lampadina(float potenza){
        this.potenza = potenza;
        this.intensita = 50;
        this.colore = "Bianco";
        this.accesa = false;
        this.nome = "";
    }

    /**
     * Costruttore : Inizializza una lampadina dati una potenza e un nome
     * @param potenza
     * @param nome
     */
    public Lampadina(float potenza, String nome){
        this.potenza = potenza;
        this.intensita = 50;
        this.colore = "Bianco";
        this.accesa = false;
        this.nome = nome;
    }

    /**
     * Costruttore di copia : Inizializza una lampadina uguale ad un'altra passata per parametro
     * @param l
     */
    public Lampadina(Lampadina l){
        this.potenza = l.potenza;
        this.intensita = l.intensita;
        this.colore = l.colore;
        this.accesa = l.accesa;
        this.nome = l.nome;
    }

    public void accendi(){
        this.accesa = true;
    }

    public void spegni(){
        this.accesa = false;
    }

    /**
     * Ritorna l'attributo "accesa" (true/false)
     * @return accesa
     */
    public boolean isAcceso(){
        return this.accesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIntensita() {
        return intensita;
    }

    public void setIntensita(int intensita) {
        this.intensita = intensita;
        if (this.intensita < 0)
            this.intensita = 0;
        else if (this.intensita > 100)
            this.intensita = 100;
        else
            this.intensita = Math.round(this.intensita/10.0f)*10;
    }

    public void aumentaIntensita(){
        this.intensita += 10;
        if (this.intensita > 100)
            this.intensita = 100;
    }

    public void diminuisciIntensita(){
        this.intensita -= 10;
        if (this.intensita < 0)
            this.intensita = 0;
    }

    @Override
    public String toString() {
        return this.getNome() + " : " + this.potenza + "W" + " al " +
                this.intensita + "%" + " | accesa: " + this.accesa;
    }
}