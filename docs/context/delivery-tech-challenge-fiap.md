# TECH CHALLENGE | FIAP

## O Problema

<div style="text-align: justify">

Há uma lanchonete de bairro que está expandindo devido seu grande sucesso. Porém, com a expansão e sem um sistema de 
controle de pedidos, o atendimento aos clientes pode ser caótico e confuso. Por exemplo, imagine que um cliente faça um 
pedido complexo, como um hambúrguer personalizado com ingredientes específicos, acompanhado de batatas fritas e uma 
bebida. O atendente pode anotar o pedido em um papel e entregá-lo à cozinha, mas não há garantia de que o pedido será 
preparado corretamente.

Sem um sistema de controle de pedidos, pode haver confusão entre os atendentes e a cozinha, resultando em atrasos na 
preparação e entrega dos pedidos. Os pedidos podem ser perdidos, mal interpretados ou esquecidos, levando à insatisfação
dos clientes e a perda de negócios.

Em resumo, um sistema de controle de pedidos é essencial para garantir que a lanchonete possa atender os clientes de 
maneira eficiente, gerenciando seus pedidos e estoques de forma adequada. Sem ele, expandir a lanchonete pode acabar não
dando certo, resultando em clientes insatisfeitos e impactando os negócios de forma negativa.

Para solucionar o problema, a lanchonete irá investir em um sistema de autoatendimento de fast food, que é composto por 
uma série de dispositivos e interfaces que permitem aos clientes selecionar e fazer pedidos sem precisar interagir com 
um atendente, com as seguintes funcionalidades:

</div>

<details open>

<summary> <b>Etapa 01 - Cliente</b> </summary>

### Pedido

<div style="text-align: justify">

Os clientes são apresentados a uma interface de seleção na qual podem optar por se identificarem via CPF, se cadastrarem
com nome, e-mail ou não se identificar, podendo montar o combo na seguinte sequência, sendo todas elas opcionais:

</div>

1. **Lanche**
2. **Acompanhamento**
3. **Bebida**

Em cada etapa é exibido o nome, descrição e preço de cada produto.

### Pagamento

<div style="text-align: justify">

O sistema deverá possuir uma opção de pagamento integrada para MVP. A forma de pagamento oferecida será via QRCode do 
Mercado Pago.

</div>

### Acompanhamento

<div style="text-align: justify">

Uma vez que o pedido é confirmado e pago, ele é enviado para a cozinha para ser preparado. Simultaneamente deve aparecer
em um monitor para o cliente acompanhar o progresso do seu pedido com as seguintes etapas:

</div>

- **Recebido**
- **Em preparação**
- **Pronto**
- **Finalizado**

### Entrega

<div style="text-align: justify">

Quando o pedido estiver pronto, o sistema deverá notificar o cliente que ele está pronto para retirada. Ao ser retirado,
o pedido deve ser atualizado para o status finalizado.

</div>

Além das etapas do cliente, o estabelecimento precisa de um acesso administrativo:

</details>

Além das etapas do cliente, o estabelecimento precisa de um acesso administrativo:

<details open>
<summary> <b>Etapa 02 - Acesso Administrativo</b> </summary>

### Gerenciar clientes

Com a identificação dos clientes o estabelecimento pode trabalhar em campanhas promocionais.

### Gerenciar produtos e categorias

<div style="text-align: justify">

Os produtos dispostos para escolha do cliente serão gerenciados pelo estabelecimento, definindo nome, categoria, preço, 
descrição e imagens. Para esse sistema teremos categorias fixas:

</div>

- **Lanche**
- **Acompanhamento**
- **Bebida**
- **Sobremesa**

<div style="text-align: justify">

> **Acompanhamento de pedidos:** Deve ser possível acompanhar os pedidos em andamento e tempo de espera de cada pedido.

</div>

<div style="text-align: justify">

> As informações dispostas no sistema de pedidos precisarão ser gerenciadas pelo estabelecimento através de um painel 
> administrativo.

</div>

</details>