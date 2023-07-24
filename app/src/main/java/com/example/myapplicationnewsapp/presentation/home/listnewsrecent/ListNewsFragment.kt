package com.example.myapplicationnewsapp.presentation.home.listnewsrecent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewsapp.databinding.FragmentListNewsBinding
import com.example.myapplicationnewsapp.presentation.home.model.TabHome
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListNewsFragment : Fragment() {

  private val viewModel: ListNewsViewModel by viewModels()

  private var itemAdapter: ListNewsRecentAdapter? = null

  lateinit var binding: FragmentListNewsBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentListNewsBinding.inflate(layoutInflater, container, false)

    setupAdapter()
    observe()

    return binding.root
  }

  private fun setupAdapter() {
    itemAdapter = ListNewsRecentAdapter(
      ListNewsRecentAdapter.OnclickListener {
      }
    )
    binding.rvNewsRecent.let {
      it.adapter = itemAdapter
      it.layoutManager = LinearLayoutManager(requireContext())
    }
  }

  private fun observe() {
    val type = arguments?.getInt(ARGS_TYPE)
    var param = ""
    when (type) {
      TabHome.BUSINESS.type -> param = "business"
      TabHome.ENTERTAINMENT.type -> param = "entertainment"
      TabHome.HEALTH.type -> param = "health"
      TabHome.SCIENCE.type -> param = "science"
      TabHome.SPORTS.type -> param = "sports"
      TabHome.TECHNOLOGY.type -> param = "technology"
    }
    lifecycleScope.launch {
      itemAdapter?.loadStateFlow?.collectLatest { loadStates ->
        when (loadStates.refresh) {
          is LoadState.Loading -> {
          }

          is LoadState.Error -> {
          }

          is LoadState.NotLoading -> {
          }
        }
      }
    }

    lifecycleScope.launch {
      viewModel.getListNewsRecent(param).collectLatest {
        itemAdapter?.submitData(it)
      }
    }
  }

  companion object {
    private const val ARGS_TYPE = "TYPE"
    private const val ARGS_PARAM = "PARAM"
    fun newInstance(
      type: Int,
      param: String
    ): ListNewsFragment {
      return ListNewsFragment().apply {
        arguments = Bundle().apply {
          putInt(ARGS_TYPE, type)
          putString(ARGS_PARAM, param)
        }
      }
    }
  }
}