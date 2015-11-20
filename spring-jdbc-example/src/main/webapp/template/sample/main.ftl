<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<#include "/common/library/head.ftl" />
</head>
<body>
<div id="JC_GNB"></div>
<header class="top">
	<h2>Head Area - Hi! JCE SPRING MVC</h2>
</header>

<nav class="mainNav">
	<ul>
		<#-- Freemarker Global Variable -->
		<li>Here is <a href="${req.getContextPath()}${req.getRequestUri()}">${req.getRequestUri()}</a></li>
	</ul>
</nav>

<section class="content">
	<header></header>
	<article>
		<br/>
		<p id="content"><h2>Contents Area<h2></p>
		<br/>
		<#-- LOGIN AREA SAMPLE -->
		<p id="login_area">
			<#if loginSession.isLogin() >
				${loginSession.userId} 님 환영 합니다. <a href="javascript:JC.logout();">로그아웃</a><br/> <#-- LOGOUT -->
				userIdIndex: ${loginSession.userIdIndex}| GUID: ${loginSession.sessionGUID} | email : ${loginSession.email?default("-")} | Cash : ${loginSession.cash} | SEX : ${loginSession.sex} <br/>
				<a href="javascript:JC.gameStart(31);">FSF 게임스타트</a><br/> <#-- GAMESTART  -->
				<a href="javascript:JC.gameStart(30);">FS 게임스타트</a><br/>
				<a href="javascript:JC.gameStart(33);">FS2 게임스타트</a><br/>
				<a href="javascript:JC.gameStart(60);">NX 게임스타트</a><br/>
			<#else>
				<br/><h2>Login sample</h2></br><br/>
				<a href="javascript:JC.GNB.openLoginLayer();">로그인 버튼</a><br/><br/> <#-- OPEN LOGIL LAYER -->
				<#-- LOGIN FORM -->
			    <form id="login_form" name="login_form" action="https://member.joycity.com/login/login_ok.do" method="post" onsubmit="return JC.login(this);">
					<legend>로그인</legend>
					<fieldset>
					<input type="hidden" name="surl" value="" />
					<input type="hidden" name="rememberid" value="OFF" />
					<input type="hidden" name="keydefenceCheck" value="OFF" />
					<input type="hidden" name="gotourl" value="" />
					<input type="hidden" name="loginfrom" value="direct_motp" />
					<input type="hidden" name="frameurl" value="" />
					<input type="hidden" name="rd" value="http://www.joycity.com" />
					<input type="hidden" name="siteCode" value="" />
			        <ul class="loginOption">
				        <li><input type="checkbox" data="jce_rememberid" /><label for="rememberAcc">ID기억</label></li>
				        <li><input type="checkbox" checked /><label for="secureCon">보안접속</label></li>
				        <li><input type="checkbox" data="jce_keydefence" onclick="JC.keyDefence(this);" /><label for="secureKbd">키보드보안</label></li>
				        <li class="join"><a href="javascript:JC.GNB.link('join');">회원가입</a> |  <a href="javascript:JC.GNB.link('find')">ID / PW 찾기</a></li>
			        </ul>
			        <input type="text" name="id" onFocus="this.className='id_focus'" onBlur="if ( this.value == '' ) { this.className='id_blur' }"  class='id_blur' />
			        <input type="password" name="password" onFocus="this.className='pw_focus'" onBlur="if ( this.value == '' ) { this.className='pw_blur' }"  class='pw_blur' />
			         </fieldset>
			        <input type="submit" value="로그인" />
			    </form>
			</#if>
		</p>
	</artice>
</section>

<footer>
	<br/><br/><h2>Footer Area</h2><br/><br/>
	<#-- FOOTER AREA SAMPLE -->
	<div id="footer_area">
	    <a href="#" data="footer_company" target="_blank" title="JCE"></a>
	    <ul class="footer_link">
		    <li><a href="#" data="footer_company" title="회사소개">회사소개</a></li>
		    <li><a href="#" data="footer_recruit" title="채용정보">채용정보</a></li>
		    <li><a href="#" data="footer_agree" title="이용약관">이용약관</a></li>
		    <li><a href="#" data="footer_privacy" title="개인정보 취급방침">개인정보 취급방침</a></li>
		    <li><a href="#" data="footer_youth" title="청소년보호정책">청소년보호정책</a></li>
	    </ul>
	    <address class="dpNone">
			COPYRIGHTⓒ JCE. ALL RIGHTS RESERVED.
	    </address>
	    <div>
			<select name="family_site" onchange="JC.GNB.link(this.options[this.selectedIndex].value);">
				<option>패밀리 사이트</option>
			</select>
		</div>
	</div>
</footer>

<#include "/common/library/bottom.ftl" />
</body>
</html>