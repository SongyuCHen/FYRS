<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<div class="xzfy_dlg">
	--%><ul class="xzfy_ul">
		<li>
			<a class="level-1" data-fybh="${gylb.fydm}">${gylb.fymc}</a>
			<c:forEach items="${gylb.xjfyList}" var="zylb">
				<ul>
					<li>
						<a class="level-2" data-fybh="${zylb.fydm}">${zylb.fymc}</a>
						<c:forEach items="${zylb.xjfyList}" var="jylb">
							<ul>
								<li>
									<a class="level-3" data-fybh="${jylb.fydm}">${jylb.fymc}</a>
								</li>
							</ul>
						</c:forEach>
					</li>
				</ul>
			</c:forEach>
		</li>
	</ul>
	<div class="xzfy_foot">
		<input type="button" value="收起当前" class="xzfy_sqdq" />
		<input type="button" value="收起全部" class="xzfy_sqqb" />
		<div class="btn-group">
			<button class="btn btn-primary">
				<span class="glyphicon glyphicon-ok"></span> 确定
			</button>
			<button class="btn btn-primary">
				<span class="glyphicon glyphicon-remove"></span> 取消
			</button>
		</div>
	</div>