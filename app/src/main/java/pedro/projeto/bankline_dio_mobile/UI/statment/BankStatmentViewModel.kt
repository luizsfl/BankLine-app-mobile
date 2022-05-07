package pedro.projeto.bankline_dio_mobile.UI.statment

import androidx.lifecycle.ViewModel
import pedro.projeto.bankline_dio_mobile.data.remote.BankLineRepository

class BankStatmentViewModel :ViewModel(){
    fun findBankStatement(accountHolderId: Int)
    = BankLineRepository.findBankStatement(accountHolderId)

}