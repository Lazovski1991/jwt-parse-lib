package my.company.jwtparselib.service

interface ParseTokenUtilService {
    fun getValueFieldFromToken(token: String, field: String, keycloak: Boolean): String
}