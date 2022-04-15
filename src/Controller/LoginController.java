/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.*;
/**
 *
 * @author Dalin Ezequiel
 */
public class LoginController 
{
    private static ArrayList<String> lista;
    public static ArrayList<String> listaPerfil()
    {
        lista = new ArrayList<String>();
        lista.add("Administrador");
        lista.add("Enfermeiro");
        lista.add("Medico");
        return lista;
    }
}
