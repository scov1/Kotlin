package org.step.students.presentation.fragment

import org.step.students.domain.currency.CurrencyUseCase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_currency.*
import org.step.students.R
import org.step.students.domain.currency.Currency
import org.step.students.presentation.interfaces.CurrencyInterfaceContract
import org.step.students.presentation.adapter.CurrencyAdapter
import javax.inject.Inject


class CurrencyFragment : Fragment(), CurrencyInterfaceContract.View {

    var rootView: View? = null
    lateinit var presenter: CurrencyInterfaceContract.Presenter
    var currencyAdapter: CurrencyAdapter? = null
    val currencies: ArrayList<Currency> = ArrayList()
    var currency: org.step.students.data.Currency? = null
    @Inject
    lateinit var currenciesUseCase: CurrencyUseCase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_currency, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // dagger
      //  DaggerCurrencyComponent.builder().currencyModule(CurrencyModule()).build().inject(this)

        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        //initializeListeners()
        presenter.initializeData()
        // retrofit


    }


     override fun initializeListeners() { }

     fun onClick(v: View?) { }

     override fun initializePresenter() {
        presenter = CurrencyFragmentPresenter(context?.applicationContext!!)
        presenter.attach(this)
    }

     override fun initializeLayoutManager() {
        recyclerview_fragment_currencies?.layoutManager = LinearLayoutManager(context!!)
    }

     override fun initializeAdapter() {
        currencyAdapter = CurrencyAdapter(context!!, currencies, presenter as CurrencyFragmentPresenter)
        recyclerview_fragment_currencies?.adapter = currencyAdapter
    }

     override fun initiateUpdateAdapter() {
        currencyAdapter?.notifyDataSetChanged()
    }

     override fun processData(currencies: ArrayList<Currency>) {
        this.currencies.clear()
        this.currencies.addAll(currencies)
    }

    override fun initializeViews() { }

    override fun initializeArguments() { }

    override fun initializeDependencies() { }


}