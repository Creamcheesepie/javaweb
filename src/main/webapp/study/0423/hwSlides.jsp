<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/include/bs4.jsp"/>

<script>
    //헤더에 넣은 슬라이드 js
    let loopInterval = setInterval(()=>{
      nextMove();
    },3000);

    slide.addEventlistener("mouseover",() =>{
      clearInterval(loopInterval);
    });

    slide.addEventlistener("mouseout",()=>{
      loopInterval(()=>{
        nextMove();
      },3000);
    });
</script>
  
<div class="slide slide_wrap" style="height: 950px;background-image: url();">
  <div class="slide_item item1"></div>
  <div class="slide_item item2"></div>
  <div class="slide_item item3"></div>
  <div class="slide_item item4"></div>
</div>