package com.example.razli.pense.expenseoverview

class ExpenseOverviewPresenter(val view: ExpenseOverviewContract.View) : ExpenseOverviewContract.Presenter {

    var totalExpense: Double = 0.0

    init {
        view.presenter = this
    }

    override fun start() {

    }

    override fun addNewExpense(expense: Double) {
        totalExpense += expense
        view.showUpdatedExpense(totalExpense)
    }
}