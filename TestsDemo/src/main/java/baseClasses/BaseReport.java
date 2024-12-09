package baseClasses;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

public class BaseReport{

    //W przypadku uzycia API
    @Step("Dodanie treści odpowiedzi do raportu")
    public void addReposnseToReport(Response response){
        Allure.addAttachment("Response body: ", response.prettyPrint());
    }
    @Step("Dodanie treści błędu do raportu")
    public void addErrorToReport(Throwable e){
        Allure.addAttachment("Opis błędu: ", e.getMessage());
    }

    public static void displayRaport() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("powershell", "-Command", "allure serve allure-results");
        processBuilder.start();
    }

}
