$(document).ready(function(){
	$(".nn-like").on("click",function(){
		const id=$(this).closest("[data-id]").attr("data-id")
		const url=`/product/like/${id}`;
		$.getJSON(url).then(resp=>{
			alert(resp);
		})
	})
	
	$(".nn-share").on("click",function(){
		id=$(this).closest("[data-id]").attr("data-id")
		
	});
	
	$(".nn-send").on("click",function(){
		var data={
			id:id,
			email:$("#email").val()
		}
		const url=`/product/send`;
		$.post(url,data).then(resp=>{
			alert(resp);
		})
	});
})
