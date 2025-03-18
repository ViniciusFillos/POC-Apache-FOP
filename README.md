# Geração de PDF com Apache FOP

Este projeto utiliza **Apache FOP** para converter arquivos XML em PDFs formatados a partir de um arquivo XSL-FO.

## 📌 Tecnologias Utilizadas
- **Java**
- **Apache FOP**
- **XML**
- **XSL-FO**

## 📂 Estrutura do Projeto
```
/projeto
│── /src/main/java/io/github/vinifillos
│   ├── App1.java
│── /resources
│   ├── /style
│   │   ├── style.xsl
│   ├── /data
│   │   ├── input.xml
│── /pdf
│   ├── output.pdf
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
1. O arquivo **input/data.xml** contém os dados estruturados.
2. O **style/template.xsl** define a conversão de XML para XSL-FO.
3. O **Apache FOP** processa o XSL-FO e gera um PDF na pasta `output/`.
3. O **App1** contém um exemplo para a geração do pdf.
3. O **App2** contém um exemplo para a modificação de dados no xml.

## 🏆 Resultados
Após a execução, o arquivo `output.pdf` estará disponível em `pdf/`.

## 📌 Personalização
- Altere `style/template.xsl` para modificar a formatação do PDF.
- Use diferentes fontes, tamanhos, cores e estilos no XSL-FO.
- Adicione imagens e tabelas conforme necessário.
