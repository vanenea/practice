var html;
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.users = [];
	$.ajax({
    	url:'showUser',
    	type:'get',
    	typedata:'json',
    success:function(result){
    		var list = [];
    		var obj;
    		for(var i=0; i<12; i++){
    			obj = {
    				"list": i
    			}
    			list.push(obj);
    		}
    		
    		for(var i=0; i<result.data.length; i++){
    			var user = {
    				"username":	result.data[i].username,
    				"password": result.data[i].password
    			}
    			user.list = list
    			$scope.users.push(user)
    		}
    		console.log($(".next"));
    		console.log($("h1"))
    		$("h1").css("color","yellow")
//    		$scope.dom = {
//    			'color':'yellow'
//    		}
    		$scope.$apply();//刷新变量
    		init();
    		console.log(result);
    		html = $(".temp").html();
    	}
    });
    
    $scope.hs = function(r){
		//$(r).hide();
		$(".next").css("color","yellow")
		$(".temp").empty();
	}
    

});

function hs(r){
	$(".next").css("color","yellow")
	//$(".temp").empty();
}

function init(){
	console.log($(".next"));
	$(".next").css("color","yellow")
	$("#test").click(function(){
		$(".temp").html(html);
		$(".next").css("color","green")
	});
}




