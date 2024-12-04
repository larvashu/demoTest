package baseClasses;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BaseReport{

    @Step("Dodanie treści odpowiedzi do raportu")
    public void addReposnseToReport(Response response){
        Allure.addAttachment("Response body: ", response.prettyPrint());
    }
    @Step("Dodanie treści błędu do raportu")
    public void addErrorToReport(Throwable e){
        Allure.addAttachment("Opis błędu: ", e.getMessage());
    }
}
