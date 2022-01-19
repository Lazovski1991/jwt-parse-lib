package my.company.jwtparselib.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt.parse.service")
data class JwtParseProperties(
    var enable: Boolean = true,
    var secretKey: String = "secretKey"
)