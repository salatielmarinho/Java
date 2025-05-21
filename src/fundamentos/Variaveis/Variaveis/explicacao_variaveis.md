**Explicação sobre Variáveis em Java**

📦 Variáveis são espaços na memória do computador utilizados para armazenar dados temporários durante a execução do programa. Cada variável tem um tipo, que determina o tipo de dado que ela pode guardar. Veja o exemplo:

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
        System.out.println("Gênero: " + genero);
    }
}
```

---

### 🧠 Aprendemos com esse código...

- 🔢 int idade = 30;
Cria uma variável do tipo inteiro chamada idade e atribui a ela o valor 30.

- 📏 double altura = 1.75;
Cria uma variável do tipo double (usada para números decimais) chamada altura e atribui o valor 1.75.

- ✅ boolean ativo = true;
Cria uma variável do tipo booleano (que armazena apenas true ou false) chamada ativo e atribui o valor true.

- 🔠 char genero = 'F';
Cria uma variável do tipo caractere chamada genero e atribui o caractere 'F'.

- 📝 String nome = "Doralice";
Cria uma variável do tipo String (usada para armazenar textos) chamada nome e atribui o valor "Doralice".

Cada variável foi usada no comando `System.out.println()` para mostrar seu valor na tela. Assim, variáveis ajudam o programa a guardar e manipular informações de diferentes tipos. ???

---

| Tipo        | Descrição                                | Intervalo de valores                                                           |
|-------------|------------------------------------------|--------------------------------------------------------------------------------|
| byte        | Inteiro de 8 bits                        | -128 a 127                                                                     |
| short       | Inteiro de 16 bits                       | -32.768 a 32.767                                                               |
| int         | Inteiro de 32 bits                       | -2.147.483.648 a 2.147.483.647                                                 |
| long        | Inteiro de 64 bits                       | -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807                         |
| float       | Ponto flutuante de precisão simples (32b)| Aproximadamente ±3,40282347E+38F (6 a 7 casas decimais)                        |
| double      | Ponto flutuante de dupla precisão (64b)  | Aproximadamente ±1,79769313486231570E+308 (15 casas decimais)                  |
| char        | Caractere Unicode de 16 bits             | '\\u0000' (0) a '\\uffff' (65.535)                                             |
| boolean     | Valor lógico                             | true ou false                                                                  |
| String      | Cadeia de caracteres (objeto)            | Tamanho limitado apenas pela memória disponível                                |

---

# ⚖️ Diferença entre int e Integer em Java

- **int** é um tipo de dado primitivo em Java.
  Ele serve para armazenar valores inteiros, como 1, 2, -15, 2000, etc.
  Como tipo primitivo, ocupa menos memória e é mais rápido para operações matemáticas básicas.

- **Integer** é uma classe (um "wrapper class") da linguagem Java.
  Ela encapsula um valor int em um objeto, permitindo que você utilize métodos e trabalhe com recursos de orientação a objetos.
  Objetos do tipo Integer podem ser usados em coleções que exigem objetos (como ArrayList), podem ser nulos e oferecem métodos utilitários (como conversão de texto para número e vice-versa).

---

## ✏️ Resumo das principais diferenças

| Característica         | int                  | Integer                  |
|------------------------|----------------------|--------------------------|
| Natureza               | Tipo primitivo       | Classe (objeto)          |
| Aceita valor nulo?     | Não                  | Sim (`null`)             |
| Métodos utilitários    | Não                  | Sim                      |
| Uso em coleções        | Não                  | Sim                      |
| Performance            | Mais eficiente       | Menos eficiente          |

---

## 💻 Exemplo em código

```java
int numero1 = 20;       // Tipo primitivo
Integer numero2 = null; // Objeto (classe Integer), pode ser nulo
```

## 💡 Dica

Use **int** para processamento de dados simples e rápido, e **Integer** quando precisar manipular objetos, aceitar valores nulos ou utilizar recursos da linguagem orientada a objetos.