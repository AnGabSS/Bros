package br.com.nulog.bros.user.infra.gateways;

import br.com.nulog.bros.shared.config.BrosConfiguration;
import br.com.nulog.bros.user.application.gateways.ITokenGateway;
import br.com.nulog.bros.user.domain.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class TokenGatewayImpl implements ITokenGateway {

    private final String SECRET;
    private final String ISSUER;

    public TokenGatewayImpl(BrosConfiguration configuration){
        this.SECRET = configuration.secret_key();
        this.ISSUER = configuration.jwt_issuer();
    }

    @Override
    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withIssuedAt(creationDate())
                    .withExpiresAt(expirationDate())
                    .withSubject(user.id().toString())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JWTCreationException("Error generating token.", exception);
        }
    }

    @Override
    public String getSubjectFromToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Expired or Invalid token");
        }
    }

    private Instant creationDate(){
        return ZonedDateTime.now(ZoneId.of("America/Recife")).toInstant();
    }

    private Instant expirationDate(){
        return ZonedDateTime.now(ZoneId.of("America/Recife")).plusHours(8).toInstant();
    }
}