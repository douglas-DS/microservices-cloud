package br.com.ds.security.security.props;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author Douglas Souza on 25/04/2019
 */

@Configuration
//@ConfigurationProperties(prefix = "jwt.config")
@Getter
@Setter
@ToString
public class JWTConfig {

    private final String tokenAccessURL = "**/token/";

    private String privateKey = "Yw3BNElEl0txy9jUMXROQYCEz2UGMAmD";
    private int expiration = 3600;
    private String type = "signed";

    @NestedConfigurationProperty
    private Header header = new Header();

    @Getter
    @Setter
    public static class Header {
        private String prefix = "Bearer ";
        private String name = "Authorization";
    }
}
