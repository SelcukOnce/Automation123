package utils;


import java.io.File;

/**
 * 
 * 
 * September, 22 2019
 * @author onces
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class Common {
	
	private static Faker faker = new Faker();
	
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static String getRandomFirstName() {
    	return faker.firstName();
    	
    }
    public static String getRandomLastName() {
    	return faker.lastName();
    	
    }
    
    public static String getRandomEmail( String firstName, String lastName ) {
        String[] emails = { "@gmail.com", "@yahoo.com", "@hotmail.com", "@aol.com", "@hotmail.co.uk", "@hotmail.fr",
                "@msn.com", "@yahoo.fr", "@wanadoo.fr", "@orange.fr", "@comcast.net", "@yahoo.co.uk", "@yahoo.com.br",
                "@yahoo.co.in", "@live.com", "@rediffmail.com", "@free.fr", "@gmx.de", "@web.de", "@yandex.ru",
                "@ymail.com", "@libero.it", "@outlook.com", "@uol.com.br", "@bol.com.br", "@mail.ru", "@cox.net",
                "@hotmail.it", "@sbcglobal.net", "@sfr.fr", "@live.fr", "@verizon.net", "@live.co.uk",
                "@googlemail.com", "@yahoo.es", "@ig.com.br", "@live.nl", "@bigpond.com", "@terra.com.br", "@yahoo.it",
                "@neuf.fr", "@yahoo.de", "@alice.it", "@rocketmail.com", "@att.net", "@laposte.net", "@facebook.com",
                "@bellsouth.net", "@yahoo.in", "@hotmail.es", "@charter.net", "@yahoo.ca", "@yahoo.com.au",
                "@rambler.ru", "@hotmail.de", "@tiscali.it", "@shaw.ca", "@yahoo.co.jp", "@sky.com", "@earthlink.net",
                "@optonline.net", "@freenet.de", "@t-online.de", "@aliceadsl.fr", "@virgilio.it", "@home.nl", "@qq.com",
                "@telenet.be", "@me.com", "@yahoo.com.ar", "@tiscali.co.uk", "@yahoo.com.mx", "@voila.fr", "@gmx.net",
                "@mail.com", "@planet.nl", "@tin.it", "@live.it", "@ntlworld.com", "@arcor.de", "@yahoo.co.id",
                "@frontiernet.net", "@hetnet.nl", "@live.com.au", "@yahoo.com.sg", "@zonnet.nl", "@club-internet.fr",
                "@juno.com", "@optusnet.com.au", "@blueyonder.co.uk", "@bluewin.ch", "@skynet.be", "@sympatico.ca",
                "@windstream.net", "@mac.com", "@centurytel.net", "@chello.nl", "@live.ca", "@aim.com",
                "@bigpond.net.au" };
        return (firstName + "." + lastName + emails [ getRandomInt(0, emails.length) ]).toLowerCase();
    }
    
    public static int getRandomInt ( int min, int max ) {
        return (int)(Math.random() * (( max - min ) + 1 )) + min;
    }
    
    public static void deleteFiles ( String directoryPath ) {
        File file = new File(System.getProperty("user.dir") + directoryPath);
        for ( File file1 : file.listFiles() ) {
            boolean isFileDeleted = file1.delete();
            if ( isFileDeleted ) System.out.println("File \"" + file1.toPath().getFileName() 
                    + "\" deleted");
            else System.out.println("File \"" + file1.toPath().getFileName()
                    + "\" not deleted");

    			
    		}
    		
    	}
 }

