
// ajax
function ajax(url, param, method, fnSuccess, fnError){
	$.ajax({
		url : '/',
		data : param,
		dataType : 'json',	/*html, text, json, xml, script*/
		method : 'POST',
		beforeSend : function(xhr){
			// 헤더추가 등등...
		},
		success : function(res){
			
		},
		error : function(xhr, status, error){
			console.log(xhr.status); // 에러코드(404, 500 등)
			console.log(xhr.responseText); // html 포맷의 에러 메시지
			console.log(status); // 'error'
			console.log(error); // 'Not Found'
		}
	});

};