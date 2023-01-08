package com.kapps.wallet.presentation.state

import com.kapps.wallet.presentation.types.TransactionType

data class TransactionDialogState(
    val isOpen:Boolean = false,
    val type: TransactionType = TransactionType.Deposit,
    val isConfirmButtonEnabled:Boolean = false,
    val currentValueInput:String = ""
)
