package com.remediar.back_remediar.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.remediar.back_remediar.model.ItemEstoque;
import com.remediar.back_remediar.model.dto.ItemEstoqueDTO;

@Mapper(componentModel = "spring")
public interface ItemEstoqueMapper {

    /*
    default ItemEstoqueDTO toDTO(ItemEstoque entity) {
        if (entity == null || entity.getProduto() == null) {
            return null;
        }

        return new ItemEstoqueDTO(
                entity.getId(),
                entity.getProduto().getApresentacao(),
                entity.getProduto().getId(),
                entity.getDataValidade(),
                entity.getQuantidade()
        );
    }
    */

    @Mapping(source = "produto.apresentacao", target = "apresentacao")
    @Mapping(source = "produto.id", target = "produtoId")
    ItemEstoqueDTO toDTO(ItemEstoque entity);

    //@Mapping(source = "nomeComercialOrPrincipioAtivo", target = "produto.id")
    ItemEstoque toEntity(ItemEstoqueDTO dto);
}
