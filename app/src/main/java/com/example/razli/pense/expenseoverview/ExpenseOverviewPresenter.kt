package com.example.razli.pense.expenseoverview

class ExpenseOverviewPresenter(val view: ExpenseOverviewContract.View) : ExpenseOverviewContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {

    }

}