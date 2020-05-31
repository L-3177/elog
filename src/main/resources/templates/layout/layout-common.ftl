<#macro layout title>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/res/css/layui.css"  media="all">
    <script src="/static/res/layui.js" charset="utf-8"></script>
</head>

<#--    <#include "/include/header.ftl" />-->

    <#nested >

<#--    <#include "/include/footer.ftl" />-->

</html>


</#macro>