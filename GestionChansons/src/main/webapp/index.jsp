<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spotify</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            overflow: hidden;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            margin-top: 100px;
            border-radius: 10px;
        }
        #background-video {
            position: fixed;
            right: 0;
            bottom: 0;
            min-width: 100%;
            min-height: 100%;
            width: auto;
            height: auto;
            z-index: -1;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>Welcome to Spotify</h1>
        <p>Discover and enjoy a wide range of music!</p>
    </div>
    <div class="text-center mt-4">
        <a href="userAuth" class="btn btn-primary btn-lg">Get Started</a>
    </div>
</div>
<video id="background-video" autoplay loop muted>
    <source src="images/c.mp4" type="video/mp4">
    <!-- Add additional source elements for different video formats -->
</video>
</body>
</html>
