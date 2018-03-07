package com.atg.openssp.dataprovider.provider.handler;

import com.atg.openssp.core.cache.broker.dto.SiteDto;
import com.atg.openssp.core.system.LocalContext;
import com.atg.openssp.dataprovider.provider.dto.SiteMaintenanceDto;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.properties.ProjectProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author André Schmer
 */
public class SiteDataMaintenanceHandler extends DataHandler {
    private static final Logger log = LoggerFactory.getLogger(SiteDataMaintenanceHandler.class);
    public static final String CONTEXT = "/maintain/site";

    public SiteDataMaintenanceHandler(HttpServletRequest request, HttpServletResponse response) {
        if (LocalContext.isSiteDataServiceEnabled()) {
            try {
                String location;
                try {
                    location = ProjectProperty.getPropertiesResourceLocation()+"/";
                } catch (PropertyException e) {
                    log.warn("property file not found.");
                    location="";
                }
                Map<String,String> parms = queryToMap(request.getQueryString());
                String t = parms.get("t");

                if (LoginHandler.TOKEN.equals(t)) {

                    Gson gson = new Gson();
                    SiteMaintenanceDto dto = gson.fromJson(request.getReader(), SiteMaintenanceDto.class);
                    dto.getCommand();


                    String result = "{}";
                    response.setStatus(200);
                    response.setContentType("application/json; charset=UTF8");
                    OutputStream os = response.getOutputStream();
                    os.write(result.getBytes());
                    os.close();
                } else {
                    response.setStatus(401);
                }
            } catch (IOException e) {
                response.setStatus(500);
                log.error(e.getMessage(), e);
            }
        } else {
            response.setStatus(404);
        }
    }

    @Override
    public void cleanUp() {

    }

}
