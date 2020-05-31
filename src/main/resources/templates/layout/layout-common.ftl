<#macro layout title>

    <!DOCTYPE html>
    <html>

    <head>
        <title>${title}</title>
    </head>

        <#include "/include/header.ftl" />

        <#nested >

        <#include "/include/footer.ftl" />

    </html>


</#macro>