package com.example.moviedb.ui.register

import java.util.regex.Pattern

object RegistrationUtil {

    /**
     * The test cases will pass if..
     * ...username/password/confirmPassword is not empty
     * ...password is at least 2 digits
     * ...password matches the confirm Password
     * ...username is not taken
     */
    fun validRegistrationInput(
        userName : String,
        email : String,
        password : String,
        confirmPassword : String
    ) : Boolean {
        // write conditions along with their return statement
        // if username / password / confirm password are empty return false
        if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            return false
        }

        // if password does not matches confirm password return false
        if (password != confirmPassword){
            return false
        }
        // if number of charcater in password is less than 2 return false
        if (password.count() < 2){
            return false
        }

        val EMAIL_PATTERN : Pattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        );

        // if email format is incorrect, return false
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            return false
        }
        return true
    }
}
