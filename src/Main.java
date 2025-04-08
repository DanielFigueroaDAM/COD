public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int puntosJugador1, int puntosJugador2) {
        if (esEmpate(puntosJugador1, puntosJugador2)) {
            return extraerPuntuacionesDeEmpate(puntosJugador1);
        }
        else if (ventagaParaGanar(puntosJugador1, puntosJugador2))
        {
            return sacarVentagaParaGanarPuntuacion(puntosJugador1, puntosJugador2);
        }
        else
        {
            return getRegularScore(puntosJugador1, puntosJugador2, "");

        }
    }

private static String getRegularScore(int puntosJugador1, int puntosJugador2, String score) {
    score += obtenerPuntuacion(puntosJugador1);
    score += "-";
    score += obtenerPuntuacion(puntosJugador2);
    return score;
}

private static String obtenerPuntuacion(int puntos) {
    String[] puntuaciones = {"Love", "Fifteen", "Thirty", "Forty"};
    return (puntos >= 0 && puntos < puntuaciones.length) ? puntuaciones[puntos] : "";
}

    private static String sacarVentagaParaGanarPuntuacion(int puntosJugador1, int puntosJugador2) {
        String score;
        int minusResult = puntosJugador1 - puntosJugador2;
        if (esEmpate(minusResult, 1)) score ="Advantage player1";
        else if (esEmpate(minusResult, -1)) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static boolean ventagaParaGanar(int puntosJugador1, int puntosJugador2) {
        return puntosJugador1 >= 4 || puntosJugador2 >= 4;
    }

private static String extraerPuntuacionesDeEmpate(int puntosJugador1) {
    String[] puntuacionesDeEmpate = {"Love-All", "Fifteen-All", "Thirty-All", "Forty-All", "Deuce"};
    return (puntosJugador1 >= 0 && puntosJugador1 <= 3) ? puntuacionesDeEmpate[puntosJugador1] : puntuacionesDeEmpate[4];
}
    private static boolean esEmpate(int puntosJugador1, int puntosJugador2) {
        return puntosJugador1 == puntosJugador2;
    }
}