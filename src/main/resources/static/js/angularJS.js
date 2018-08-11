var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $rootScope) {
    $.ajax({
    	url:'showUser',
    	type:'get',
    	typedata:'json',
    	success:function(result){
    		console.log(result);
    	}
    })
    
});