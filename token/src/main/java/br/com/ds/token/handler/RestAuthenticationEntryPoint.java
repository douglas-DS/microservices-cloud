package br.com.ds.token.handler;

import br.com.ds.core.error.ResponseObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Calendar;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    @SneakyThrows
    public void commence(HttpServletRequest req,
                         HttpServletResponse res,
                         AuthenticationException ex) {

        int status = HttpStatus.FORBIDDEN.value();
        res.setStatus(status);

        ResponseObject responseObject = ResponseObject
                .builder()
                .timestamp(Calendar.getInstance().getTime())
                .status(status)
                .message("Token expired/not found and is required to access this resource")
                .path(req.getRequestURL().toString())
                .build();

        OutputStream out = res.getOutputStream();

        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();

        mapper.writeValue(out, responseObject);

        out.flush();



    }
}
