package com.example.razli.pense.expenseoverview


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razli.pense.R
import kotlinx.android.synthetic.main.fragment_expense_overview.*

class ExpenseOverviewFragment : Fragment(), ExpenseOverviewContract.View {

    override lateinit var presenter: ExpenseOverviewContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        presenter = ExpenseOverviewPresenter(this)

        return inflater.inflate(R.layout.fragment_expense_overview, container, false)
    }

    override fun onStart() {
        super.onStart()

        // todo remove this junk. Just use the button widget
        enter_expense_editText.addTextChangedListener(object:TextWatcher{

            override fun afterTextChanged(p0: Editable?) {
                val newExpense = p0.toString().toDouble()
                presenter.addNewExpense(newExpense)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Do nothing
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Do nothing
            }

        })
    }

    override fun showUpdatedExpense(newExpense: Double) {
        total_expense_tv.text = getString(R.string.total_expense, newExpense)
    }

}
