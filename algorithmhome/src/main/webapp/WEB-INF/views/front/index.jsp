<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/inc/head.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/front/css/index.css" rel="stylesheet" />
<title>算法之家首页</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/front/inc/header.jsp"></jsp:include>
	<div class="container">
		<!-- 中部开始 -->
		<jsp:include page="/WEB-INF/views/front/inc/logo.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-3 col-sm-3">
				<div id="leftMenu">
					<c:forEach items="${leftChannel1s }" var="leftChannel1" varStatus="i">
						<c:if test="${i.index==0 }">
							<ul class="nav nav-pills nav-stacked navSelected">
								<h4>${leftChannel1.name }</h4>
								<c:forEach items="${leftChannel1.childs }" var="leftChannel2">
									<li><a href="${pageContext.request.contextPath }/algorithm/listchannel2/${leftChannel2.id }">${leftChannel2.name }</a></li>
								</c:forEach>
							</ul>
						</c:if>
						<c:if test="${i.index!=0 }">
							<ul class="nav nav-pills nav-stacked">
								<h4>${leftChannel1.name }</h4>
								<c:forEach items="${leftChannel1.childs }" var="leftChannel2">
									<li><a href="${pageContext.request.contextPath }/algorithm/listchannel2/${leftChannel2.id }">${leftChannel2.name }</a></li>
								</c:forEach>
							</ul>
						</c:if>
					</c:forEach>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						最新需求<a href="#" class="pull-right">更多</a>
					</div>
					<!-- List group -->
					<ul class="list-group new-require">
						<li class="list-group-item">
							<div>
								<h5>
									<a>为什么</a>
								</h5>
								<span>user1</span>
								<time> 2013-07-26 </time>
							</div>
						</li>
						<li class="list-group-item">
							<div>
								<h5>
									<a>为什么</a>
								</h5>
								<span>user1</span>
								<time> 2013-07-26 </time>
							</div>
						</li>
						<li class="list-group-item">
							<div>
								<h5>
									<a>为什么</a>
								</h5>
								<span>user1</span>
								<time> 2013-07-26 </time>
							</div>
						</li>
						<li class="list-group-item">
							<div>
								<h5>
									<a>为什么</a>
								</h5>
								<span>user1</span>
								<time> 2013-07-26 </time>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-9 col-sm-9">
				<div class="row">
					<div class="col-md-8 ">
						<div class="panel panel-default">
							<div id="myCarousel" class="carousel slide" data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#myCarousel" data-slide-to="0"></li>
									<li data-target="#myCarousel" data-slide-to="1"></li>
									<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
								</ol>
								<div class="carousel-inner">
									<div class="item">
										<img src="${pageContext.request.contextPath }/resources/front/img/pic1.jpg" />
										<div class="carousel-caption">
											<p>1Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
										</div>
									</div>
									<div class="item">
										<img src="${pageContext.request.contextPath }/resources/front/img/pic2.jpg" />
										<div class="carousel-caption">
											<p>2Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
										</div>
									</div>
									<div class="item active">
										<img src="${pageContext.request.contextPath }/resources/front/img/pic3.jpg" />
										<div class="carousel-caption">
											<p>3Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
										</div>
									</div>
								</div>
								<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-default hero-unit">
							<ul class="list-unstyled">
								<li>专业提供科研算法支持</li>
								<li>当前已有<strong>3333</strong>个算法储备
								</li>
								<li>
									<button type="button" id="publishBtn" class="btn btn-default" data-toggle="button">发布算法</button>
									<button type="button" class="btn btn-primary" data-toggle="button">算法提问</button>
								</li>
							</ul>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>近期会议</th>
										<th>时间</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>98投资洽谈会</td>
										<td>2013-08-02</td>
									</tr>
									<tr>
										<td>98投资洽谈会</td>
										<td>2013-08-02</td>
									</tr>
									<tr>
										<td>98投资洽谈会</td>
										<td>2013-08-02</td>
									</tr>
									<tr>
										<td>98投资洽谈会</td>
										<td>2013-08-02</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						算法达人<a class="pull-right">更多</a>
					</div>
					<div class="panel-body">
						<div class="col-xs-4 col-sm-4 col-md-3 col-lg-2">
							<div class="thumbnail">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp1.jpg">
								<div class="caption">
									<h5>
										<a href="#">username</a>
									</h5>
									<span>发布</span><span class="pull-right">133</span>
								</div>
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-3 col-lg-2">
							<div class="thumbnail">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp1.jpg">
								<div class="caption">
									<h5>
										<a href="#">username</a>
									</h5>
									<span>发布</span><span class="pull-right">133</span>
								</div>
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-3 col-lg-2">
							<div class="thumbnail">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp1.jpg">
								<div class="caption">
									<h5>
										<a href="#">username</a>
									</h5>
									<span>发布</span><span class="pull-right">133</span>
								</div>
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-3 col-lg-2">
							<div class="thumbnail">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp1.jpg">
								<div class="caption">
									<h5>
										<a href="#">username</a>
									</h5>
									<span>发布</span><span class="pull-right">133</span>
								</div>
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-3 col-lg-2">
							<div class="thumbnail">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp1.jpg">
								<div class="caption">
									<h5>
										<a href="#">username</a>
									</h5>
									<span>发布</span><span class="pull-right">133</span>
								</div>
							</div>
						</div>
						<div class="col-xs-4 col-sm-4 col-md-3 col-lg-2">
							<div class="thumbnail">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp1.jpg">
								<div class="caption">
									<h5>
										<a href="#">username</a>
									</h5>
									<span>发布</span><span class="pull-right">133</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						数据挖掘<a class="pull-right">更多</a>
					</div>
					<div class="panel-body">
						<div class="row item">
							<div class="col-md-4 col-sm-4 col-lg-3">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp2.jpg" class="img-thumbnail">
							</div>
							<div class="col-md-8 col-sm-8 col-lg-9">
								<h3>
									<a href="#">g prices with 9 economic covariates(474.14K)</a>
								</h3>
								<p>We collected information on the variables using all the block groups in California from the 1990 Census. In this sample a block group on average includes 1425.5 individuals living in a geographically compact area. Naturally, the geographical area included varies inversely with the population dens..</p>
								<ul class="list-unstyled">
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						数据挖掘<a class="pull-right">更多</a>
					</div>
					<div class="panel-body">
						<div class="row item">
							<div class="col-md-4 col-sm-4 col-lg-3">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp2.jpg" class="img-thumbnail">
							</div>
							<div class="col-md-8 col-sm-8 col-lg-9">
								<h3>
									<a href="#">g prices with 9 economic covariates(474.14K)</a>
								</h3>
								<p>We collected information on the variables using all the block groups in California from the 1990 Census. In this sample a block group on average includes 1425.5 individuals living in a geographically compact area. Naturally, the geographical area included varies inversely with the population dens..</p>
								<ul class="list-unstyled">
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						数据挖掘<a class="pull-right">更多</a>
					</div>
					<div class="panel-body">
						<div class="row item">
							<div class="col-md-4 col-sm-4 col-lg-3">
								<img src="${pageContext.request.contextPath }/resources/front/img/temp2.jpg" class="img-thumbnail">
							</div>
							<div class="col-md-8 col-sm-8 col-lg-9">
								<h3>
									<a href="#">g prices with 9 economic covariates(474.14K)</a>
								</h3>
								<p>We collected information on the variables using all the block groups in California from the 1990 Census. In this sample a block group on average includes 1425.5 individuals living in a geographically compact area. Naturally, the geographical area included varies inversely with the population dens..</p>
								<ul class="list-unstyled">
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
									<li><span><a href="#">Case studies in biometry</a></span> <time>2013-08-02</time></li>
								</ul>
							</div>
						</div>
					</div>
				</div>


			</div>

		</div>
		<!-- 中部结束 -->
		<!-- 广告位开始 -->
		<div class="panel panel-default">
			<img src="${pageContext.request.contextPath }/resources/front/img/ad.png" class="img-responsive" />
		</div>
		<!-- 广告位结束 -->
		<!-- 友情链接开始 -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">友情链接</h3>
			</div>
			<ul class="list-inline">
				<li><a href="">科技部平台中心</a></li>
				<li><a href="">科技部863计划</a></li>
				<li><a href="">国家科技重大专项</a></li>
				<li><a href="">中国数学资源网</a></li>
				<li><a href="">数字图书馆论坛</a></li>
				<li><a href="">科技成果管理研究</a></li>
				<li><a href="">中科院计算所</a></li>
				<li><a href="">中科院自动化所</a></li>
				<li><a href="">清华大学</a></li>
				<li><a href="">C-DBLP</a></li>
				<li><a href="">北京邮电大学</a></li>
				<li><a href="">学问社区</a></li>
				<li><a href="">龙源期刊网</a></li>
				<li><a href="">豆丁网</a></li>
				<li><a href="">Matlab 中文论坛</a></li>
				<li><a href="">数学建模网</a></li>
				<li><a href="">数据库专业委员会</a></li>
				<li><a href="">博士数学论坛</a></li>
				<li><a href="">科学网</a></li>
				<li><a href="">互联网数据研究</a></li>
				<li><a href="">NLPIR共享平台</a></li>
				<li><a href="">大学生数模竞赛</a></li>
				<li><a href="">电子顶级开发网</a></li>
				<li><a href="">万方数据知识服务平台</a></li>
				<li><a href="">中国互联网调查社区</a></li>
			</ul>
		</div>
		<!-- 友情链接结束 -->
		<!-- 版权开始 -->
		<div class="footer">
			<p>&copy; Company 2013</p>
		</div>
		<!-- 版权结束 -->
	</div>

	<jsp:include page="/WEB-INF/views/common/inc/foot.jsp"></jsp:include>
	<script type="text/javascript">
		$(function() {
			var $ctx = $("#ctx").val();
			$("#leftMenu").bingoogol_accordion();
			$("#publishBtn").on("click", function() {
				window.location.href = $ctx + "/algorithm/auth/publish";
			});
		});
	</script>
</body>
</html>