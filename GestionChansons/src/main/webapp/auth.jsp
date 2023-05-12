<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<!--<link rel="stylesheet" href="css/auth.css">
		 <script src="js/auth.js"></script> -->

 <form method="post" action="userAuth">
  
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong">
          <div class="card-body p-5 text-center">
			<h5 class="text-danger">${erreur}</h5>
            <h3 class="mb-5">Sign in</h3>

            <div class="form-outline mb-4">
                <label class="form-label" for="typeEmailX-2">Login</label>
                <input type="email" id="typeEmailX-2" class="form-control form-control-lg" name="login" required />
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="typePasswordX-2">Password</label>
                <input type="password" id="typePasswordX-2" class="form-control form-control-lg" name="password" required />
            </div>

            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
          </div>
        </div>
      </div>
    </div>
  </div>

</form>
</body>
</html>
