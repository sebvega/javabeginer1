package org.vega.unit5app.ejemplos.models;

import org.junit.jupiter.api.Test;
import org.vega.unit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("amanda", new BigDecimal("1234"));
//        cuenta.setPersona("amanda");
        String esperado = "amanda";
        String real = cuenta.getPersona();
        assertNotNull(real);
        assertEquals(esperado, real);
        assertTrue(real.equals("amanda"));

    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("pepe", new BigDecimal("1000.123"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.123, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta1 = new Cuenta("julian", new BigDecimal("2222.2145"));
        Cuenta cuenta2 = new Cuenta("julian", new BigDecimal("2222.2145"));
//        assertNotEquals(cuenta1, cuenta2);
        assertEquals(cuenta1, cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.32", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("paco", new BigDecimal("1000.32"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.32", cuenta.getSaldo().toPlainString());
    }

    @Test
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
                    assertEquals("1000.123", cuenta2.getSaldo().toPlainString());
                },
                () -> {
                    assertEquals(3000, cuenta1.getSaldo().intValue());
                },
                () -> {
                    assertEquals(2, banco.getCuentas().size());
                },
                () -> {
                    assertEquals("servibanca sss", cuenta1.getBanco().getNombre());
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
}