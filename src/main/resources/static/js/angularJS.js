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
    		
    		$scope.$apply();
    		console.log(result);
    	}
    })
    
});