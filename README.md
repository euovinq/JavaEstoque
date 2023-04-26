# Projeto de Controle de Estoque

Este projeto consiste em um programa de controle de estoque de uma loja, onde é possível cadastrar produtos, editá-los, gerar relatórios e verificar os produtos próximos à data de vencimento.

O programa foi desenvolvido em Java, utilizando a plataforma Eclipse IDE e a biblioteca padrão do Java. A seguir, será apresentada uma documentação das principais classes e métodos do projeto.

## Classes

### Produto

Representa um produto cadastrado no sistema. Possui os seguintes atributos:

- código (int)
- nome (String)
- marca (String)
- preço de venda (double)
- quantidade em estoque (int)
- data de fabricação (LocalDate)
- data de validade (LocalDate)
- código de barras (String)

Além disso, possui os seguintes métodos:

- getters e setters para todos os atributos
- toString(): retorna uma representação em String do produto

### Navegacao

Classe responsável por gerenciar a navegação do programa. Possui os seguintes métodos:

- cadastrarProduto(): recebe os dados de um produto e o adiciona à lista de produtos cadastrados
- cadastroDeItem(): exibe um formulário para cadastrar um novo produto
- menuPrincipal(): exibe o menu principal do programa
- relatorio(): gera um relatório com a lista de todos os produtos cadastrados
- diasValidade(): recebe um produto e retorna a quantidade de dias até a data de validade
- limparTela(): limpa o console
- voltarAoMenu(): exibe uma mensagem para o usuário pressionar enter para voltar ao menu principal

### Programa

Classe principal do programa. Possui o método main(), que é responsável por iniciar o programa e gerenciar a interação com o usuário.

## Métodos

- main(): método principal do programa. É responsável por exibir o menu principal, receber a entrada do usuário e chamar os métodos correspondentes.
- fmt.format(): método para formatar datas no padrão dd/MM/yyyy.
- sc.nextInt(): método para receber entrada do usuário como um número inteiro.
- Locale.setDefault(Locale.US): método para definir o formato de números com ponto como separador decimal.

## Considerações Finais

O projeto foi desenvolvido como um exercício de programação, visando aplicar os conceitos aprendidos em sala de aula. Portanto, há diversas melhorias e otimizações que poderiam ser feitas para tornar o programa mais eficiente e robusto. No entanto, o programa atende aos requisitos mínimos de funcionalidade propostos e pode ser utilizado como base para o desenvolvimento de sistemas mais complexos de controle de estoque.
