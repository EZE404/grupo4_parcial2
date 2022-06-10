import org.junit.*;

import java.time.LocalDate;

public class CuentaTest {

    private Cuenta cuenta;

    @Before
    public void before() {
        this.cuenta = new Cuenta();
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Fecha de transacción " + LocalDate.now());
    }

    @After
    public void after() {
        System.out.println("La cuenta quedó con " + cuenta.saldo);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("FIN de la transacción");
    }

    @Test
    public void testDepositarDinero() {
        System.out.println("-Depositar Dinero-");
        Assert.assertNotNull(cuenta);
        cuenta.depositarDinero(cuenta, 200);
        Assert.assertEquals(cuenta.saldo, 2200, 0.2);
    }

    @Test(expected = Exception.class)
    public void testRetirarDinero() throws Exception {
        System.out.println("-Intento retirar Dinero mayor al saldo...");
        cuenta.retirarDinero(5000);
    }

    @Test
    public void testTransferirCuentaNula() throws Exception {
        System.out.println("-Transferir Dinero-");
        Cuenta c2 = null;
        Assert.assertNull(c2);
        cuenta.transferirDinero(c2, 5000);
    }
}
