<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<article>
	<h1 id="bigH1">${ title }</h1>
	<div id="bigPhoto">
		<img src="../resources/images/myungjun01.jpg" id="bigImg">
	</div>
	<div>
		<p>${ comment }</p>
		<h3>모델로 받은 메시지</h3>
		msg : ${ msg }
	</div>
</article>