
package Runner;

import io.appium.java_client.android.AndroidDriver;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepDefinition.diligenciarFormulario;


public class runnerMobile {
    
    final static  String URL = "https://demoqa.com/automation-practice-form";
    final static  String User_BrowserStack = "briansteveocampo_C0xN5B";
    final static  String Key_BrowserStack = "LB7sGGypPHNiFvRpmsZq";
    
    WebDriver driver=null;
    AndroidDriver driverMobile = null;
    
    String name = "";
    String lastName = "";
    String email = "";
    String gender = "";
    String mobile = "";
    int month = 0;
    int year = 0;
    int day = 0;
    String subject = "";
    String hobbie = "";
    String currentAddress = "";
    
    diligenciarFormulario DiligenciarFormulario = new diligenciarFormulario();
    
   @BeforeClass
   public void cargarAmbiente(){
   
       driverMobile = DiligenciarFormulario.crearAndroidDriverRemote(User_BrowserStack, Key_BrowserStack);
       
       /* cambiar el contexto de una app nativa, por un WEBVIEW */
       Set<String> contextNames = driverMobile.getContextHandles();
       driverMobile.context(contextNames.toArray()[1].toString());        
       driver = driverMobile;
       DiligenciarFormulario.cargarPagina(driver, URL);
   }
   
   @Test
   public void probarFomularioWeb(){
   
       name = "Brian";
       lastName = "Ocampo";
       email = "brianocampo@hotmail.com";
       gender = "Male";
       mobile = "3504044700";
       month = 9;
       year = 1989;
       day = 19;
       subject = "Arts";
       hobbie = "Music";
       currentAddress = "Diagonal 59 # 32 - 02 apto 175";
       DiligenciarFormulario.diligenciarFormulario(driver,name,lastName,email,gender,mobile,month,year,day,subject,hobbie,currentAddress);
   }
   
   @AfterClass
   public void finalizarTest(){   
       DiligenciarFormulario.cerrarDriver(driver);
   }
    
}
