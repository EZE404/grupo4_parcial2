import org.junit.*;

import java.time.LocalDate;

public class CuentaTest {

    public static final double DELTA = 0.2;
    private Cuenta cuentaOrigen;

    @Before
    public void before() {
        this.cuentaOrigen = new Cuenta();
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Fecha de transacción " + LocalDate.now());
    }

    @After
    public void after() {
        System.out.println("La cuenta quedó con " + cuentaOrigen.saldo);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("FIN de la transacción");
    }

    @Test
    public void testDepositarDinero() {
        System.out.println("-Depositar Dinero-");
        Assert.assertNotNull(cuentaOrigen);
        cuentaOrigen.depositarDinero(200);
        Assert.assertEquals(cuentaOrigen.saldo, 2200, DELTA);
    }

    @Test(expected = Exception.class)
    public void testRetirarDinero() throws Exception {
        System.out.println("-Intento retirar Dinero mayor al saldo...");
        cuentaOrigen.retirarDinero(5000);
    }

    @Test
    public void testTransferirCuentaNula() throws Exception {
        System.out.println("-Transferir Dinero-");
        Cuenta c2 = null;
        Assert.assertNull(c2);
        cuentaOrigen.transferirDinero(c2, 5000);
    }
}
