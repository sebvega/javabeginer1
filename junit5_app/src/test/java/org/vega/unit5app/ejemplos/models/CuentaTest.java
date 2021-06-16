package org.vega.unit5app.ejemplos.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.vega.unit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void initMetodTest(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo=testInfo;
        this.testReporter=testReporter;
        //aca se incerta esta seccion en cada instancia de cada test
        System.out.println("iniciando el metodo.");
        testReporter.publishEntry("ejecutando test info "+testInfo.getDisplayName()+" "+ testInfo.getTestMethod().get().getName()
                + " con las etiquetas "+ testInfo.getTags());
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("referenciando en cada test de la clase");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("pruebas de nombre en el saldo")
    class CuentaTestNombreSaldo {

        @Test
        @DisplayName("probando nombre de la cuenta")
        void testNombreCuenta() {
            System.out.println(testInfo.getTags());
            if (testInfo.getTags().contains("cuenta")){
                System.out.println("hacer algo con la etiqueta");
            }
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


    }

    @Nested
    class CuentaOperacionesTest {

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
        @DisplayName("probando dev")
        void testSaldoCuentaDev() {
            boolean esDev = "dev".equals(System.getProperty("ENV"));
            assumeTrue(esDev);
            Cuenta cuenta = new Cuenta("pepe", new BigDecimal("1000.123"));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.123, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        @DisplayName("probando dev 2")
        void testSaldoCuentaDev2() {
            boolean esDev = "dev".equals(System.getProperty("ENV"));
            assumingThat(esDev, () -> {                    //esta seccion hace que si la condicion que entra en primer valor esDev existe ejecuta esta seccion en la exprecion lambda, sino existe no la corre
                Cuenta cuenta = new Cuenta("pepe", new BigDecimal("1000.123"));
                assertNotNull(cuenta.getSaldo());
                assertEquals(1000.123, cuenta.getSaldo().doubleValue());
                assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
                assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
            });
        }

    }

    @Nested
    class SistemaOperativoTest {

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

    }

    @Nested
    class JavaVersionTest {

        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void soloJdk8() {
        }

        @Test
        @EnabledOnJre(JRE.JAVA_16)
        void soloJdk16() {
        }

    }

    @Nested
    class SystemPropertiesTest {

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


    }

    @Nested
    class VariableAmbienteTest {

        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + ": " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = "D:.*jdk-16.0.1.*")
        void testJavaHome() {

        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testProcesadoresVariable() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
        void testEnv() {
        }

    }

    @Tag("param")
    @Nested
    class PruebasParametrisadasTest {
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
        @DisplayName("probando el cobro en la cuenta de ahorros")
        void testDebitoCuentaValueSource(String monto) {
            Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
        @DisplayName("probando el cobro en la cuenta de ahorros")
        void testDebitoCuentaCsvSourse(String index, String monto) {
            System.out.println(index + ": " + monto);
            Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv")
        @DisplayName("probando el cobro en la cuenta de ahorros")
        void testDebitoCuentaCsvSourse2(String saldo, String monto, String esperado, String real) {

            Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(real);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, real);
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        @DisplayName("probando el cobro en la cuenta de ahorros")
        void testDebitoCuentaCsvFileSourse(String monto) {
            Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
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


    @RepeatedTest(value = 5, name = "Repeticion numero {currentRepetition} de {totalRepetitions}")
    @DisplayName("probando el cobro en la cuenta de ahorros")
    void testDebitoCuentaRepetir(RepetitionInfo info) {
        if (info.getCurrentRepetition()==3) {
            System.out.println(info.getCurrentRepetition());
        }
        Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.32", cuenta.getSaldo().toPlainString());
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    @DisplayName("probando el cobro en la cuenta de ahorros")
    void testDebitoCuentaMethodSourse(String monto) {
        Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    private static List<String> montoList() {
        return Arrays.asList("100", "200", "300", "500", "700", "1000");
    }

}