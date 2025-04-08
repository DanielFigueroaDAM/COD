public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int puntosJugador1, int puntosJugador2) {
        String score = "";
        int tempScore=0;

        if (esEmpate(puntosJugador1, puntosJugador2)) {
            switch (puntosJugador1)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (puntosJugador1 >=4 || puntosJugador2 >=4)
        {
            int minusResult = puntosJugador1-puntosJugador2;
            if (esEmpate(minusResult, 1)) score ="Advantage player1";
            else if (esEmpate(minusResult, -1)) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (esEmpate(i, 1)) tempScore = puntosJugador1;
                else { score+="-"; tempScore = puntosJugador2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }

        }
    return score;
    }

    private static boolean esEmpate(int puntosJugador1, int puntosJugador2) {
        return puntosJugador1 == puntosJugador2;
    }
}