<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>SellItem画面</title>
	<style type="text/css">
		body {
		   margin:0;
		   padding:0;
		   line-height:1.6;
		   letter-spacing:1px;
		   font-family:Verdana, Helvetica, sans-serif;
		   font-size:12px;
		   color:#333;
		   background:#fff;
		}
		/* ========TEMPLATE LAYOUT======== */
		#top {
		   width:780px;
		   margin:30px auto;
		   border:1px solid #333;
		}

		#header {
		   width: 100%;
		   height: 80px;
		   background-color: black;
		}

		#main {
		   width: 100%;
		   height: 500px;
		   text-align: center;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear:both;
		}

		#text-center {
			display: inline-block;
			text-align: center;
		}
	</style>
</head>
<body>
	<div id="header">
	 	<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>SellItem</p>
		</div>
		<form action ="SellItemAction">
			<div id="text-center">
				商品名　<s:textfield name="SellItemName" /><br><br>
				商品価格<s:textfield name="SellItemPrice" /><br><br>
				販売個数<s:textfield name="Sellstock" /><br><br>
				<s:submit value="送信" />
				<div id="text-link">
					<p><a href='<s:url action="GoHomeAction" />'>戻る</a></p>
				</div>
			</div>
		</form>
	</div>
	<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>