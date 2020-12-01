/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p2;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

/**
 *
 * @author José Roberto Jiménez
 */
public class Kata5P2 {
    private static String fileName="email.txt";
    private static List<Mail> listMail;
    private static Histogram<String> histogram;
    
    public static void main(String[] args) {
        input();
        process();
        output();
        
    }
    
    private static void input(){
        listMail = MailListReader.read(fileName);
        
    }
    
    private static void process(){
        histogram = MailHistogramBuilder.build(listMail);
    }
    
    private static void output(){
        HistogramDisplay histoDisplay =new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}
