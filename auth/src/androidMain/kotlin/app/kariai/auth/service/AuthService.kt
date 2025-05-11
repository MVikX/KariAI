package app.kariai.auth.service

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent

actual class AuthService(private val context: Context, private val onCodeReceived: (String) -> Unit) {

    private val authorizationUrl = "https://accounts.google.com/o/oauth2/v2/auth" +
            "?client_id=101347411205-elqeg5dqa55bp853k7pv81olq3g1qer5.apps.googleusercontent.com" +
            "&redirect_uri=https://kariai.app/auth/callback" +
            "&response_type=code" +
            "&scope=openid%20email%20profile" +
            "&access_type=offline" +
            "&prompt=select_account"

    actual fun openAuthorization() {
        val intent = CustomTabsIntent.Builder().build()
        Log.d("Auth", "Opening Google OAuth URL: $authorizationUrl")
        intent.launchUrl(context, Uri.parse(authorizationUrl))
    }

    fun handleRedirect(intent: Intent) {
        val uri: Uri? = intent.data
        if (uri != null) {
            Log.d("Auth", "Received URI: $uri")

            val code = uri.getQueryParameter("code")
            if (code != null) {
                Log.d("Auth", "Received code: $code")

                val sharedPref = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("auth_code", code)
                editor.apply()

                onCodeReceived(code)
            } else {
                val error = uri.getQueryParameter("error")
                if (error != null) {
                    Log.e("Auth", "Error received: $error")
                } else {
                    Log.d("Auth", "No code in the URI.")
                }
            }
        } else {
            Log.e("Auth", "No URI found in the intent.")
        }
    }
}