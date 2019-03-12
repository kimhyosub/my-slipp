$(".answer-write input[type=submit]").click(addAnswer);

function addAnswer(e){
	e.preventDefault();
	console.log("click me");
	
	var queryString = $('.answer-write').serialize();
	console.log("query : " + queryString);
	
	var url = $('.answer-write').attr('action');
	console.log("url : " + url);
	$.ajax({
		type : 'post'
		, url : url
		, data : queryString
		, dataType : 'json'
		, error : onError
		, success : onSuccess
	});
}

function onError() {
	console.log("error");
}

function onSuccess(data, status) {
	console.log(data);
	var answerTemplate = $("#answerTemplate").html();
	var template = answerTemplate.format(data.writer.memberId, data.formattedCreateDate, data.contents, data.id, data.id);
	$(".qna-comment-slipp-articles").prepend(template);
	$(".answer-write textarea").val('');
}


String.prototype.format = function() {
	var args = arguments;
	return this.replace(/{(\d+)}/g, function(match, number) {
		return typeof args[number] != 'undefined'
		? args[number]
		: match
        ;
	});
};

$(".link-delete-article").click(deleteAnswer);

function deleteAnswer(e) {
	e.preventDefault();
}