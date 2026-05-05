package com.github.leodan11.otptextview.content

interface OTPListener {
    /**
     * Callback Fired when user starts typing in the OTP/PIN box.
     */
    fun onInteractionListener(char: CharSequence) {  }

    /**
     * @param otp Filled OTP
     * Callback Fired when user has completed filling the OTP/PIN.
     */
    fun onOTPComplete(otp: String)
}