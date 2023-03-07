package com.example.workmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.workmanager.database.WorkDB
import com.example.workmanager.databinding.FragmentWorkAddBinding
import com.example.workmanager.models.WorkListViewModel
import com.example.workmanager.models.WorkListViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkAddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkAddFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind : FragmentWorkAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_work_add,container, false)
        val application = requireNotNull(this.activity).application
        val dataDb = WorkDB.getInstance(application).expenseDBDao

        val viewModelFactory = WorkListViewModelFactory(dataDb, application)
        val viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[WorkListViewModel::class.java]
        bind.viewModel = viewModel

        bind.lifecycleOwner = viewLifecycleOwner

        bind.button.setOnClickListener {
            viewModel.submit(
                bind.editTextTextPersonName.text.toString(),
                bind.editTextTextMultiLine.text.toString()
            )
            this.findNavController().navigate(R.id.action_workAddFragment_to_taskListFragment)
        }

        // Inflate the layout for this fragment
        return bind.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkAddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkAddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}