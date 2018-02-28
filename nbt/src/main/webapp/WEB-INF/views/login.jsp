<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Jsp</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></link>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<spring:url value="/css/floating-labels.css" var="floatingCss" />
<link href="css/floating-labels.css" rel="stylesheet" />



<script type="text/javascript">
$(function() {
   /*  Submit form using Ajax */
   $('button[type=submit]').click(function(e) {
   
      //Prevent default submission of form
      e.preventDefault();
      
      //Remove all errors
      $('input').next().remove();
      
      console.log($('form[name=loginForm]').serialize())
      
      $.post({
         url : '/login',
         data : $('form[name=loginForm]').serialize(),
         success : function(res) {
        	if(res) {
        		console.log(res)
        	}
         }
      })
   });
});
</script>




</head>
<body>
	<form class="form-signin" name="loginForm" id="loginForm" action="/login" method="post">
      <div class="text-center mb-4">
		<spring:url value="images/nb_icon.png" var="nbIcon" />      
        <img class="mb-4" src="${nbIcon}" alt="no brokers icon" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Login Page</h1>
      </div>
	 
	  
      <div class="form-label-group">
        <input type="text" id="username" name="username" class="form-control" placeholder="User Name" required autofocus>
        <label for="username">User Name</label>
      </div>

      <div class="form-label-group">
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <label for="password">Password</label>
      </div>
      
      <div class="form-label-group">
      	<select name="role" id="role" class="form-control" required>
      		<option value="MEMBER">Member</option>
      		<option value="ADMIN">Admin</option>
      	</select>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
    </form>
</body>
</html>