package my.company.jwtparselib.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import my.company.jwtparselib.config.JwtParseProperties
import java.nio.charset.StandardCharsets
import java.util.*

class ParseTokenUtilServiceImpl constructor(private val properties: JwtParseProperties) : ParseTokenUtilService {
    override fun getValueFieldFromToken(token: String, field: String): String {
        val jws = getBodyOfToken(token)
        return jws.body.get(field, String::class.java)
    }

    private fun getBodyOfToken(token: String): Jws<Claims> {
        return Jwts.parser()
            .setSigningKey(Base64.getEncoder().encodeToString(properties.secretKey.toByteArray(StandardCharsets.UTF_8)))
            .parseClaimsJws(token)
    }
}