package br.com.vollclinica.converter;

import br.com.vollclinica.dto.EnderecoDto;
import br.com.vollclinica.entities.Endereco;

public class EnderecoConverter {

    public static Endereco toEndereco(EnderecoDto enderecoRequest){

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
    public static EnderecoDto toEnderecoDto(Endereco endereco){

        return EnderecoDto.builder()
                .uf(endereco.getUf())
                .cep(endereco.getCep())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .complemento(endereco.getComplemento())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .build();
    }
}
