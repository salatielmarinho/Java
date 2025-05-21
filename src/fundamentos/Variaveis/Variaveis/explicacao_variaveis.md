**Explica��o sobre Vari�veis em Java**

?? Vari�veis s�o espa�os na mem�ria do computador utilizados para armazenar dados tempor�rios durante a execu��o do programa. Cada vari�vel tem um tipo, que determina o tipo de dado que ela pode guardar. Veja o exemplo:

```java

public class Variaveis {
    public static void main(String[] args) {
        int idade = 30;
        double altura = 1.75;
        boolean ativo = true;
        char genero = 'F';
        String nome = "Doralice";
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Ativo: " + ativo);
        System.out.println("G�nero: " + genero);
    }
}

---

### ??Aprendemos com esse c�digo...

- ?? int idade = 30;
Cria uma vari�vel do tipo inteiro chamada idade e atribui a ela o valor 30.

- ?? double altura = 1.75;
Cria uma vari�vel do tipo double (usada para n�meros decimais) chamada altura e atribui o valor 1.75.

- ? boolean ativo = true;
Cria uma vari�vel do tipo booleano (que armazena apenas true ou false) chamada ativo e atribui o valor true.

- ?? char genero = 'F';
Cria uma vari�vel do tipo caractere chamada genero e atribui o caractere 'F'.

- ?? String nome = "Doralice";
Cria uma vari�vel do tipo String (usada para armazenar textos) chamada nome e atribui o valor "Doralice".

Cada vari�vel foi usada no comando `System.out.println()` para mostrar seu valor na tela. Assim, vari�veis ajudam o programa a guardar e manipular informa��es de diferentes tipos. ???

---

| Tipo        | Descri��o                                | Intervalo de valores                                                           |
|-------------|------------------------------------------|--------------------------------------------------------------------------------|
| byte        | Inteiro de 8 bits                        | -128 a 127                                                                     |
| short       | Inteiro de 16 bits                       | -32.768 a 32.767                                                               |
| int         | Inteiro de 32 bits                       | -2.147.483.648 a 2.147.483.647                                                 |
| long        | Inteiro de 64 bits                       | -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807                         |
| float       | Ponto flutuante de precis�o simples (32b)| Aproximadamente �3,40282347E+38F (6 a 7 casas decimais)                        |
| double      | Ponto flutuante de dupla precis�o (64b)  | Aproximadamente �1,79769313486231570E+308 (15 casas decimais)                  |
| char        | Caractere Unicode de 16 bits             | '\\u0000' (0) a '\\uffff' (65.535)                                             |
| boolean     | Valor l�gico                             | true ou false                                                                  |
| String      | Cadeia de caracteres (objeto)            | Tamanho limitado apenas pela mem�ria dispon�vel                                |

---

# ?? Diferen�a entre int e Integer em Java

- **int** � um tipo de dado primitivo em Java.
  Ele serve para armazenar valores inteiros, como 1, 2, -15, 2000, etc.
  Como tipo primitivo, ocupa menos mem�ria e � mais r�pido para opera��es matem�ticas b�sicas.

- **Integer** � uma classe (um "wrapper class") da linguagem Java.
  Ela encapsula um valor int em um objeto, permitindo que voc� utilize m�todos e trabalhe com recursos de orienta��o a objetos.
  Objetos do tipo Integer podem ser usados em cole��es que exigem objetos (como ArrayList), podem ser nulos e oferecem m�todos utilit�rios (como convers�o de texto para n�mero e vice-versa).

---

## ?? Resumo das principais diferen�as

| Caracter�stica         | int                  | Integer                  |
|------------------------|----------------------|--------------------------|
| Natureza               | Tipo primitivo       | Classe (objeto)          |
| Aceita valor nulo?     | N�o                  | Sim (`null`)             |
| M�todos utilit�rios    | N�o                  | Sim                      |
| Uso em cole��es        | N�o                  | Sim                      |
| Performance            | Mais eficiente       | Menos eficiente          |

---

## ?? Exemplo em c�digo

```java
int numero1 = 20;       // Tipo primitivo
Integer numero2 = null; // Objeto (classe Integer), pode ser nulo


## ?? Dica

Use **int** para processamento de dados simples e r�pido, e **Integer** quando precisar manipular objetos, aceitar valores nulos ou utilizar recursos da linguagem orientada a objetos.