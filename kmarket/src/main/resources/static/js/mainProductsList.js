//추천, 최신, 할인 상태변수
var isCompleteReco = false;
var isCompleteNew = false;
var isCompleteDisc = false;

$(document).ready(function(){
	
	//섹션객체 선택
	var sectionHit = $('section.hit');
	var sectionRecommend = $('section.recommend');
	var sectionNew = $('section.new');
	var sectionDiscount = $('section.discount');
	
	$(window).scroll(function(){
		
		var pos = $(this).scrollTop();
		
		if(pos >= 200 && !isCompleteReco){
			
			isCompleteReco = true;
			getProducts(sectionRecommend, '/kmarket/main/recommend');
		}else if(pos >= 400 && !isCompleteNew){
			isCompleteNew = true;
			getProducts(sectionNew,'/kmarket/main/newItems');
		}else if(pos >= 600 && !isCompleteDisc){
			isCompleteDisc = true;
			getProducts(sectionDiscount,'/kmarket/main/discountItem');
		}
		
		
	});//scroll end
	
	function getProducts(section, url){
		$.ajax({
			url: url,
			type:'get',
			dataType: 'json',
			success: function(data){
				section.find('img').remove();
				//히트상품에 잇는 article을 복사하여 추천 상품 영역에 넣어주기
				$.each(data, function(i, item){
					
					var dom = $('.hit > article:eq(0)').clone();
					
					var imgUrl = '/kmarket/thumb/'+item.cate1+"/"+item.cate2+"/"+item.thumb1;
					//태그의 속성을 수정하는 함수 attr
					dom.find('.thumb > img').attr('src', imgUrl);
					dom.find('h2').text(item.name);
					dom.find('p').text(item.descript);
					//.toLocaleString() 은 자바스크립트 내장함수로 숫자 세자리마다 콤마 찍어준다.
					dom.find('.org_price > del').text(item.price.toLocaleString());
					dom.find('.org_price > span').text(item.discount+'%');
					dom.find('.dis_price > ins').text(item.salePrice.toLocaleString());
					
					if(item.delivery > 0){
						dom.find('.dis_price > span').remove();
					}
					
					section.append(dom);
				});
				
			}
			
		});
	}
	
});//jquery end