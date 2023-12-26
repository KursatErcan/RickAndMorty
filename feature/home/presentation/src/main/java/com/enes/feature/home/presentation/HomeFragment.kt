package com.enes.feature.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.enes.common.presentation.BaseFragment
import com.enes.common.presentation.utils.viewBinding
import com.enes.feature.home.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()

    private val characterListAdapter by lazy{CharacterListAdapter()}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllCharacters()
        bindUI()
    }

    private fun bindUI() {
        binding.rvCharacterList.adapter = characterListAdapter

        viewModel.characterList.observe(viewLifecycleOwner) {
            characterListAdapter.submitList(it)
        }
    }
}