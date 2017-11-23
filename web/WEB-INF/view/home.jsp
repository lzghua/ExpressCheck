
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Express Check</title>
    <script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">

        function bclick() {
            var options=$("#type option:selected");
            var type = options.val();
            var postid = $("#postid").val();
            var url = "/query/"+type+"/"+postid;

            $.ajax({
             url:url,
             success:function(data){
                 //alert(data.data.length);
                 var tbStr="";
                 for(var i=0;i<data.data.length;i++){
                     tbStr += data.data[i].ftime+" :  "+data.data[i].context+"<br>";
                 }
                 var tbcontext = $("#content1");
                 tbcontext[0].innerHTML = tbStr;
             }
             });
        }
    </script>
</head>
<body>

   <%--<table border="1">
       <tr>
           <td>
               <iframe name="kuaidi100" src="https://www.kuaidi100.com/frame/app/index.html?canvas_pos=600"
                       width="600" height="360" marginwidth="0" marginheight="0"
                       hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
           </td>
       </tr>
   </table>--%>

   <table border="1" bgcolor="#f0ffff">
       <tr>
           <td>
               <select id="type" name="common">
                   <option value="shunfeng" selected="selected">顺丰</option>
                   <option value="ems">EMS</option>
                   <option value="shentong" >申通</option>
                   <option value="zhongtong">中通</option>
               </select>
           </td>
           <td>
               单号：<input id="postid" type="text" value="601305082460">
           </td>
           <td>
               <input id="button" type="button" onclick="bclick()" value="查询">
           </td>
       </tr>
       <tr>
           <td id="content1" colspan="3">

           </td>
       </tr>
   </table>
</body>
</html>
