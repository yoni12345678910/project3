import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        String userName;
        String passwordNum;
        System.out.println("Please enter user name and password");
        userName= scanner.next();
        passwordNum= scanner.next();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yonil\\chromedriver.exe");
        ChromeDriver driver =new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();
        WebElement personalInfoElement = driver.findElement(By.cssSelector("a[href='https://portal.aac.ac.il']"));
        personalInfoElement.click();
        WebElement username = driver.findElement(By.id("Ecom_User_ID"));
        username.sendKeys(userName);
        WebElement password = driver.findElement(By.id("Ecom_Password"));
        password.sendKeys(passwordNum);
        WebElement enterInfoButton = driver.findElement(By.className("submit"));
        enterInfoButton.click();
        WebElement enterMoodle = driver.findElement(By.cssSelector("a[href='https://moodle.aac.ac.il/login/index.php']"));
        enterMoodle.click();
        Thread.sleep(3000);
        WebElement reshima = driver.findElement(By.id("displaydropdown"));
        reshima.click();
        WebElement takzir = driver.findElement(By.linkText("תקציר הקורס"));
        takzir.click();
        List<WebElement> listCurses = driver.findElements(new By.ByTagName("h6"));
        System.out.println("your list curses is:");
        for (int i = 0; i < listCurses.size()-4 ; i++) {
            System.out.println( (i+1) +")" + listCurses.get(i).getText());
        }
        int cshoose;
        System.out.println("Choose a curs number");
        cshoose=scanner.nextInt();
        WebElement pressCurs=listCurses.get(cshoose-1);
        pressCurs.click();
        WebElement press=driver.findElement(By.className("userbutton"));
        press.click();
        WebElement out=driver.findElement(By.id("actionmenuaction-6"));
        out.click();
        WebElement exit=driver.findElement(By.cssSelector("a[href='https://portal.aac.ac.il/AGLogout']"));
        exit.click();









    }
}
