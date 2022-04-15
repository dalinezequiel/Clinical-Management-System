/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Dalin Ezequiel
 */
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
public class Data 
{
    public static LocalDateTime getLocalDateTime()
    {
        return LocalDateTime.now();
    }
    public static String getLocalDateTimeFormatted()
    {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        return dt.format(df);
    }
}
