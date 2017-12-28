var myapp=angular.module("myApp",['ngRoute']);

myapp.config(function($routeProvider)
		{
			$routeProvider.when("#/",{templateUrl:"index.html"})
						  .when("/Blog",{templateUrl:"Blog/Blog.html"})
						  .when("/Forum",{templateUrl:"Forum/Forum.html"})
						  .when("/login",{templateUrl:"User/login.html"})
						  .when("/AdminHome",{templateUrl:"Blog/AdminHome.html"})
			              .when("/UserDetail",{templateUrl:"User/UserDetail.html"})
			              .when("/AdminBlog",{templateUrl:"Blog/AdminBlog.html"})
			              .when("/AdminForum",{templateUrl:"Forum/AdminForum.html"})
		});



