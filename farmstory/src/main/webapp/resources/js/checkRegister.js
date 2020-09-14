	$(function(){
		
		$('input[name=uid]').focusout(function(){
			
			var uid = $(this).val();
			var json = {'uid':uid};
			
			$.ajax({
				url: '/sboard/user/uidCheck',
				type : 'get',
				data : json,
				dataType : 'json',
				success: function(data){

					if(data.result == 0){
						$('.resultId').css('color', 'green').text('사용할 수 있는 아이디입니다.');
					}else{
						$('.resultId').css('color', 'red').text('사용할 수 없는 아이디입니다.');
					}
				}
			});
		
		});
	});

	$(function(){
		$('input[name=nick]').focusout(function(){
	
			var nick = $(this).val();
			var json = {'nick':nick};
	
			$.ajax({
				url : '/sboard/user/nickCheck',
				type : 'get',
				data : json,
				dataType : 'json',
				success: function(data){
					if(data.result == 0){
						$('.resultNick').css('color','green').text('사용가능한 별명입니다.');
						}else{
						$('.resultNick').css('color','red').text('사용중인 별명입니다.');
						}
					}
				});
			});
		});
		
		
	