<g:set var='securityConfig' value='${applicationContext.springSecurityService.securityConfig}'/>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>Idea Submission</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'Favicon.ico')}" type="image/x-icon">
  		<asset:stylesheet src="mainapp.css"/>
		<asset:javascript src="application.js"/>
		<asset:stylesheet src="bootstrap-datepicker3.min.css"/>
		<asset:javascript src="bootstrap-datepicker.min.js" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<asset:stylesheet src="bootstrap.css"/>
		<asset:stylesheet src="open-iconic-bootstrap.min.css" />
		<g:layoutHead/>
	</head>
	<body>
		<span id="logoutLink" style="display:none">
                        <g:link elementId='_logout' controller='logout'/>
                        <span href="${request.contextPath}${securityConfig.logout.afterLogoutUrl}" id="_afterLogout"></span>
        </span>
		<nav class="navbar navbar-dark bg-dark fixed-top navbar-expand-md">
      	<div class="container">

			<button type="button" class="navbar-toggler collapsed" data-toggle="collapse"
					data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span>
				&#x2630;</button>

        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a  class="nav-link" href="${request.contextPath}/">Home</a></li>
             <sec:ifLoggedIn>
				 <li><a  class="nav-link"
				 <sec:ifNotGranted roles="ROLE_ADMIN">
					 href="${request.contextPath}/idea/createUser">
				 </sec:ifNotGranted>
				 <sec:ifAnyGranted roles="ROLE_ADMIN">
					href="${request.contextPath}/idea/create">
				 </sec:ifAnyGranted>
				 Create An Idea</a></li>
				 <sec:ifAnyGranted roles="ROLE_ADMIN">
					 <li class="dropdown nav-item">
					 <a class="dropdown-toggle nav-link" data-toggle="dropdown" href="#">Administration
        				<span class="caret"></span></a>
						<ul class="dropdown-menu">
                           <li class="nav-item dropdown-item"><a  class="nav-link"  href="${request.contextPath}/employees">Employees</a> </li>
						 <li class="nav-item dropdown-item"><a  class="nav-link" href="${request.contextPath}/KPOType">KPO Type</a></li>
						 <li class="nav-item dropdown-item"><a  class="nav-link"  href="${request.contextPath}/employeeBoss">Employee to Boss Relationship</a></li>
						 </ul>
					 </li>
				 </sec:ifAnyGranted>
             </sec:ifLoggedIn>
            </ul>
			<ul class="nav navbar-nav ml-auto"><li>
          <sec:ifLoggedIn>
			  <g:link controller="logout" class="nav-link vert_center" aria-haspopup="true" aria-expanded="false" elementId="logout"><g:message code='spring.security.ui.login.logout'/> <ps:getUserName /></g:link>
          </sec:ifLoggedIn>
          <sec:ifNotLoggedIn>
			  <g:link controller='login'  class="nav-link" action='auth'>Login</g:link>
			</sec:ifNotLoggedIn>
       		</li></ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container">
    	<div class="starter-template" style="margin-top:70px;">
		<g:if test="${!flash.error.equals(null)}">
			<div class="fm-error-msg error-details ui-state-error">${flash.error}</div>
		</g:if>
		<g:layoutBody/>
		 </div>
     </div>
     <footer class="footer navbar-fixed-bottom navbar-dark bg-dark">
     		<div class="container" style="color:#FFFFFF;">&copy; 2015<script>new Date().getFullYear()>2010&&document.write("-"+new Date().getFullYear());</script>, Aaron Mondelblatt. <g:meta name="info.app.version"/>
     		</div>
    </footer>
	</body>
</html>
