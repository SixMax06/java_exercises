public class Scheda {
    private String domanda;
    private String opzione1;
    private String opzione2;
    private String opzione3;
    private String opzione4;
    private int risposta;

    public Scheda(String s) {
        String[] split = s.split(";");
        domanda = split[0];
        opzione1 = split[1];
        opzione2 = split[2];
        opzione3 = split[3];
        opzione4 = split[4];
        risposta = Integer.parseInt(split[5].charAt(1) + "");
    }

    public int getRisposta() {
        return risposta;
    }

    @Override
    public String toString() {
        String res = "";
        res += domanda + "\n";
        res += "1." + opzione1 + "   ";
        res += "2." + opzione2 + "   ";
        res += "3." + opzione3 + "   ";
        res += "4." + opzione4 + "   ";
        return res;
    }
}
