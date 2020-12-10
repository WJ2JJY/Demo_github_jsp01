<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加主题--管理后台</title>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function abc(){
	
	if($("#title").val()==""||$("#author").val()==""||$("#summary").val()==""||$("#content").val()==""){
		alert("信息不能为空！");
	}else{
		var json = {
				"newsid":$("#id").val(),
				"typeid":$("#sel").val(),
				"newstitle":$("#title").val(),
				"newsauthor":$("#author").val(),
				"newsummary":$("#summary").val(),
				"newscontent":$("#content").val(),
				"newspic":null,
				"releasetime":new Date()
			};
			$.ajax({
				url:"../jqajax",
				type:"post",
				contentType: "application/json; charset=UTF-8",
				data:JSON.stringify(json),
				dateType:"json",
				success:function(baby){
					$("#summary").val("");
					$("#author").val("");
					$("#title").val("");.0
					$("#content").val("");
					alert(baby);
				},
				error:function(){
					alert("运行错误");
				}
			});
	}
	
	
	
}

</script>
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../Images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../Images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：${uname }  &#160;&#160;&#160;&#160; <a href="../index.html">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
   <div id="opt_list">
    <ul>
      <li><a href="news_add.html">添加新闻</a></li>
      <li><a href="admin.html">编辑新闻</a></li>
      <li><a href="topic_add.html">添加主题</a></li>
      <li><a href="topic_list.html">编辑主题</a></li>
    </ul>
  </div>
  <div id="opt_area">
    <h1 id="opt_type"> 修改新闻： </h1>
    <!-- enctype="multipart/form-data" -->
    <form action="#" method="post" enctype="multipart/form-data">
      <p>
        <label> 主题 </label>
        <select id="sel" name="ntid" value="${param.type_id }">
        	<option value='1'>国内</option>
		<option value='2'>国际</option>
		<option value='3'>娱乐</option>
		<option value='4'>日常</option>
		<option value='5'>军事</option>        
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" id="title" type="text" class="opt_input" value="${param.newstitle }"/>
        <input type='hidden' id="id" value="${param.newsid}" name="newsid"/>
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" id="author" type="text" class="opt_input" value="${param.newsauthor }"  />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" id="summary" cols="40" rows="3" value="${param.newsummary }" ></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" id="content" cols="70" rows="10" value="${param.newscontent }"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input id="ufile" name="file" type="file" class="opt_input" />
      </p>
      <input type="button" value="提交" class="opt_sub" onclick="abc()" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
</body>
</html>




















