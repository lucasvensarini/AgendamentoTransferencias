# AgendamentoTransferencias

Como dito no enunciado, o usuário pode agendar e ver as transferências agendadas. Por isso, foi criado uma classe usuário com um nome, apenas para identificação, e um objeto AgendadorTarefas. Esse objeto é o que, de fato, terá a responsabilidade de salvar e listar as transferências. Uma List foi usada como forma de armazenamento.

A classe Conta recebe o número e o usuário no construtor.

Uma classe TransferenciaBase com as propriedades comuns a todas as transferências foi criada e como cada tipo de transferêcnia calcula a taxa de forma diferente, uma interface foi criada visando o polimorfismo. Para garantir que todas transferências terão as propriedades necessárias, cada tipo recebe a TransferenciaBase no construtor. A ideia era que cada tipo calculasse a taxa de seu próprio jeito, mas o tipo D utiliza as formas de cálculo de outros tipos. Por isso, foram criadas classes Calculadoras para encapsular a forma de calculo da taxa. Elas ficam responsáveis pelos cálculos e, dessa forma, as transferências do tipo D podem usá-las de acordo com suas regras.

Algumas validações foram adicionadas (not null, valor negativo e padrão do número da conta no formato XXXXX-X). Nenhum framework de validação foi utilizado.

Foram feitos testes unitários para testar se a forma de cálculo foi desenvolvida corretamente. Outras classes não foram testadas, pois são basicamente atribuições e chamadas de métodos do próprio Java, que já são testados.
