package ru.laba1;

import com.fastcgi.FCGIInterface;
import ru.laba1.process.PrintError;
import ru.laba1.process.Response;
import ru.laba1.reading.CoordinatesReader;
import ru.laba1.validation.ValidateService;

public class FCGIRequests {
    public void handle() {
        FCGIInterface fcgiInterface = new FCGIInterface();
        while (fcgiInterface.FCGIaccept() >= 0) {
            try {
                Response response = new Response();
                ValidateService validateService = new ValidateService();
                String resp = response.returnResponse(validateService.validate(), CoordinatesReader.allTime);
                System.out.println(resp);

            } catch (Exception e) {
                PrintError.error("Невозможно обработать запрос" + e.getMessage());
            }
        }
    }
}
