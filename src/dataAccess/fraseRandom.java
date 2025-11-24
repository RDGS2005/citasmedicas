package dataAccess;

import java.util.Random;

public class fraseRandom {
    private static Random r;
    private static final String[] frases = {"La primera riqueza es la salud",
                                "La salud es la mayor posesion",
                                "La salud es la base de todo",
                                "Profe ponganos 10",
                                "Recuerda hacer ejercicio regularmente",
                                "8 vasos de agua al dia",
                                "Duerme las 8 horas que yo no pude :(",
                                "Manten una dieta balanceada",
                                "Comprometidos con tu salud",
                                "Siempre pendientes de tu salud"};
    public fraseRandom()
    {
        r = new Random();
    }
    public static String frase()
    {
        return frases[r.nextInt(frases.length)];
    }
}
