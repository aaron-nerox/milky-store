package com.nerostarx.milkystore.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.nerostarx.milkystore.adapters.ProductCategoriesAdapter
import com.nerostarx.milkystore.adapters.TopPicksAdapter
import com.nerostarx.milkystore.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTopPicks()
        initCategories()
    }

    private fun initTopPicks() {
        val pager = binding.topPicksPager
        pager.adapter = TopPicksAdapter()
        pager.orientation = ORIENTATION_HORIZONTAL
        pager.offscreenPageLimit = 3
    }

    private fun initCategories() {
        val recycler = binding.productCategories

        recycler.setHasFixedSize(false)
        recycler.layoutManager = GridLayoutManager(requireContext(),2,VERTICAL,false)
        val adapter = ProductCategoriesAdapter()
        recycler.adapter = adapter
    }
}