package br.com.vollclinica.converter;

import br.com.vollclinica.dto.EnderecoRequest;
import br.com.vollclinica.entities.Endereco;

public class EnderecoConverter {

    public static Endereco toEndereco(EnderecoRequest enderecoRequest){

        return Endereco.builder()
                .uf(enderecoRequest.uf())
                .cep(enderecoRequest.cep())
                .bairro(enderecoRequest.bairro())
                .cidade(enderecoRequest.cidade())
                .complemento(enderecoRequest.complemento())
                .logradouro(enderecoRequest.logradouro())
                .numero(enderecoRequest.numero())
                .build();
    }
}
