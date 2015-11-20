$(function (){
  $('select').change(gethw);
  gethw();
});

function gethw(){
  var filename = $('select').val();
  $.ajax(filename,{type:"GET"}).done(showhw).fail(ajaxFailure);
}

function showhw(data){
  $('textarea').val(data);
}

function ajaxFailure(){
  
}