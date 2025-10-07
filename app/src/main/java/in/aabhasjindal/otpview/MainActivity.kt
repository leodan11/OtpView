package `in`.aabhasjindal.otpview

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.leodan11.otptextview.OTPListener
import com.github.leodan11.otptextview.OtpTextView

class MainActivity : AppCompatActivity() {
    private var otpTextView: OtpTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val errorButton = findViewById<Button>(R.id.button)
        val successButton = findViewById<Button>(R.id.button2)
        val valueButton = findViewById<Button>(R.id.button3)
        otpTextView = findViewById(R.id.otp_view)
        otpTextView?.requestFocusOTP()
        otpTextView?.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(otp: String) {
                Toast.makeText(this@MainActivity, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        }
        errorButton.setOnClickListener { otpTextView?.showError() }
        successButton.setOnClickListener { otpTextView?.showSuccess() }
        valueButton.setOnClickListener {  Toast.makeText(this@MainActivity, "The OTP is ${otpTextView?.otp}", Toast.LENGTH_SHORT).show() }
    }
}
