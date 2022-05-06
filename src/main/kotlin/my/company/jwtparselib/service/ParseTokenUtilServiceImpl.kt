package my.company.jwtparselib.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import my.company.jwtparselib.config.JwtParseProperties
import org.keycloak.TokenVerifier
import org.keycloak.representations.AccessToken
import java.nio.charset.StandardCharsets
import java.util.*

class ParseTokenUtilServiceImpl constructor(private val properties: JwtParseProperties) : ParseTokenUtilService {
    override fun getValueFieldFromToken(token: String, field: String, keycloak: Boolean): String {
        if (properties.secretKey.isNullOrEmpty()) {
            throw NullPointerException("Token not maybe null!!!")
        }

        return if (keycloak) {
            getInfoFromKeycloakToken(token, field)
        } else {
            val jws = getBodyOfToken(token)
            jws.body.get(field, String::class.java)
        }
    }

    private fun getBodyOfToken(token: String): Jws<Claims> {
        return Jwts.parser()
            .setSigningKey(
                Base64.getEncoder().encodeToString(properties.secretKey!!.toByteArray(StandardCharsets.UTF_8))
            )
            .parseClaimsJws(token)
    }

    private fun getInfoFromKeycloakToken(token: String, fieldName: String): String {
        val accessTokenTokenVerifier: TokenVerifier<AccessToken> =
            TokenVerifier.create(cutToken(token), AccessToken::class.java)

        val accessToken = accessTokenTokenVerifier.token
        return when (fieldName) {
            "username" -> accessToken.preferredUsername
            "userId" -> accessToken.subject
            "email" -> {
                return if (accessToken.email != null) accessToken.email else "unknown"
            }
            else -> ""
        }
    }

    private fun cutToken(token: String): String {
        return if (token.startsWith("Bearer ")) token.substring(6) else token
    }
}