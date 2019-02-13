/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demoJavaPhantomJs.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ext_ealinares
 */
public class PrincipalPage {

    public int main() {

        int returnCode = 1;

       
         
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability("IsJavaScriptEnabled", true);
        Capabilities.setCapability("applicationCacheEnabled", false);
        Capabilities.setCapability("phantomjs.page.settings.userAgent", "Mozilla / 5.0(Windows NT 6.1) AppleWebKit / 537.36(KHTML, like Gecko) Chrome / 40.0.2214.94 Safari / 537.36");
        String pathcurrentproject = System.getProperty("user.dir");
        String pathtoBinary = "\\phantomjs\\phantomjs.exe";
        
        pathcurrentproject = pathcurrentproject.concat(pathtoBinary);
                
        Capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, pathcurrentproject);

        PhantomJSDriverService driverService = PhantomJSDriverService.createDefaultService(Capabilities);

        WebDriverManager.phantomjs().setup();
          
        WebDriver _driver = new PhantomJSDriver(driverService, Capabilities);

        String _baseUrl = "http://datos.gob.cl/dataset";

        _driver.navigate().to(_baseUrl);

        try {
            WebElement element = _driver.findElement(By.name("q"));
            String stringToSearchFor = "Polinómico";
            element.sendKeys(stringToSearchFor);
            element.submit();

            System.out.println("OK");

        }
        catch (NoSuchElementException ex) { }
        catch (StaleElementReferenceException e) { }

        String _url = _driver.getCurrentUrl();

        _driver.quit();
        
        try {    
            Document doc = Jsoup.connect(_url).get();
            Elements links = doc.select("a[href]");
            
            //links.attr("class");
            
            //links.hasClass("class") 
            
            Elements mas  =    links.attr("class", "href");
            
            
            
            //links.hasClass("links.attr(pathtoBinary);")
            
            
             System.out.println("OK");
             
        }
        catch (IOException ex) {
            Logger.getLogger(PrincipalPage.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
//
//        HtmlWeb web = new HtmlWeb();
//        HtmlDocument document = web.Load(_url);
//
//        var hrefList = document.DocumentNode.SelectNodes("//a")
//                .Where(d = 
//                        > //d.Attributes.Contains("class")
//                        //&&
//                        d.Attributes.Contains("href")
//                        && d.InnerText.Contains("Índices")
//                )
//                .Select(p =  > new 
//        {
//            stranio = p.InnerText.Where(Char.IsDigit)
//            ,url = p.GetAttributeValue("href", "not found").ToString() 
//            ,intanio = 0
//        }
//        )
//                                    .
//        ToList();
//
//        string numero;
//        int numeroint;
//
//        List<urlPaginas> lstUpag = new List<urlPaginas>();
//
//        foreach(var item in hrefList
//        
//            )
//            {
//                numero = string.Empty;
//
//            urlPaginas upag = new urlPaginas();
//
//            upag.url = string.Concat("http://datos.gob.cl", item.url);
//
//            foreach(var item2 in item.stranio
//            
//                )
//                {
//
//                    numero = string.Concat(numero, item2);
//
//            }
//            int.TryParse(numero
//            ,out numeroint
//            ) ;
//                upag.anio = numeroint;
//
//            lstUpag.Add(upag);
//        }
//
//        int maxyear = lstUpag.Select(p =  > p.anio).Max();
//
//        lstUpag.RemoveAll(p =  > p.anio != maxyear);
//
//        _driver.Quit();
//
        return returnCode;

   }
//
//    private static void GetListUrlToDocuments(HtmlDocument document) {
//        var hrefList = document.DocumentNode.SelectNodes("//a")
//                .Where(d = 
//                        > d.Attributes.Contains("class")
//                        && d.Attributes["class"].Value.Contains("label"))
//                .Select(p =  > p.GetAttributeValue("href", "not found"))
//                .ToList();
//    }



}
