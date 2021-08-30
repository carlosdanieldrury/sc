package com.drury.suggesticchallenge.presentation.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.drury.suggesticchallenge.R
import com.drury.suggesticchallenge.databinding.FragmentListBinding
import com.drury.suggesticchallenge.presentation.view.adapters.ListAdapter
import com.drury.suggesticchallenge.presentation.viewmodel.ListPageStatus
import com.drury.suggesticchallenge.presentation.viewmodel.ListViewModel
import com.drury.suggesticchallenge.utils.gone
import com.drury.suggesticchallenge.utils.show
import org.koin.core.component.inject

/**
 * ListFragment which contains the list of the model and will show an AlertDialog according to user action clicking on the cell
 */
class ListFragment : BaseFragment(), OnClickItemListerner {

    private var _binding: FragmentListBinding? = null
    private val listViewModel: ListViewModel by inject()
    private val listAdapter = ListAdapter(this)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        setupViewElements()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        binding.buttonGetAgenda.setOnClickListener {
            listViewModel.getDiaryMessageList()
        }
        listViewModel.getDiaryMessageList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        setupListAdapterListerner()
        setupPageStatusListerner()
    }

    private fun setupListAdapterListerner() {
        listViewModel.listLiveData.observe(this, Observer { list ->
            listAdapter.setItems(list)
        })
    }

    private fun setupPageStatusListerner() {
        listViewModel.pageStatusLiveData.observe(this, Observer { pageStatus ->
            when (pageStatus) {
                ListPageStatus.Loading -> {
                    binding.progressBar.show()
                    binding.buttonGetAgenda.gone()
                    binding.list.gone()
                    binding.errorText.gone()
                }
                ListPageStatus.Error -> {
                    binding.progressBar.gone()
                    binding.buttonGetAgenda.show()
                    binding.list.gone()
                    binding.errorText.show()
                }
                ListPageStatus.Content -> {
                    binding.progressBar.gone()
                    binding.buttonGetAgenda.gone()
                    binding.list.show()
                    binding.errorText.gone()
                }
            }
        })
    }

    private fun setupViewElements() {
        binding.list.layoutManager = LinearLayoutManager(context)
        binding.list.apply {
            adapter= listAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

    }

    override fun showAlertDialog(title: String, message: String) {
        context?.let { ctx ->
            val dialogBuilder = AlertDialog.Builder(ctx)
            dialogBuilder.setTitle(title)
            dialogBuilder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.ok_button) {
                        dialog, _ -> dialog.dismiss()
                }
            val alert = dialogBuilder.create()
            alert.show()
        }
    }
}