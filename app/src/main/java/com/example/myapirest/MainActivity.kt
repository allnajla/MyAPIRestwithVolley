package com.example.myapirest


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        // on below line we are creating a variable for url
        var url = "https://offresemplois.herokuapp.com/Offres"

        // on below line we are creating a
        // variable for our request queue
        val queue = Volley.newRequestQueue(this)


        // on below line we are creating a request
        // variable for making our json object request.
        val request = JsonArrayRequest(Request.Method.GET, url, null, { response ->
                // this method is called when we get successful response from API.

                try {
                    for (i in 0 until response.length()) {
                       val respObj = response.getJSONObject(i)
                        Log.i("Success", respObj.toString());
                    }
                    // on below line we
                    // are handling exception
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }, { error ->
                // in this case we are simply displaying a toast message.
                //Toast.makeText(this, "Fail to get response", Toast.LENGTH_SHORT).show()
                Log.e("request-error", error.toString());
            })
        // at last we are adding our
        // request to our queue.

        queue.add(request)
    }

}