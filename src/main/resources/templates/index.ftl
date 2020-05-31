<#include "/layout/layout-common.ftl"/>

<@layout "首页">

    <div class="layui-row">
        <form class="layui-form" method="post" action="/export">
            <div class="layui-form-item">
                <label class="layui-form-label">必填项</label>
                <div class="layui-input-block">
                    <input type="text" name="json" lay-verify="required" lay-reqtext="这是必填项，岂能为空？" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

    <script>
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                ,layer = layui.layer;

            //监听提交
            // form.on('submit(demo1)', function(data){
            //     layer.alert(JSON.stringify(data.field),
            //         {
            //             title: '最终的提交信息'
            //         }
            //     )
            //     return false;
            // });


        });
    </script>

</@layout>