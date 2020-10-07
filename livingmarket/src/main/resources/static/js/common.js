/*index 슬라이더*/
$(document).ready(function(){
    $('.slider > ul').bxSlider({
        pager:false
    });
});

/* index 전체보기 메뉴*/
$(function(){

    var cate = $('.m_main > ul > .category ');

    cate.hover(function(){
        $(this).children().eq(1).stop().slideDown(100);
        },function(){
        $(this).children().eq(1).stop().slideUp(100); 
        });
});