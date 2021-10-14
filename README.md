# Microsserviços

- **Conceito**: Cada serviço cuida de um contexto específico da aplicação com seu próprio estado (repositório) e se comunica com as demais aplicações através de REST, eventos etc...
- **Service Register**: Aplicação em que as instâncias dos microsserviços se registram. A partir disso, os demais serviços conseguem se redirecionar apontando apenas para o applicationName, abstraindo o endereço. **Implementação no Spring: Eureka**
- **Config Server**: Centraliza o controle das configurações (properties). É possível guardar no disco ou github. **Implementação no Spring: ConfigServer**
- **Load Balancer**: Distribui a carga de requisições entre multiplas instâncias. **Implementação no Spring: Client Side Load Balancing (Netflix Ribbon)**
- **Spring Feign**: Mais fácil criar HTTP Client. Abstrai as requisições para outros serviços (RestTemplate). É integrado aos demais serviços do Spring Cloud
- **Distributed tracing**: Centralizar os logs em um local (Papertrail e Kibana por exemplo) através de um appender que publica os log nessas ferramentas como se fossem eventos. **Implementação no Spring: Spring Sleuth**
- **Circuit Breaker**: Quando a chamada para um outro microsserviço falha, um método de fallback é chamado para evitar diverssas falhas seguidas (cirquito fechado). Esse método pode ter uma mensagem de erro, ou um retorno cacheado etc... Após um determinado período de tempo, ele tenta chamar novamente o serviço para verificar se voltou a funcionar. **Implementação no Spring: Hystrix**.
- **Bulkhead**: Divide um conjunto de threads em cada parte da aplicação. Dessa forma, uma lentidão em uma parte, não afeta todo o restante.
- **Tratamento de Erro**: O ideal é que o microsserviço va mantendo o estado do dominio conforme seu ciclo de vida avance através de outros microsserviços. Dessa forma, caso tenha algum erro no meio do caminho é possível fazer um reprocessamento ou cancelar por exemplo. Esse controle pode ser feito automáticamente pela aplicação de acordo com alguma regra, ou pelo usuário.
- **API Gateway**: Ponto central das requisições que redireciona para um determinado serviço de acordo com o path. Já é integrado com o Eureka para identificar os endereços. **Implementação no Spring: Spring Zuul**

# Produtividade com Eclipse

- F3 -> Entra na classe
- ctrl + pg up | pg dn -> Alterna entre abas
- ctrl + N -> Assistente criação
- alt + shift + A -> Seleção em bloco
- ctrl + alt + seta para baixo ou cima -> replica a linha inteira
- alt + shift + R -> Renomear com refatoração
- shift + alt + M -> Extrai para método
- ctrl + shift + R -> produra arquivo
- ctrl + shift + T -> procura específica por classes
- ctrl + O -> procura método/atributo
- ctrl + T -> apresenta opções de implementação de uma classe abstrata
- ctrl + shift + G -> procura locais em que a propriedade/método é utilizado
- ctrl + alt + H -> busca toda a hierarquia de métodos até chegar no método buscado
- ctrl + k -> vai para a próxima ocorrência do find
- ctrl + shift + k -> volta para a última ocorrência do find
- preferences >> templates -> Criação de template para códigos repetitivos
- ctrl + 3 >> "move" -> mover classe de de pacote
- ctrl + N >> "JUnit Test Case" -> Wizar para criar um teste unitário
- ctrl + shift + L -> Exibe lista de atalhos
- F7 -> Volta para o método externo no debbug
- Views > Declaration -> Exibe conteúdo de outra classe sem a necessidade de entrar nela
- Views > Task List -> Lista de tarefas
- Views > History -> Histórico de alterações do arquivo
- Mostrar número das linhas -> Botão direito na barra da esquerda >> Show Line Numbers
