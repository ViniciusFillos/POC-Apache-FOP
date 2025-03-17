<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <!-- Root template -->
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm">
                    <fo:region-body margin="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="24pt" font-weight="bold" margin-bottom="20pt">List of Books</fo:block>
                    <fo:block font-size="18pt" margin-bottom="12pt">Books:</fo:block>

                    <!-- Loop through each book and format its details -->
                    <xsl:for-each select="books/book">
                        <fo:block font-size="16pt" margin-bottom="8pt">
                            <xsl:value-of select="title"/> by <xsl:value-of select="author"/> (Year: <xsl:value-of select="year"/>)
                        </fo:block>
                    </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>