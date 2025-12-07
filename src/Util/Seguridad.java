/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author danny
 */
public class Seguridad {
    public static String hashearContrasena(String contra){
        return contra + "@hash";
    }
    // maes la picha esa del @hash es mas que todo como un formato que se hace para poder distinguir lo del hash pero de ahi poco mas 
    public static boolean verificarContrasena(String contra,String storedHash){
        String hashGenerado =hashearContrasena(contra);
        return hashGenerado.equals(storedHash);
    }
    
}
