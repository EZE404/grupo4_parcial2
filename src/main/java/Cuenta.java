public class Cuenta {
    int nroCuenta;
    double saldo=2000;

    public void retirarDinero(double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("OJO! No hay saldo suficiente.");
        } else {
            this.saldo -= monto;
        }
    }
    public void depositarDinero(double monto){
        saldo += monto;
    }

    public void transferirDinero(Cuenta c2, double monto) throws Exception{
        this.retirarDinero(monto);
        c2.depositarDinero(monto);
    }

    public Cuenta(int nroCuenta, double saldo) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public Cuenta() { }
}
