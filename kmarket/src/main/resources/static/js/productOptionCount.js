 // 상품수량 +, - 기능구현
  		  $(document).ready(function(){

		var btnPlus  = $('.option > input[name=plus]');
		var btnMinus = $('.option > input[name=minus]');
		var txtCount = $('.option > input[name=count]');
		var disPrice = $('.dis_price > ins');
		var priceTag = $('.total > span');

		btnPlus.click(function(){
			var count = txtCount.val();			
			var num = parseInt(count) + 1;
			var txtPrice = disPrice.text();
			//comma를 제거 후 int로 변환
			var intPrice = parseInt(txtPrice.replace(/,/g,''));
			var totPrice = intPrice*num;
			
			txtCount.val(num);
			//toLocaleString()은 자동으로 comma를 찍어준다.
			priceTag.text(totPrice.toLocaleString());
		});
		btnMinus.click(function(){
			var count = txtCount.val();			
			var num = parseInt(count) - 1;

			if(num <= 0){
				alert('최소 수량은 1개 입니다.');
				return;
			}
			var txtPrice = disPrice.text();
			//comma를 제거 후 int로 변환
			var intPrice = parseInt(txtPrice.replace(/,/g,''));
			var totPrice = intPrice*num;
			
			txtCount.val(num);
			priceTag.text(totPrice.toLocaleString());
		});  	
	});