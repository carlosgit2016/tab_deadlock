# Trabalho Dead Lock.
Objetivo do projeto:

• interpretar descrições de processos escritos em linguagem humana e traduzir para linguagem
de programação;
• utilizar tipos abstratos de dados de coleções, especificamente as oferecidas pela biblioteca
padrão do JavaSE 8;
• sedimentar conhecimentos abordados da disciplina de Sistemas Operacionais.

Utilizando instâncias dessa classe, modele os seguintes grafos de processos-recursos resultantes das seguintes operações:

(a) Cenário 1:
1. Processo A requisita recurso S
2. Processo B requisita recurso S
3. Processo A requisita recurso T
4. Processo A libera recurso S
5. Processo B requisita recurso T
(b) Cenário 2:
1. Processo A requisita recurso R
2. Processo B requisita recurso S
3. Processo C requisita recurso T
4. Processo A requisita recurso S
5. Processo B requisita recurso T
6. Processo C requisita recurso R
(c) Cenário 3:
1. Processo A requisita recurso R
2. Processo C requisita recurso T
3. Processo A requisita recurso S
4. Processo C requisita recurso R
5. Processo A libera recurso R
6. Processo A libera recurso S

3. No capítulo sobre Deadlocks (Impasses) de [3], procure sobre o algoritmo de verificação de
ciclos em grafo. Após entendimento, faça:

(a) Crie um novo método em DeadlockUteis com nome e assinatura adequados para a implementação
do algoritmo de verificação.

(b) Escreva a especificação do algoritmo em forma de javadoc para este método.

(c) Implemente o método.

(d) Crie uma classe de testes e crie vários testes para o método de verificação.

Referências
[1] ORACLE. Lesson Introduction to Collections (The Java™Tutorials > Collections). Disponível
em: <https://docs.oracle.com/javase/tutorial/collections/intro/index.
html>.
[2] ORACLE. Stack (The Java Platform). Disponível em: <https://docs.oracle.com/
javase/8/docs/api/java/util/Stack.html>.
[3] TANENBAUM, A. S.; BOS, H. Sistemas operacionais modernos. 4ª edição. Rio de Janeiro:
Pearson, 2015. 864 p. ISBN 9788543005676.
