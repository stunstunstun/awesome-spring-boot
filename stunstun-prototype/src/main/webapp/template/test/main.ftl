<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- jQuery Lib -->
<script type="text/javascript" src="http://imgdg.joycity.com/th/common/jquery/jquery-1.6.2.min.js"></script>
<!-- TH_GNB start-->
<script type="text/javascript" src="http://www.joycity.com/common/js/gnb/gnb_login.js"></script>
<script type="text/javascript" src="http://www.joycity.com/common/js/gnb/gnbUI.js"></script>
<script type="text/javascript" src="http://imgdg.joycity.com/th/bannersys/js/bannerUI.js" charset="UTF-8"></script>
<script type="text/javascript" src="http://bannersys.joycity.com/jsonp.jce?siteCode=60" charset="UTF-8"></script>
<!-- TH_GNB end-->
<script type="text/javascript" src="${req.getContextPath()}/js/test.js"></script>
</head>
<body>
<header class="top">
	<h1>JCE Spring3 Test Page</h1>
</header>

<nav class="mainNav">
	<ul>
		<#-- Freemarker Global Variable -->
		<li>Here is <a href="${req.getContextPath()}${req.getRequestUri()}">${req.getRequestUri()}</a></li>
	</ul>
</nav>

<section class="content">
	<header>- Test pages -</header>
	<article>
	<p id="content">Contents Area</p>
	</artice>
</section>

<footer>
Footer<br/><br/>
<#if loginSession.isLogin() >
${userID} 님 환영 합니다. <a href="javascript:GNB_Logout();">로그아웃</a>
<#else>
<a href="javascript:openLoginLayer();">로그인</a><br/>
</#if>
</footer>
</body>
</html>


