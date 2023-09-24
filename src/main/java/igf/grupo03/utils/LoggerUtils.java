/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.utils;

/**
 *
 * @author Leo
 */
public class LoggerUtils {
    
    public static String log(String msj, Object... values){
        return String.format(msj, values);
    }
    
}
