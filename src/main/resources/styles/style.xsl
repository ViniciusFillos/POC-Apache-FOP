<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm">
                    <fo:region-body margin="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="24pt" font-weight="bold" margin-bottom="20pt" text-align="center">
                        List of Books
                    </fo:block>

                    <!-- Definição da tabela -->
                    <fo:table border="0.5pt solid black" width="100%" table-layout="fixed">
                        <fo:table-column column-width="40%"/>
                        <fo:table-column column-width="40%"/>
                        <fo:table-column column-width="20%"/>

                        <!-- Título -->
                        <fo:table-body>
                            <fo:table-row>
                                <!-- Título -->
                                <fo:table-cell>
                                    <fo:block font-size="18pt" font-weight="light" text-align="center">
                                        Books
                                    </fo:block>
                                </fo:table-cell>
                                <!-- Author -->
                                <fo:table-cell>
                                    <fo:block font-size="18pt" font-weight="light" text-align="center">
                                        Author
                                    </fo:block>
                                </fo:table-cell>
                                <!-- Author -->
                                <fo:table-cell>
                                    <fo:block font-size="18pt" font-weight="light" text-align="center">
                                        Year
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>

                        <!-- Corpo da tabela -->
                        <fo:table-body>
                            <xsl:for-each select="books/book">
                                <fo:table-row>
                                    <fo:table-cell border="0.5pt solid black">
                                        <fo:block text-align="center">
                                            <xsl:value-of select="title"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black">
                                        <fo:block text-align="center">
                                            <xsl:value-of select="author"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="0.5pt solid black">
                                        <fo:block text-align="center">
                                            <xsl:value-of select="year"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>
