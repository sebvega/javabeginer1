package org.vega.unit5app.ejemplos.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.vega.unit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    @BeforeEach
    void initMetodTest() {
        //aca se incerta esta seccion en cada instancia de cada test
        System.out.println("iniciando el metodo.");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("referenciando en cada test de la clase");
    }

    @Test
    @DisplayName("probando nombre de la cuenta")
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("amanda", new BigDecimal("1234"));
//        cuenta.setPersona("amanda");
        String esperado = "amanda";
        String real = cuenta.getPersona();
        assertNotNull(real, () -> "la cuenta no puede ser nula");
        assertEquals(esperado, real, () -> "el nombre de la cuenta no es como se esperaba");
        assertTrue(real.equals("amanda"));

    }

    @Test
    @DisplayName("probando saldo en la cuenta")
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("pepe", new BigDecimal("1000.123"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.123, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("probando referencia en las cuentas")
    void testReferenciaCuenta() {
        Cuenta cuenta1 = new Cuenta("julian", new BigDecimal("2222.2145"));
        Cuenta cuenta2 = new Cuenta("julian", new BigDecimal("2222.2145"));
//        assertNotEquals(cuenta1, cuenta2);
        assertEquals(cuenta1, cuenta2);
    }

    @Test
    @DisplayName("probando el cobro en la cuenta de ahorros")
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.32", cuenta.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("se prueba el ingreso de dinero en la cueta")
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.32", cuenta.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("verificando los fondos de la cuenta")
    void dinerInsuficienteException() {
        Cuenta cuenta = new Cuenta("martin", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1001));
        });
        String real = exception.getMessage();
        String esperado = "dinero insuficiente";
        assertEquals(esperado, real);
    }

    @Test
    @DisplayName("transfiriendo dinero de una cuenta a otra")
    void testTransferirDineroCuentas() {
        Cuenta cuenta1 = new Cuenta("pepe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("lala", new BigDecimal("1500"));

        Banco banco = new Banco();
        banco.setNombre("servibanca");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000", cuenta2.getSaldo().toPlainString());
        assertEquals(3000, cuenta1.getSaldo().intValue());
    }

    @Test
    //@Disabled
    @DisplayName("se verifica si las cuentas estan relacionadas a un banco con assertAll")
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("pepe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("lala", new BigDecimal("1500"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);
        banco.setNombre("servibanca");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        assertAll(() ->
                {
                    assertEquals("1000", cuenta2.getSaldo().toPlainString());
                },
                () -> {
                    assertEquals(3000, cuenta1.getSaldo().intValue());
                },
                () -> {
                    assertEquals(2, banco.getCuentas().size());
                },
                () -> {
                    assertEquals("servibanca", cuenta1.getBanco().getNombre());
                },
                () -> {
                    assertEquals("pepe", banco.getCuentas().stream()
                            .filter(c -> c.getPersona().equalsIgnoreCase("pepe"))
                            .findFirst()
                            .get()
                            .getPersona());
                });


        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equalsIgnoreCase("pepe")));

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows() {

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac() {

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNotWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void soloJdk8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_16)
    void soloJdk16() {
    }

    @Test
    void imprimirSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + ": " + v));

    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = ".*16.*")
//"16.0.1")
    void testJavaVersion() {

    }

    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testSolo64() {
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }

    @Test
    void imprimirVariablesAmbiente() {
        Map<String, String> getenv = System.getenv();
        getenv.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME",matches = "D:.*jdk-16.0.1.*")
    void testJavaHome() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS",matches = "8")
    void testProcesadoresVariable() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENVIROMENT",matches = "dev")
    void testEnv() {

    }
}