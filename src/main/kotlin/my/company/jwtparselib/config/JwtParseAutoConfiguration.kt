package my.company.jwtparselib.config

import my.company.jwtparselib.service.ParseTokenUtilService
import my.company.jwtparselib.service.ParseTokenUtilServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(value = ["jwt.parse.service.enable"], havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(JwtParseProperties::class)
@ComponentScan("my.company")
class JwtParseAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    fun createParseTokenUtilService(@Autowired jwtParseProperties: JwtParseProperties): ParseTokenUtilService =
        ParseTokenUtilServiceImpl(jwtParseProperties)
}