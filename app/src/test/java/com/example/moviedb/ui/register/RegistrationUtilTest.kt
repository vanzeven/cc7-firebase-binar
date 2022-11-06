package com.example.moviedb.ui.register

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {
    // Write tests for the RegistrationUtil class considering all the conditions
    // annotate each function with @Test
    // We can use backtick to write function name..
    // whatever we write in those backtick will be considered as function name
    @Test
    fun `empty username returns false`(){
        // Pass the value to the function of RegistrationUtil class
        // since RegistrationUtil is an object/ singleton we do not need to create its object
        val result = RegistrationUtil.validRegistrationInput(
            "",
            "",
            "123",
            "123"
        )
        // assertThat() comes from the truth library that we added earlier
        // put result in it and assign the boolean that it should return
        assertThat(result).isFalse()
    }

    // follow the same for other cases also
    // in this test if username and correctly repeated password returns true
    @Test
    fun `username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validRegistrationInput(
            "faisal",
            "faisal@gmail.com",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    // if confirm password does nt matches the password return false
    @Test
    fun `incorrect confirm password returns false`() {
        val result = RegistrationUtil.validRegistrationInput(
            "faisal",
            "faisal@gmail.com",
            "123",
            "1234"
        )
        assertThat(result).isFalse()
    }

    // in this test if password has less than two digits than return false
    @Test
    fun `less than two character password return false`() {
        val result = RegistrationUtil.validRegistrationInput(
            "faisal",
            "faisal@gmail.com",
            "a",
            "a"
        )
        assertThat(result).isFalse()
    }

    // correct email input
    @Test
    fun correctEmail() {
        val result = RegistrationUtil.validRegistrationInput(
            "faisal",
            "faisal@gmail.com",
            "aa",
            "aa"
        )
        assertThat(result).isTrue()
    }

    // email with subdomain
    @Test
    fun emailSubdomain() {
        val result = RegistrationUtil.validRegistrationInput(
            "faisal",
            "faisal@gmail.co.id",
            "aa",
            "aa"
        )
        assertThat(result).isTrue()
    }

    // without top level domain
    @Test
    fun withoutTld() {
        val result = RegistrationUtil.validRegistrationInput(
            "faisal",
            "faisal@gmail",
            "aa",
            "aa"
        )
        assertThat(result).isFalse()
    }

    // with extra character
    @Test
    fun withExtraChar() {
        val result = RegistrationUtil.validRegistrationInput(
            "faisal",
            "faisal@gmail..com",
            "aa",
            "aa"
        )
        assertThat(result).isFalse()
    }
}
