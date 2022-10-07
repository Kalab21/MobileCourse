package com.miu.walmatrstroreapp_extention
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    val users = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        var user1 = User("kal@miu.edu", "123", "Kalabe", "Kebede")
        var user2 = User("keb@miu.edu", "123", "Kebede", "John")
        var user3 = User("Jhon@miu.edu", "123", "John", "Gzo")
        var user4 = User("ethi@miu.edu", "123", "Ethio", "Nana")
        var user5 = User("enkhe@miu.edu", "123", "Danial", "Hana")
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)
        signin.setOnClickListener {

            val email = emailAddr.text.toString()
            val passwd = password.text.toString()

            for (i in users) {
                if (email == i.username && passwd == i.password) {
                    var intent = Intent(this, Shoping_activity::class.java)
                    intent.putExtra("1", email)
                    startActivity(intent)
                    return@setOnClickListener
                }

            }
            Toast.makeText(applicationContext, "User not found.", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener() {
            var intent_create = Intent(this, CreateAccount::class.java)
            startActivityForResult(intent_create, 2)

        }
        forgetP.setOnClickListener() {

            var email = emailAddr.text.toString()
            for (i in users) {
                if (email == i.username) {

                    var setIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
                    setIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    setIntent.putExtra(Intent.EXTRA_SUBJECT, "Recovered password:")
                    setIntent.putExtra(Intent.EXTRA_TEXT, "Password is: ${i.password}")
                    startActivity(Intent.createChooser(setIntent, "Sending via"))

                    return@setOnClickListener
                }

            }
            Toast.makeText(applicationContext, "User not found", Toast.LENGTH_SHORT).show()
        }
   }
        public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, intent)
            if (requestCode== 2) {
                if (resultCode== RESULT_OK) {
                    var tmpUser = data?.getSerializableExtra("user") as User
                    users.add(tmpUser)
                    Toast.makeText(applicationContext ,"User Added!", Toast.LENGTH_SHORT).show()
                }
            }
    }

}