package pedro.projeto.bankline_dio_mobile.UI.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pedro.projeto.bankline_dio_mobile.R
import pedro.projeto.bankline_dio_mobile.UI.statment.BankStatmentActivity
import pedro.projeto.bankline_dio_mobile.databinding.ActivityWelcomeBinding
import pedro.projeto.bankline_dio_mobile.domain.Correntista

class WelcomeActivity : AppCompatActivity() {

    private val binding  by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btContinue.setOnClickListener {
            val accontHolderId = binding.etAccountHolderId.text.toString().toInt()
            val accountHolder = Correntista(accontHolderId)

            val intent = Intent(this,BankStatmentActivity::class.java)
                .apply {
                    putExtra(BankStatmentActivity.EXTRA_ACCOUNT_HOLDER,accountHolder)
                }

            startActivity(intent)


        }


    }
}