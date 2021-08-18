package com.nerostarx.milkystore.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.nerostarx.milkystore.adapters.ProductCategoriesAdapter
import com.nerostarx.milkystore.adapters.TopPicksAdapter
import com.nerostarx.milkystore.databinding.HomeFragmentBinding
import kotlinx.coroutines.*
import java.lang.Math.abs

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
        pager.clipToPadding = false
        pager.clipChildren = false
        pager.offscreenPageLimit = 4

        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(32))

        transformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        pager.setPageTransformer(transformer)
    }

    private fun initCategories() {
        val recycler = binding.productCategories

        recycler.setHasFixedSize(false)
        recycler.layoutManager = GridLayoutManager(requireContext(),2,VERTICAL,false)
        val adapter = ProductCategoriesAdapter()
        recycler.adapter = adapter
    }
}