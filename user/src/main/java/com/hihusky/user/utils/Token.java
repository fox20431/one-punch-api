package com.hihusky.user.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Token {

    static Algorithm algorithm = Algorithm.HMAC256("one_punch_hmac256");
    static String issuer = "one_punch";

    public static String generateToken(String username) {
        Date issuedAt = new Date();
        // generate expired time
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 180); // expires 180 days from now
        Date expiredAt = calendar.getTime();
        return JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiredAt)
                .withClaim("username", username)
                .sign(algorithm);
    }

    public static Map<String, String> getClaim(String token, String... claimName) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < claimName.length; i ++) {
            String claimValue = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getClaim(claimName[i])
                    .asString();
            map.put(claimName[i], claimValue);
        }
        return map;
    }
}
