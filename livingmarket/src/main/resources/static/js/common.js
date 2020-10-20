
/* index 전체보기 메뉴*/
$(function(){

    var cate = $('.m_main > ul > .category ');

    cate.hover(function(){
        $(this).children().eq(1).stop().slideDown(100);
        },function(){
        $(this).children().eq(1).stop().slideUp(100); 
        });
    $('#top').click(function(){
	   $('html, body').animate({'scrollTop' : 0});
   	});
});