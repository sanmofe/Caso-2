public class MarcoPagina {

    public boolean R;

    public int pagCargada;

    public boolean M;

    public int num;

    public MarcoPagina(int num) {
        R = false;
        M = false;
        this.num = num;
        pagCargada = 0;
    }

    public synchronized boolean haSidoModificada() { return  M; }

    public synchronized void cambiarModificada(){ M = !M; }

    public synchronized boolean haSidoReferenciada() { return R; }

    public synchronized void cambiarReferenciada(){
        R = !R;
    }

    public int darClase(){ //Retorna la clase de este marco de página
        if (!(R && M)) return 0;
        if (!R && M) return 1;
        if (R && !M) return 2;
        return 3;
    }

    public boolean estaVacio(){
        return pagCargada == 0;
    }

    public void cargarPag(int pagCargada){
        this.pagCargada = pagCargada;
    }


}
