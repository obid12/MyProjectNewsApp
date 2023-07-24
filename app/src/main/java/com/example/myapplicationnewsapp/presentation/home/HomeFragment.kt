package com.example.myapplicationnewsapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.myapplicationnewsapp.databinding.FragmentHomeBinding
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.presentation.home.adapter.CategoryAdapter
import com.example.myapplicationnewsapp.presentation.home.listnewsrecent.ListNewsFragment
import com.example.myapplicationnewsapp.presentation.home.model.HomeModel
import com.example.myapplicationnewsapp.presentation.home.model.TabHomeModel
import com.example.myapplicationnewsapp.utils.Resource
import com.example.myapplicationnewsapp.utils.error
import com.example.myapplicationnewsapp.utils.formatDateForDetails
import com.example.myapplicationnewsapp.utils.getImageNewsSourceUrl
import com.example.myapplicationnewsapp.utils.getImageNewsUrl
import com.example.myapplicationnewsapp.utils.success
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

  private lateinit var binding: FragmentHomeBinding
  private var adapterCategory: CategoryAdapter? = null

  private val viewModel: HomeViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
    setupToolBar()
    setupView()
    loadData()
    setupObserver()

    return binding.root
  }

  private fun setupView() {
    val list: ArrayList<TabHomeModel> = arrayListOf()
    setupTabView(HomeModel.getList(list))
  }

  private fun setupTabView(categories: ArrayList<TabHomeModel>) {
    adapterCategory = CategoryAdapter(childFragmentManager, requireActivity().lifecycle).apply {
      clearFragment()
      categories.forEachIndexed { index, model ->
        val fragment = ListNewsFragment.newInstance(index, model.param)
        addFragment(fragment, model.nameTab)
      }
    }

    binding.viewPager.run {
      adapter = adapterCategory
    }

    TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
      tab.text = adapterCategory?.getTabName(position)
    }.attach()

    binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
      override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        binding.tabs.selectTab(binding.tabs.getTabAt(position))
      }
    })


  }

  private fun setupObserver() {
    getNewsPopularityFirstSubscribe()
  }

  private fun getNewsPopularityFirstSubscribe() {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.dataNewsPopularity.collect { state ->
          when (state) {
            is Resource.Loading -> {
            }

            is Resource.Success -> {
              state.success { data ->
                onSuccessGetNewsPopularityFirst(data)
              }
            }

            is Resource.Error -> {
              state.error { data ->
                Log.v("DATA INI", data.toString())
              }
            }

            else -> {}
          }
        }
      }
    }
  }

  private fun onSuccessGetNewsPopularityFirst(data: ArticleModel?) {
    binding.viewNewsPopularity.let {
      it.txtTitle.text = data?.title
      getImageNewsUrl(it.imgNews, data?.image)
      it.txtSource.text = data?.source
      getImageNewsSourceUrl(it.imgSource, data?.url)
      it.textDate.text = formatDateForDetails(data?.time)
    }
  }

  private fun loadData() {
    viewModel.getAllNewsByPopularityFirst()
  }

  private fun setupToolBar() {
    binding.toolbarView.let {
      it.imgToolbar.visibility = View.VISIBLE
      it.toolbarMenu.icNotification.visibility = View.VISIBLE
    }
  }
}