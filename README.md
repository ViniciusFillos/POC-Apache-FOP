# Geração de PDF com Apache FOP

Este projeto foi desenvolvido para demonstrar a geração de PDFs utilizando o **Apache FOP**, com o objetivo de converter arquivos XML em PDFs formatados, a partir de um arquivo XSL-FO.

## 📌 Tecnologias Utilizadas
- **Java**
- **Apache FOP**
- **XML**
- **XSL-FO**

## 📂 Estrutura do Projeto
```
/projeto
│── /src/main/java/io/github/vinifillos
│   ├── GeradorArquivoPDF.java
│   ├── GeradorDadosXML.java
│   ├── ModificadorDadosXML.java
│   ├── RemovedorDadosXML.java
│── /resources
│   ├── /data
│   │   ├── input.xml
│   ├── /pdf
│   │   ├── output.pdf
│   ├── /styles
│   │   ├── style.xsl
│── pom.xml
│── README.md
```

### 2️⃣ Dependências (Maven)
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.xmlgraphics</groupId>
        <artifactId>fop</artifactId>
        <version>2.8</version>
    </dependency>
</dependencies>
```

## 📝 Como Funciona
1. O arquivo **data/input.xml** contém os dados estruturados.
2. O **styles/style.xsl** define a conversão de XML para XSL-FO.
3. O **Apache FOP** processa o XSL-FO e gera um PDF na pasta `pdf/`.
4. **GeradorPDF** contém um exemplo para a geração de arquivo pdf.
5. **GeradorXML** contém um exemplo para a geração de dados em um arquivo xml.
6. **ModificadorXML** contém um exemplo para a modificação de dados em um arquivo xml já preenchido.
7. **RemovedorXML** contém um exemplo para deletar dados em um arquivo xml já preenchido.

## 🏆 Resultados
Após a execução do GeradorArquivoPDF, o arquivo `output.pdf` estará disponível em `src/main/resources/pdf/`.
Após a execução do GeradorDadosXML, os dados deste código seram inseridos em `src/main/resources/data/input.xml`.
Após a execução do ModificadorDadosXML, o arquivo `input.xml` será modificado de acordo com esse código.
Após a execução do RemovedorDadosXML, os dados do arquivo `input.xml` seram deletados.

## 📌 Personalização
- Altere `styles/style.xsl` para modificar a formatação do PDF.
- Use diferentes fontes, tamanhos, cores e estilos no XSL-FO.
- Adicione imagens e tabelas conforme necessário.

  encouraging-second-4fd.notion.site/Apache-FOP-1ba0986205bb809b80a9ff4850b242db?pvs=73
