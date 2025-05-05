package app.kariai.auth.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

class RedirectReceiver(private val onCodeReceived: (String) -> Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val uri: Uri? = intent.data
        if (uri != null) {
            Log.d("Auth", "Received URI: $uri")

            val code = uri.getQueryParameter("code")
            if (code != null) {
                Log.d("Auth", "Received code: $code")
                onCodeReceived(code)
            } else {
                Log.e("Auth", "No code in the URI.")
            }
        }
    }
}