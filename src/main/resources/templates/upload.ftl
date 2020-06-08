<#include "/layout/layout-common.ftl"/>

<@layout "首页">

<div class="layui-row">


    <div class="layui-upload-drag" id="test10">
        <i class="layui-icon"></i>
        <p>点击上传，或将文件拖拽到此处</p>
        <div class="layui-hide" id="uploadDemoView">
            <hr>
            <p>上传成功</p>
        </div>
    </div>

    <div id="demo" class="layui-progress layui-progress-big layui-hide" lay-showpercent="true" lay-filter="demo">
        <div class="layui-progress-bar" lay-percent="0%"></div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" id="test11">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</div>

<script>
    layui.use(['upload','element'], function(){
        var $ = layui.jquery,upload = layui.upload,element = layui.element;

        //拖拽上传
        upload.render({
            elem: '#test10'
            ,accept:'file'
            ,auto:false
            ,bindAction:'#test11'
            ,url: 'http://localhost:8080/uploadExcel' //改成您自己的上传接口
            ,progress: function(n, elem){
                layui.$('#demo').removeClass('layui-hide');
                var percent = n + '%' //获取进度百分比
                element.progress('demo', percent); //可配合 layui 进度条元素使用

                //以下系 layui 2.5.6 新增
                console.log(elem); //得到当前触发的元素 DOM 对象。可通过该元素定义的属性值匹配到对应的进度条。
            }
            ,done: function(res){
                layer.msg('上传成功');
                layui.$('#uploadDemoView').removeClass('layui-hide');
                console.log(res)
            }
        });
    });
</script>

</@layout>