package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
   @NotNull(message = "A categoria é obrigatória")
   private Long idCategoria;

   @NotNull(message = "O Código é obrigatório")
   @NotBlank(message = "O Código não deve estar em branco")
   @Length(max = 20, message = "O Código deve ter no máximo 20 caracteres")
   private String codigo;

   @NotNull(message = "O Título é obrigatório")
   @NotBlank(message = "O Título é obrigatório")
   @Length(max = 100, message = "O Título deve ter no máximo 100 caracteres")
   private String titulo;

   private String descricao;

   @NotNull(message = "O Valor é obrigatório")
   @Min(value = 20, message = "O valor mínimo deve ser R$ 20")
   private Double valorUnitario;

   @Min(value = 1, message = "O tempo de entrega mínimo deve ser no mínimo 1 (minuto)")
   private Integer tempoEntregaMinimo;

   @Min(value = 1, message = "O tempo de entrega máximo deve ser no mínimo 1 (minuto)")
   private Integer tempoEntregaMaximo;

   public Produto build() {
      return Produto.builder()
            .codigo(codigo)
            .titulo(titulo)
            .descricao(descricao)
            .valorUnitario(valorUnitario)
            .tempoEntregaMinimo(tempoEntregaMinimo)
            .tempoEntregaMaximo(tempoEntregaMaximo)
            .build();
   }
}
