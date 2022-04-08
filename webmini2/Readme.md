# Webmini2

<h3 align="center"><b>📂 Project Directory Structure 📁</b></h3>

<pre>
<code>
/com.sparta.Webmini2
  └──/config
     └── /SwaggerConfig.java
  └──/controller
     ├── /HomeController.java
     ├── /PostController.java
     ├── /CommentController.java
     └── /UserController.java
  └──/dto
     ├── /PostRequestDto.java
     ├── /CommentRequestDto.java
     ├── /SignupRequestDto.java
     └── /UserInfoDto.java
  └──/entity
     ├── /Post.java
     ├── /Comment.java
     ├── /Timestamped.java
     └── /User.java
  └──/repository
     ├── /PostRepository.java
     ├── /CommentRepository.java
     └── /UserRepository.java
  └──/security
     └── /filter
         ├── /FormLoginFilter.java
         └── /JwtAuthFilter.java
     └── /jwt
         ├── /HeaderTokenExtractor.java
         ├── /JwtDecoder.java
         ├── /JwtPreProcessingToken.java
         └── /JwtTokenUtils.java
     └── /provider
         ├── /FormLoginAuthProvider.java
         └── /JWTAuthProvider.java
     ├── /FilterSkipMatcher.java
     ├── /FormLoginSuccessHandler.java
     ├── /UserDetailsImpl.java
     ├── /UserDetailsServiceImpl.java
     └── /WebSecurityConfig.java
  └──/service
     ├── /HomeService.java
     ├── /PostService.java
     ├── /CommentService.java
     └── /UserService.java
  └──/validator
     └── /UserInfoValidator.java
  └──/Webmini2Application.java
</code>
</pre>