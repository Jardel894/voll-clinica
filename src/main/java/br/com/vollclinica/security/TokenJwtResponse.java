package br.com.vollclinica.security;

public record TokenJwtResponse(
        String tokenJwt
) {

    public TokenJwtResponse(String tokenJwt){
        this.tokenJwt = tokenJwt;
    }
}
