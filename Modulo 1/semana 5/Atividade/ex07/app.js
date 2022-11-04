import Time from "./Time.js";
import Partida from "./Partida.js";

const time = new Time('Joaca', 'JRC', 5, 1, 5, 10, 3)

time.exibirSituação()
const partida = new Partida('JRC', 3, 'VSC', 2)
time.computarPartida(partida)
time.exibirSituação()