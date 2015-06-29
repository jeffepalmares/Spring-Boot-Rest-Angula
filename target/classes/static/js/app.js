var app = angular.module('myApp', []);
	
	app.controller('taskManeger', function($scope, $http) {
		
		$scope.toggle = function (idPanel){
    		switch(idPanel){
    			case 1: 
        			$scope.listPanel = false;
        			$scope.insertListPanel = true;
        	    	$scope.insertTaskPanel = true;
        	    	$scope.listTaskPanel = true;
        	    	break;
    			case 2: 
    				$scope.listPanel = true;
    				$scope.insertListPanel = false;
    		    	$scope.insertTaskPanel = true;
    		    	$scope.listTaskPanel = true;
    		    	break;
    			case 3: 
    				$scope.listPanel = true;
    				$scope.insertListPanel = true;
    				$scope.insertTaskPanel = false;
    				$scope.listTaskPanel = true;
    				break;
    			case 4: 
    				$scope.listPanel = true;
    				$scope.insertListPanel = true;
    				$scope.insertTaskPanel = true;
    				$scope.listTaskPanel = false;
    				break;
    		}
    		
    	}
		
    	findAllTasks();
		
    	$http.defaults.headers.post["Content-Type"] = "application/json";
		
		$scope.saveList = function(){
    	
			var data = {"name": $scope.listName , 
					   "description" : $scope.listDescription , 
					   "id" : $scope.listId}
    
			$http.post( '/save' , data ).success(
    					function(data, status, headers, config) {
    						findAllTasks();
    			  }).
    			  error(function(data, status, headers, config) {
    			    alert('Error');
    			  });		
		}

		$scope.saveTask = function(){
			
			var data = {"name": $scope.taskName , 
						"description" : $scope.taskDescription , 
						 "id" : $scope.taskId,
						 "idList" : $scope.listId
						}
			
			$http.post( '/saveTask' , data ).success(
					function(data, status, headers, config) {
						findAllTasks();
					}).
					error(function(data, status, headers, config) {
						alert('Error');
					});		
		}
		
		$scope.edit = function(index){
        	$scope.listName = $scope.tasksList[index].name;
        	$scope.listDescription = $scope.tasksList[index].description;
        	$scope.listId = $scope.tasksList[index].id;
        	$scope.toggle(2);
		}
		
		$scope.editTask = function(index){
			$scope.toggle(3);
        	$scope.taskName = $scope.tasks[index].name;
        	$scope.taskDescription = $scope.tasks[index].description;
        	$scope.taskId = $scope.tasks[index].id;
		}
		
		$scope.removeTask = function(index){
			var data = {"id" : $scope.tasks[index].id};
			$http.post('/deleteTask' , data ).success(
					function(data, status, headers, config) {
						alert('Task List deleted sucessfull!')
						findAllTasks();
			});
		}
		$scope.remove = function(index){
			var data = {"id" : $scope.tasksList[index].id};
			$http.post('/delete' , data ).success(
					function(data, status, headers, config) {
						alert('Task List deleted sucessfull!')
						findAllTasks();
			});
		}
    
	$scope.findTasks = function(index) {
    	var data = {"idList" : $scope.tasksList[index].id}
    	$scope.listName = $scope.tasksList[index].name;
    	$scope.listId = $scope.tasksList[index].id;
    	$http.post('/findTask' , data).success(
				function(data, status, headers, config){
                if (data != undefined) {
                	$scope.tasks = data;
                	$scope.toggle(4);
                } else {
                    $scope.tasks = [];
                }
            });
    }
    function findAllTasks() {
    	//get all tasks and display initially
    	$http.get('/find').
    	success(function (data) {
    		if (data != undefined) {
    			$scope.tasksList = data;
    			$scope.toggle(1);
    		} else {
    			$scope.tasksList = [];
    		}
    	});
    }
    
    
});