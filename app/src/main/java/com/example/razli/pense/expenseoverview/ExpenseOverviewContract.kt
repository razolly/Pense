package com.example.razli.pense.expenseoverview

import com.example.razli.pense.utils.BasePresenter
import com.example.razli.pense.utils.BaseView

interface ExpenseOverviewContract {

    interface View : BaseView<Presenter> {

        fun showUpdatedExpense(newExpense: Double)

    }

    interface Presenter : BasePresenter {

        fun addNewExpense(expense: Double)

    }

}