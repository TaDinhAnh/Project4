package com.demo.common;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import com.demo.models.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtils implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;

	private static String secret = Constant.jwtSecret;

	public static String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public static Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private static Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private static Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public static String generateToken(Account account) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, account);
	}

	@SuppressWarnings("unchecked")
	private static String doGenerateToken(Map<String, Object> claims, Account account) {
		@SuppressWarnings("rawtypes")
		Header header = Jwts.header();
		header.setType("jwt");
		return Jwts.builder().setHeader((Map<String, Object>) header)
				.setClaims(claims).setSubject(account.getFullname())
				.claim("fullname", account.getFullname())
				.claim("gmail", account.getGmail())
				.claim("role", account.getRole())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public static Boolean validateToken(String token, Account account) {
		final String username = getUsernameFromToken(token);
		return (username.equals(account.getFullname()) && !isTokenExpired(token));
	}
}
