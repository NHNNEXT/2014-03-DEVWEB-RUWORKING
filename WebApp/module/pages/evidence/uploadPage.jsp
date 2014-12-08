<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="pageContainer">
	<div id="ns-evidence">
		<form class="uploadBoard" action="" method="post">
			<div class="promise wrap">
				<select name="promise-number">
					<option>공약1</option>
					<option>공약2</option>
					<option>공약3</option>
					<option>공약4</option>
					<option>공약5</option>
				</select>
				<span>자<!--promiseContent--></span>

			</div>
			<div class="title wrap">
				<span>제목</span>
				<input type="text" name="title">
			</div> 
			<div class="content wrap">
				<textarea name="content" cols="107" rows="20"></textarea>
			</div>
			<div class="submit"><input type="submit" value="올리기"></div>
		</form>
	</div>
</div>

