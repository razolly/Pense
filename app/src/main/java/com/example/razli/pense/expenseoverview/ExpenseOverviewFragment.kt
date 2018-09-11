package com.example.razli.pense.expenseoverview


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razli.pense.R

class ExpenseOverviewFragment : Fragment(), ExpenseOverviewContract.View {

    override lateinit var presenter: ExpenseOverviewContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_expense_overview, container, false)
    }
}
